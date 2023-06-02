package com.consolas.consola;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsolaService {
    @Autowired
    Controller controller;
  

    public Consola saveConsola(Consola consola){
        return controller.save(consola);
    }

    public ArrayList<Consola> getTodasConsolas(){
        return (ArrayList<Consola>) controller.findAll();
    }

    public ArrayList<Consola> getForModel(String model){
        return (ArrayList<Consola>) controller.findBymodelo(model);
    }

    public ArrayList<Consola> getForPrice(int price){
        return (ArrayList<Consola>) controller.findByprecio(price);
    }

    public ArrayList<Consola> getForPlataform(String plataform){
        return (ArrayList<Consola>) controller.findByPlataforma(plataform);
    }
}
