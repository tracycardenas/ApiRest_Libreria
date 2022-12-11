package ec.edu.ups.pw59.demoapp.services;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.pweb.demoapp.business.LibroONLocal;
import ec.edu.ups.pweb.demoapp.model.Libro;

@Path("libros")
public class LibroServiceRest {
	
	@Inject
	private LibroONLocal libroON;
	
	@GET
	//@Produces("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> getContactos(){
		return libroON.getLibros();
	}
}
