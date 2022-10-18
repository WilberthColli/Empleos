package com.will.api.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// esta notacion hace que la clase sea una entidad
@Entity
// esta notacion va a mapear la clase album con la tabla albums de la bd musicdb
@Table(name="albums")
public class Album {

	// esta notacion sirve para definir cual sera la llave primaria
	@Id
	// significa que sera autoincrementable
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private Date lanzado;
	private String genero;
	private Double precio;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getLanzado() {
		return lanzado;
	}
	public void setLanzado(Date lanzado) {
		this.lanzado = lanzado;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Album [id=" + id + ", titulo=" + titulo + ", lanzado=" + lanzado + ", genero=" + genero + ", precio="
				+ precio + "]";
	}

}