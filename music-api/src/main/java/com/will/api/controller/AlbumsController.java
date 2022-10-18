package com.will.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.will.api.entity.Album;
import com.will.api.service.IAlbumsService;

// agregamos este tipo de controlador ya que se esta usando una restfull
@RestController
@RequestMapping("/api")
public class AlbumsController {

	@Autowired
	private IAlbumsService serviceAlbums;

	@GetMapping("/albums")
	public List<Album> buscarTodos(){
		return serviceAlbums.buscarTodos();
	}
	
	@PostMapping("/albums")
	// cuando guardamos en restfull se usa la anotacion @PostMapping
	// @RequestBody sirve para indicar a spring que busque una peticion en tipo json
	public Album guardar(@RequestBody Album album) {
		serviceAlbums.guardar(album);
		return album;
	}
	
	// @PutMapping permite modificar registros en restfull api
	@PutMapping("/albums")
	public Album modificar(@RequestBody Album album) {
		serviceAlbums.guardar(album);
		return album;
	}
	
	// @DeleteMapping permite eliminar registros en restfull api
	@DeleteMapping("/albums/{id}")
	public String eliminar(@PathVariable("id") int idAlbum) {
		serviceAlbums.eliminar(idAlbum);
		return "Registro Eliminado";
	}

}
