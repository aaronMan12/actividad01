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


}
