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

import ec.edu.ups.pweb.demoapp.business.ClientesONLocal;
import ec.edu.ups.pweb.demoapp.model.Persona;

@Path("contactos")
public class ContactosServiceRest {
	
	@Inject
	private ClientesONLocal clientesON;
	
	@GET
	@Path("suma")
	@Produces(MediaType.APPLICATION_JSON)
	public double suma(@QueryParam("q")	double a,@QueryParam("b") double b) {
		return a+b;
	}
	
	@POST
	@Path("autorizar")
	@Produces(MediaType.APPLICATION_JSON)
	public String autorizaarFactura(@QueryParam("xml") String facturaxml) {
		return "Felicidades";
	}
	
	@POST
	@Path("transferir")
	@Produces(MediaType.APPLICATION_JSON)
	public String transferir(@FormParam("origen") String numeroCuentaOrigen, 
			@FormParam("destino") String numeroCuentaDestino, @FormParam("banco") String bancoDestino, 
			@FormParam("valor") double valor) {
		
		return null;
		
	}
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public String crearContacto(Persona contacto) {
		try {
			clientesON.insertar(contacto);
			return "OK";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "ERROR";
		}
		
	}
	
	@GET
	//@Produces("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> getContactos(){
		return clientesON.getClientes();
	}
}
