package com.consolas.consola;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsolaService {
    
    @Autowired
    Controller controller;
    public ArrayList<Consola> getTodasConsolas(){
        return (ArrayList<Consola>) controller.findAll();
    }

    /*public ArrayList<Consola> getConsolaPorPlataforma(String plataforma){
        ArrayList<Consola>peticion=new ArrayList<Consola>(); 
        for (Consola c1 : controller.findAll()) {
            if(c1.getPlataforma().equals(plataforma)){
              peticion.add(c1);  
            }
        }
        return peticion;
    }*/

    public Consola saveConsola(Consola consola){
        return controller.save(consola);
    }
}
