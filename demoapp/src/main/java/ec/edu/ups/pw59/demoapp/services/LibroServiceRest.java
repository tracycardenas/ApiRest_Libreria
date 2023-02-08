package ec.edu.ups.pw59.demoapp.services;
import org.eclipse.microprofile.faulttolerance.Timeout;

import org.eclipse.microprofile.faulttolerance.Fallback;

import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.opentracing.Traced;

import ec.edu.ups.pweb.demoapp.business.LibroONLocal;
import ec.edu.ups.pweb.demoapp.model.Libro;


@Path("/libros")
@OpenAPIDefinition(info = @Info(title = "LIBROS Resource", description = "Servicios que listar y crear libros", version = "1.0"))
public class LibroServiceRest {
	
	@Inject
	private LibroONLocal libroON;
	
	@GET
	@Retry(maxRetries = 4)
	@Timeout(250)
	@Fallback(fallbackMethod = "getContactosBackup")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	@Traced(operationName = "get-Libros")
	@Timed(name = "getLibro-time", description = "Tiempo de procesamiento de obtener la lista de libros", unit = MetricUnits.MILLISECONDS, absolute = true)
	@Operation(description = "Invocar a endpoint GetLibros con respuesta en JSON", summary = "get libros")
	@APIResponse(responseCode = "200", description = "Libros obtenidos correctamente",
				content = @Content(mediaType = MediaType.APPLICATION_JSON,
					schema = @Schema(implementation = String.class)))
	public List<Libro> getContactos(){
		return libroON.getLibros();
	}
	
	@GET
	@Path("/backup")
	@Retry(maxRetries = 4)
	@Timeout(250)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	@Traced(operationName = "get-Libros")
	@Timed(name = "getLibro-time", description = "Tiempo de procesamiento de obtener la lista de libros", unit = MetricUnits.MILLISECONDS, absolute = true)
	@Operation(description = "Invocar a endpoint GetLibros con respuesta en JSON", summary = "get libros")
	@APIResponse(responseCode = "200", description = "Libros obtenidos correctamente",
				content = @Content(mediaType = MediaType.APPLICATION_JSON,
					schema = @Schema(implementation = String.class)))
	public String getContactosBackup(){
		return "Metodo de respaldo";
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	@Traced(operationName = "post-libros")
	@Counted(description = "Contador crear libro", absolute = true)
	@Timed(name = "postLibro-time", description = "Tiempo de procesamiento de registrar un libro", unit = MetricUnits.MILLISECONDS, absolute = true)
	@Operation(description = "Invocar a endpoint postLibros con respuesta en JSON", summary = "Registro Libro")
	@APIResponse(responseCode = "200", description = "Registro correcto",
			content = @Content(mediaType = MediaType.APPLICATION_JSON,
			schema = @Schema(implementation = Libro.class)))
	public Libro crearContacto( Libro libro) {
		try {
			libroON.insertar(libro);
			return libro;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
}
