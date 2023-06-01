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

    public Consola saveConsola(Consola consola){
        return controller.save(consola);
    }
}
