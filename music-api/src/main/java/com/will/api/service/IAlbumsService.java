package com.will.api.service;

import java.util.List;

import com.will.api.entity.Album;

public interface IAlbumsService {
	// este metodo busca todos los registros de la bd
	List<Album> buscarTodos();
}
