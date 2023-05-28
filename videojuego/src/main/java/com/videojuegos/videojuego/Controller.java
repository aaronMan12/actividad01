package com.videojuegos.videojuego;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Controller extends CrudRepository <Videojuegos, Integer> {
    
}
