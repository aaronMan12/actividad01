package com.consolas.consola;

import java.util.ArrayList;

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

@SpringBootApplication
@RestController
@RequestMapping("/consolas")
public class ConsolaApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsolaApplication.class, args);
	}

	@Autowired
	private ConsolaService consolaService;

	@GetMapping
	public ArrayList<Consola> getConsolas() {
		return this.consolaService.getTodasConsolas();

	}

	@GetMapping("/Modelo/{modelo}")
	public ArrayList<Consola> getConsolFM(@PathVariable("modelo") String modelo){
		return this.consolaService.getForModel(modelo);
	}

	@GetMapping("/Plataforma/{plataforma}")
	public ArrayList<Consola> getConsolFP(@PathVariable("plataforma") String plataforma){
		return this.consolaService.getForPlataform(plataforma);
	}

	@GetMapping("/Precio/{precio}")
	public ArrayList<Consola> getConsolFPr(@PathVariable("precio") int precio){
		return this.consolaService.getForPrice(precio);
	}

	@PostMapping
	public Consola saveConsola(@RequestBody Consola consola) {
		return this.consolaService.saveConsola(consola);
	}

	@DeleteMapping("{id}")
	public String deleteConsolabyId(@PathVariable int id) {
		boolean ok = this.consolaService.deleteConsolaById(id);
		if (ok) {
			return "Consola eliminado con id " + id;
		} else {
			return "No se puedo elimnar la consola con id " + id;
		}
	}

	@PutMapping("/Consola/{id}")
	public Consola updateVideojuegosbyId(@RequestBody Consola request, @PathVariable int id) {
		return this.consolaService.updateById(request, id);
	}

}
