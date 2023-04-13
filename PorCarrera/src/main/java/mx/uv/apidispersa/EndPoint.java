package mx.uv.apidispersa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BuscarPorCarreraRequest;
import https.t4is_uv_mx.saludos.BuscarPorCarreraResponse;



@Endpoint
public class EndPoint {
     @Autowired
     private IAlumnos alumno;
    
       @PayloadRoot(namespace = "https:  t4is.uv.mx saludos", localPart = "BuscarPorCarrera")
       @ResponsePayload
       public BuscarPorCarreraResponse carrera(BuscarPorCarreraRequest a) {
           BuscarPorCarreraResponse respuesta = new BuscarPorCarreraResponse();
           Iterable<Alumno> todoslosalumnos= alumno.findAll();
        
           for (Alumno s:todoslosalumnos) {
           if(s.getCarrera().equals(a.getCarrera())){
            respuesta.setNombre(s.getNombre());
            respuesta.setSemestre(s.getSemestre());
            respuesta.setSexo(s.getSexo());
            respuesta.setCarrera(s.getCarrera());
            respuesta.setFechaNacimiento(s.getFechaNacimiento());
           }
        }
           return respuesta;
       }
   }
