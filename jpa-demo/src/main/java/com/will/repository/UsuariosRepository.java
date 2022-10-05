package com.will.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.will.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
