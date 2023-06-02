package com.videojuegos.videojuego;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideojuegoRepository extends CrudRepository<Videojuego, Integer> {

    public ArrayList<Videojuego> findByNombre(String nombre);

    public ArrayList<Videojuego> findByPlataforma(String plataforma);

    public ArrayList<Videojuego> findByFormato(String formato);

    public ArrayList<Videojuego> findByDesarrollador(String desarrollador);

    public ArrayList<Videojuego> findByPrecio(Integer precio);

}
