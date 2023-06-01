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

	
	@GetMapping("{formato}")
	public ArrayList<Videojuegos>getVideojuegosF(@PathVariable String formato){
        ArrayList<Videojuegos> format = new ArrayList<>();
		for (Videojuegos c1:videojuegosService.getTodosVideojuegos()){
			if(c1.getFormato().equals(formato)){
				format.add(c1);
			}
		}
		return format;
	}
	
	
	@GetMapping("/id/{id}")
	public Optional<Videojuegos> getVideojuegosbyId(@PathVariable("id") int id){
		return this.videojuegosService.getById(id);
	}

	@GetMapping("/nombre/{nombre}")
	public ArrayList<Videojuegos> getVideojuegosbyNombre(@PathVariable("nombre") String nombre){
		return this.videojuegosService.getByNombre(nombre);
	}

	@GetMapping("/plataforma/{plataforma}")
	public ArrayList<Videojuegos> getVideojuegosbyPlataforma(@PathVariable("plataforma") String plataforma){
		return this.videojuegosService.getByPlataforma(plataforma);
	}

	@GetMapping("/marca/{marca}")
	public ArrayList<Videojuegos> getVideojuegosbyMarca(@PathVariable("marca") String marca){
		return this.videojuegosService.getByMarca(marca);
	}

	@GetMapping("/desarrollador/{desarrollador}")
	public ArrayList<Videojuegos> getVideojuegosbyDesarrollador(@PathVariable("desarrollador") String desarrollador){
		return this.videojuegosService.getByDesarrollador(desarrollador);
	}

	@GetMapping("/precio/{precio}")
	public ArrayList<Videojuegos> getVideojuegosbyPrecio(@PathVariable("precio") Integer precio){
		return this.videojuegosService.getByPrecio(precio);
	}

	
	 
	@PostMapping Videojuegos saveVideojuegos(@RequestBody Videojuegos videojuegos){
		return this.videojuegosService.saveVideojuegos(videojuegos);
	}

	@PutMapping(path = "/{id}")
	public Videojuegos updateVideojuegosbyId(@RequestBody Videojuegos request, @PathVariable("id") int id){
		return this.videojuegosService.updateById(request, id);

	}

	@DeleteMapping(path = "/{id}")
    public String deleteVideojuegosbyId(@PathVariable("id") int id){
		boolean ok = this.videojuegosService.deleteVideojuegosById(id);
		if(ok){
			return "Videojuego eliminado con id "+id;
		}else{
			return "No se puedo elimnar el videojuego con id "+id;
		}
	}

	

}
