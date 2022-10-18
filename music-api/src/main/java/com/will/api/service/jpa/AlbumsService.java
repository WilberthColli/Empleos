package com.will.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.will.api.entity.Album;
import com.will.api.repository.AlbumsRepository;
import com.will.api.service.IAlbumsService;

@Service
public class AlbumsService implements IAlbumsService {

	// con esta notacion se va a inyectar en esta variable una instancia de nuestro repositorio
	@Autowired
	private AlbumsRepository repoAlbums;
	
	public List<Album> buscarTodos() {
		return repoAlbums.findAll();
	}

}
