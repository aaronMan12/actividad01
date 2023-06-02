package com.consolas.consola;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsolaRepository extends CrudRepository<Consola, Integer> {
    public ArrayList<Consola> findBymodelo(String modelo);

    public ArrayList<Consola> findByPlataforma(String plataforma);

    public ArrayList<Consola> findByprecio(int Precio);
}
