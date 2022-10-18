package com.will.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
