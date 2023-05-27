package com.escuela.Escuela;
import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class EscuelaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscuelaApplication.class, args);
}

ArrayList<Profe> lista=new ArrayList<Profe>();

@PostMapping("/Salones/Profe")
public ArrayList<Profe> creaProfe(){
	String nombre="pepillo";
	int salon=402;
	String ubicacion="FEI";
	Profe p1=new Profe(nombre, salon, ubicacion);
	lista.add(p1);
	return lista;
}

@DeleteMapping("/Salones/Profe{nombre}")
public String borraProfe(@PathVariable String nombre){	
	String msj=null;
	for(Profe profe: lista){
		if(profe.getNombre().equals(nombre)){
			msj="profe borrado"+profe.getNombre();
		}
	}
	return msj;
}

@PutMapping("/Salones/Profe")
public String actualizaProfe(){
	return "Profe actualizado";
}

@GetMapping("Salones/Profe")
public ArrayList<Profe>regresaProfe(){
	return lista;
}


}
