package net.itinajero.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.ui.LoginPageGeneratingWebFilter;

//esta notacion permite crear aspectos de la clase para lograr configurarla
@Configuration

//esta anotacion permite agregar soporte a nuestro proyecto
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {
	// aqui se va a inyectar las propiedades de la libreria DataSource
	@Autowired
	private DataSource dataSource;

	// en este metodo podremos evaluar si un usuario esta autenticado o no
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				// en este metodo se define una consulta el cual regresa el username, el password y el estatus del usuario
				.usersByUsernameQuery("select username, password, estatus from Usuarios where username=?")

				// en este metodo se define un aconsulta el cual regresa los perfiles de un usuario
				.authoritiesByUsernameQuery("select u.username, p.perfil from UsuarioPerfil up "
						+ "inner join Usuarios u on u.id = up.idUsuario "
						+ "inner join Perfiles p on p.id = up.idPerfil " + "where u.username = ?");
	}

	// en este metodo se configuran las urls que requieren o no autenticacion
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
				// en este metodo pasamos un arreglo de strings, los cuales son los recursos estaticos
				.antMatchers("/bootstrap/**", "/images/**", "/tinymce/**", "/logos/**").permitAll()
				
				// en este metodo especificamos las vistas publicas
				.antMatchers("/", "/signup", "/search","/bcrypt/**","/vacantes/view/**").permitAll()
				
				// Asignar permisos a URLs por ROLES
				.antMatchers("/vacantes/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
				.antMatchers("/categorias/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
				.antMatchers("/usuarios/**").hasAnyAuthority("ADMINISTRADOR")

				// en este metodo especificamos las demás urls que no son publicas y que usan autenticacion
				.anyRequest().authenticated()
					
				// este metodo sirve para decir que el formulario de login no requiere autenticacion
				.and().formLogin().loginPage("/login").permitAll();
		}
		
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

}