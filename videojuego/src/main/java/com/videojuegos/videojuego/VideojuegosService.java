package com.videojuegos.videojuego;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VideojuegosService {
    
    @Autowired

    Controller controller;
    public ArrayList<Videojuegos>getTodosVideojuegos(){
        return (ArrayList<Videojuegos>) controller.findAll();
    }

    public Videojuegos saveVideojuegos(Videojuegos videojuegos){
        return controller.save(videojuegos);
    }

    public Optional<Videojuegos> getById(int id){
        return controller.findById(id);
    }

    public ArrayList<Videojuegos> getByNombre(String nombre){
        return controller.findByNombre(nombre);
    }

    public ArrayList<Videojuegos> getByDesarrollador(String desarrollador){
        return controller.findByDesarrollador(desarrollador);
    }

    public ArrayList<Videojuegos> getByPlataforma(String plataforma){
        return controller.findByPlataforma(plataforma);
    }

    public ArrayList<Videojuegos> getByMarca(String marca){
        return controller.findByMarca(marca);
    }

    public ArrayList<Videojuegos> getByPrecio(Integer precio){
        return controller.findByPrecio(precio);
    }



    public Videojuegos updateById(Videojuegos request, int id){
        Videojuegos juego = controller.findById(id).get();
        juego.setNombre(request.getNombre());
        juego.setPlataforma(request.getPlataforma());
        juego.setMarca(request.getMarca());
        juego.setFormato(request.getFormato());
        juego.setDesarrollador(request.getDesarrollador());
        juego.setPrecio(request.getPrecio());
        controller.save(juego);

        return juego;
    }

    public boolean deleteVideojuegosById(int id){
        try{
         controller.deleteById(id);
         return true;

        }catch(Exception e){
         return false;
        }
        
    }

   

}
