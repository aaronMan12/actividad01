package com.consolas.consola;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public ArrayList<Consola>getConsolas(){
	return this.consolaService.getTodasConsolas();
	
}

/*@GetMapping("{plataforma}")
public ArrayList<Consola>getConsolasPP(@PathVariable String plataforma){
	return this.consolaService.getConsolaPorPlataforma(plataforma);
}*/

@PostMapping
public Consola saveCoansola(@RequestBody Consola consola){
return this.consolaService.saveConsola(consola);
}

}
