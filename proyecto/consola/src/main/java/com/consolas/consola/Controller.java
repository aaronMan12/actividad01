package com.consolas.consola;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Controller extends CrudRepository<Consola,Integer>{
}

