package com.consolas.consola;


import java.util.ArrayList;
import java.util.Optional;

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

    public Consola updateById(Consola request, int id) {
        Optional<Consola> busqueda = controller.findById(id);

        if (busqueda.isPresent()) {
            Consola consola = busqueda.get();

            if (!request.getPlataforma().isEmpty()) {
                consola.setPlataforma(request.getPlataforma());
            }

            if (!request.getModelo().isEmpty()) {
                consola.setModelo(request.getModelo());
            }

            if (request.getPrecio()!=0) {
                consola.setPrecio(request.getPrecio());
            }

            if (request.getCantidad()!=0) {
               consola.setCantidad(request.getCantidad());
            }

           controller.save(consola);

            return consola;
        }

        return null;
    }

    public boolean deleteConsolaById(int id) {
        try {
            controller.deleteById(id);

            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
