package ec.edu.ups.pweb.demoapp.bean;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.pweb.demoapp.business.ClientesONLocal;
import ec.edu.ups.pweb.demoapp.model.Persona;

@WebService
public class ContactosServiceSOAP {
	
	@Inject
	private ClientesONLocal clientesON;
	
	@WebMethod
	public double suma(double a, double b) {
		return a+b;
		
	}
	
	@WebMethod
	public String autorizaarFactura() {
		return "Felicidades";
	}
	
	@WebMethod
	public String transferir(String numeroCuentaOrigen, 
			String numeroCuentaDestino, String bancoDestino, 
			double valor) {
		
		return null;
		
	}
	
	@WebMethod
	public String crearContacto(Persona contacto) {
		try {
			clientesON.insertar(contacto);
			return "OK";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "ERROR";
		}
		
	}
	
	@WebMethod
	public List<Persona> getContactos(){
		return clientesON.getClientes();
	}
}
