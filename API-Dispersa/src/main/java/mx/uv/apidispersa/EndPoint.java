package mx.uv.apidispersa;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.ws.server.endpoint.annotation.Endpoint;
// import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
// import org.springframework.ws.server.endpoint.annotation.RequestPayload;
// import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

// import https.t4is_uv_mx.saludos.BuscarPorIdResponse;
// import https.t4is_uv_mx.saludos.BuscarTodoResponse;
// import https.t4is_uv_mx.saludos.ActualizarRequest;
// import https.t4is_uv_mx.saludos.ActualizarResponse;
// import https.t4is_uv_mx.saludos.BorrarRequest;
// import https.t4is_uv_mx.saludos.BorrarResponse;
// import https.t4is_uv_mx.saludos.BuscarPorIdRequest;
// import https.t4is_uv_mx.saludos.SaludarRequest;
// import https.t4is_uv_mx.saludos.SaludarResponse;

// @Endpoint
// public class EndPoint {
//     @Autowired
//     private ISaludadores isaludador;

//     @PayloadRoot(namespace = "https://t4is.uv.mx/saludos", localPart = "SaludarRequest")
//     @ResponsePayload
//     public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion) {
//         SaludarResponse respuesta = new SaludarResponse();
//         Saludador saludador = new Saludador();

//         saludador.setNombre(peticion.getNombre());

//         isaludador.save(saludador);

//         respuesta.setRespuesta("Hola " + peticion.getNombre());

//         return respuesta;
//     }

//     @PayloadRoot(namespace = "https://t4is.uv.mx/saludos", localPart = "BuscarPorIdRequest")
//     @ResponsePayload
//     public BuscarPorIdResponse Buscar(@RequestPayload BuscarPorIdRequest peticion) {
//         BuscarPorIdResponse respuesta = new BuscarPorIdResponse();

//         Optional<Saludador> resultado = isaludador.findById(peticion.getId());
        
//         if(!resultado.isPresent()){
//             respuesta.setRespuesta("Saludo no encontrado");
            
//             return respuesta;
//         }
        
//         Saludador saludador = resultado.get();

//         respuesta.setRespuesta("Hola " + saludador.getNombre());

//         return respuesta;
//     }

//     @PayloadRoot(namespace = "https://t4is.uv.mx/saludos", localPart = "ActualizarRequest")
//     @ResponsePayload
//     public ActualizarResponse Actualizar(@RequestPayload ActualizarRequest peticion) {
//         ActualizarResponse respuesta = new ActualizarResponse();

//         Optional<Saludador> resultado = isaludador.findById(peticion.getId());

//         if(!resultado.isPresent()) {
//             respuesta.setRespuesta("Saludo no encontrado no encontrado");

//             return respuesta;
//         }
        
//         Saludador saludador = resultado.get();
//         saludador.setNombre(peticion.getNombre());

//         isaludador.save(saludador);
//         respuesta.setRespuesta("Actualización realizada con éxito");

//         return respuesta;
//     }

//     @PayloadRoot(namespace = "https://t4is.uv.mx/saludos", localPart = "BorrarRequest")
//     @ResponsePayload
//     public BorrarResponse Borrar(@RequestPayload BorrarRequest peticion) {
//         BorrarResponse respuesta = new BorrarResponse();

//         Optional<Saludador> resultado = isaludador.findById(peticion.getId());

//         if(!resultado.isPresent()) {
//             respuesta.setRespuesta("Saludo no encontrado no encontrado");

//             return respuesta;
//         }

//         Saludador saludador = resultado.get();
        
//         isaludador.delete(saludador);
//         respuesta.setRespuesta("Eliminado con éxito");

//         return respuesta;
//     }

//     @PayloadRoot(namespace = "https://t4is.uv.mx/saludos", localPart = "BuscarTodoRequest")
//     @ResponsePayload
//     public BuscarTodoResponse Borrar() {
//         BuscarTodoResponse respuesta = new BuscarTodoResponse();
        
//         Iterable<Saludador> resultado = isaludador.findAll();

//         for (Saludador saludador : resultado) {
//             respuesta.getRespuesta().add(saludador.getNombre());
//         }

//         return respuesta;
//     }
// }
