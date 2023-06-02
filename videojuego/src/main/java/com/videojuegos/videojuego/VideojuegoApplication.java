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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@SpringBootApplication
public class VideojuegoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideojuegoApplication.class, args);
	}

	@Autowired
	private VideojuegosService videojuegosService;

	@PostMapping("/videojuegos")
	public Videojuego saveVideojuegos(@RequestBody Videojuego videojuegos) {
		return this.videojuegosService.saveVideojuegos(videojuegos);
	}

	@DeleteMapping("/videojuegos/{id}")
	public String deleteVideojuegosbyId(@PathVariable int id) {
		boolean ok = this.videojuegosService.deleteVideojuegosById(id);
		if (ok) {
			return "Videojuego eliminado con id " + id;
		} else {
			return "No se puedo elimnar el videojuego con id " + id;
		}
	}

	@PutMapping("/videojuegos/{id}")
	public Videojuego updateVideojuegosbyId(@RequestBody Videojuego request, @PathVariable int id) {
		return this.videojuegosService.updateById(request, id);
	}

	@GetMapping("/videojuegos/{id}")
	public Optional<Videojuego> getVideojuegosbyId(@PathVariable int id) {
		return this.videojuegosService.getById(id);
	}

	@GetMapping("/videojuegos")
	public ArrayList<Videojuego> getVideojuegos() {
		return this.videojuegosService.getTodosVideojuegos();
	}

	@GetMapping("/videojuegos/nombre/{nombre}")
	public ArrayList<Videojuego> getVideojuegosbyNombre(@PathVariable("nombre") String nombre) {
		return this.videojuegosService.getByNombre(nombre);
	}

	@GetMapping("/videojuegos/plataforma/{plataforma}")
	public ArrayList<Videojuego> getVideojuegosbyPlataforma(@PathVariable("plataforma") String plataforma) {
		return this.videojuegosService.getByPlataforma(plataforma);
	}

	@GetMapping("/videojuegos/desarrollador/{desarrollador}")
	public ArrayList<Videojuego> getVideojuegosbyDesarrollador(@PathVariable String desarrollador) {
		return this.videojuegosService.getByDesarrollador(desarrollador);
	}

	@GetMapping("/videojuegos/precio/{precio}")
	public ArrayList<Videojuego> getVideojuegosbyPrecio(@PathVariable Integer precio) {
		return this.videojuegosService.getByPrecio(precio);
	}

	@GetMapping("/videojuegos/formato/{formato}")
	public ArrayList<Videojuego> getVideojuegosF(@PathVariable String formato) {
		return this.videojuegosService.getByFormato(formato);
	}
}
