package com.videojuegos.videojuego;

import java.util.ArrayList;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Controller extends CrudRepository <Videojuegos, Integer> {
     
    public ArrayList<Videojuegos> findByNombre(String nombre);
    public ArrayList<Videojuegos> findByPlataforma(String plataforma);
    public ArrayList<Videojuegos> findByMarca(String marca);
    public ArrayList<Videojuegos> findByDesarrollador(String desarrollador);
    public ArrayList<Videojuegos> findByPrecio(Integer precio);




}
