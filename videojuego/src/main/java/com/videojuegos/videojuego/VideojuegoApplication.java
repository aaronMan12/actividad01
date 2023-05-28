package com.videojuegos.videojuego;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

@RestController
@RequestMapping("/videojuegos")
@SpringBootApplication
public class VideojuegoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideojuegoApplication.class, args);
	}

	@Autowired
	private VideojuegosService videojuegosService;

	@GetMapping
	public ArrayList<Videojuegos>getVideojuegos(){
		return this.videojuegosService.getTodosVideojuegos();
	}

	
	/*@GetMapping(value = "/videojuegos", params = "formato")
	public ArrayList<Videojuegos>getVideojuegosF(@PathVariable String formato){
        ArrayList<Videojuegos> format = new ArrayList<>();
		for (Videojuegos c1:videojuegosService.getTodosVideojuegos()){
			if(c1.getFormato().equals(formato)){
				format.add(c1);
			}
		}
		return format;
	}*/

	@GetMapping(path = "/{id}")
	public Optional<Videojuegos> getVideojuegosbyId(@PathVariable("id") int id){
		return this.videojuegosService.getById(id);
	}
	 

	@PostMapping Videojuegos saveVideojuegos(@RequestBody Videojuegos videojuegos){
		return this.videojuegosService.saveVideojuegos(videojuegos);
	}

	@PutMapping(path = "/{id}")
	public Videojuegos updateVideojuegosbyId(@RequestBody Videojuegos request, @PathVariable("id") int id){
		return this.videojuegosService.updateById(request, id);

	}

	


}
