package com.videojuegos.videojuego;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideojuegosService {
    @Autowired
    VideojuegoRepository repositorio;

    public ArrayList<Videojuego> getTodosVideojuegos() {
        return (ArrayList<Videojuego>) repositorio.findAll();
    }

    public Videojuego saveVideojuegos(Videojuego videojuegos) {
        return repositorio.save(videojuegos);
    }

    public Optional<Videojuego> getById(int id) {
        return repositorio.findById(id);
    }

    public ArrayList<Videojuego> getByNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }

    public ArrayList<Videojuego> getByDesarrollador(String desarrollador) {
        return repositorio.findByDesarrollador(desarrollador);
    }

    public ArrayList<Videojuego> getByPlataforma(String plataforma) {
        return repositorio.findByPlataforma(plataforma);
    }

    public ArrayList<Videojuego> getByPrecio(Integer precio) {
        return repositorio.findByPrecio(precio);
    }

    public ArrayList<Videojuego> getByFormato(String formato) {
        return repositorio.findByFormato(formato);
    }

    public Videojuego updateById(Videojuego request, int id) {
        Optional<Videojuego> busqueda = repositorio.findById(id);

        if (busqueda.isPresent()) {
            Videojuego juego = busqueda.get();

            if (!request.getNombre().isEmpty()) {
                juego.setNombre(request.getNombre());
            }

            if (!request.getPlataforma().isEmpty()) {
                juego.setPlataforma(request.getPlataforma());
            }

            if (!request.getFormato().isEmpty()) {
                juego.setFormato(request.getFormato());
            }

            if (!request.getDesarrollador().isEmpty()) {
                juego.setDesarrollador(request.getDesarrollador());
            }

            if (request.getPrecio() != juego.getPrecio()) {
                juego.setPrecio(request.getPrecio());
            }

            repositorio.save(juego);

            return juego;
        }

        return null;
    }

    public boolean deleteVideojuegosById(int id) {
        try {
            repositorio.deleteById(id);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
