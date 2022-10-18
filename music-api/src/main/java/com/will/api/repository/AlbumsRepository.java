package com.will.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.will.api.entity.Album;

public interface AlbumsRepository extends JpaRepository<Album, Integer> {

}
