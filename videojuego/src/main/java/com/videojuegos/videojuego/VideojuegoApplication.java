package com.videojuegos.videojuego;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping Videojuegos saveVideojuegos(@RequestBody Videojuegos videojuegos){
		return this.videojuegosService.saveVideojuegos(videojuegos);
	}

}
