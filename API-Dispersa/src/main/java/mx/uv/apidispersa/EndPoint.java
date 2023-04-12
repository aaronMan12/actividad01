package mx.uv.apidispersa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.alumnos.ActualizarRequest;
import https.t4is_uv_mx.alumnos.ActualizarResponse;
import https.t4is_uv_mx.alumnos.BorrarRequest;
import https.t4is_uv_mx.alumnos.BorrarResponse;
import https.t4is_uv_mx.alumnos.BuscarPorIdRequest;
import https.t4is_uv_mx.alumnos.BuscarPorIdResponse;
import https.t4is_uv_mx.alumnos.GuardarRequest;
import https.t4is_uv_mx.alumnos.GuardarResponse;

@Endpoint
public class EndPoint {
    @Autowired
    private IAlumnos ialumno;

    @PayloadRoot(namespace = "https://t4is.uv.mx/alumnos", localPart = "GuardarRequest")
    @ResponsePayload
    public GuardarResponse Guardar(@RequestPayload GuardarRequest peticion) {
        GuardarResponse respuesta = new GuardarResponse();
        Alumno alumno = new Alumno();

        alumno.setNombre(peticion.getNombre());
        alumno.setSemestre(peticion.getSemestre());
        alumno.setSexo(peticion.getSexo());
        alumno.setCarrera(peticion.getCarrera());
        alumno.setFechaNacimiento(peticion.getFechaNacimiento());

        ialumno.save(alumno);

        respuesta.setRespuesta("Alumno guardado con éxito");

        return respuesta;
    }

    @PayloadRoot(namespace = "https://t4is.uv.mx/alumnos", localPart = "BuscarPorIdRequest")
    @ResponsePayload
    public BuscarPorIdResponse BuscarPorId(@RequestPayload BuscarPorIdRequest peticion) {
        BuscarPorIdResponse respuesta = new BuscarPorIdResponse();

        Optional<Alumno> resultado = ialumno.findById(peticion.getId());

        respuesta.setNombre(resultado.get().getNombre());
        respuesta.setSemestre(resultado.get().getSemestre());
        respuesta.setSexo(resultado.get().getSexo());
        respuesta.setCarrera(resultado.get().getCarrera());
        respuesta.setFechaNacimiento(resultado.get().getFechaNacimiento());

        return respuesta;
    }

    @PayloadRoot(namespace = "https://t4is.uv.mx/alumnos", localPart = "ActualizarRequest")
    @ResponsePayload
    public ActualizarResponse Actualizar(@RequestPayload ActualizarRequest peticion) {
        ActualizarResponse respuesta = new ActualizarResponse();

        Optional<Alumno> resultado = ialumno.findById(peticion.getId());

        if(!resultado.isPresent()) {
            return null;
        }

        Alumno alumno = resultado.get();

        if(!peticion.getNombre().isBlank()) {
            alumno.setNombre(peticion.getNombre());
        }

        if(peticion.getSemestre() != 0) {
            alumno.setSemestre(peticion.getSemestre());
        }

        if(!peticion.getSexo().isBlank()) {
            alumno.setSexo(peticion.getSexo());
        }

        if(!peticion.getCarrera().isBlank()) {
            alumno.setCarrera(peticion.getCarrera());
        }
        
        if(!peticion.getFechaNacimiento().isBlank()) {
            alumno.setFechaNacimiento(peticion.getFechaNacimiento());
        }

        ialumno.save(alumno);
        respuesta.setRespuesta("Actualización realizada exitosamente");

        return respuesta;
    }

    @PayloadRoot(namespace = "https://t4is.uv.mx/alumnos", localPart = "BorrarRequest")
    @ResponsePayload
    public BorrarResponse Actualizar(@RequestPayload BorrarRequest peticion) {
        BorrarResponse respuesta = new BorrarResponse();

        Optional<Alumno> resultado = ialumno.findById(peticion.getId());

        if(!resultado.isPresent()){
            return null;
        }
        
        ialumno.delete(resultado.get());
        respuesta.setRespuesta("Se borró exitosamente");


        return respuesta;
    }

    // @PayloadRoot(namespace = "https://t4is.uv.mx/saludos", localPart =
    // "BuscarTodoRequest")
    // @ResponsePayload
    // public BuscarTodoResponse Borrar() {
    // BuscarTodoResponse respuesta = new BuscarTodoResponse();

    // Iterable<Saludador> resultado = isaludador.findAll();

    // for (Saludador saludador : resultado) {
    // respuesta.getRespuesta().add(saludador.getNombre());
    // }

    // return respuesta;
    // }
}
