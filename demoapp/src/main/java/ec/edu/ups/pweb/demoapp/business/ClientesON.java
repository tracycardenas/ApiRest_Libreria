package ec.edu.ups.pweb.demoapp.business;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pweb.demoapp.dao.PersonaDAO;
import ec.edu.ups.pweb.demoapp.model.Persona;

@Stateless
public class ClientesON implements ClientesONRemoto, ClientesONLocal{
	
	@Inject
	private PersonaDAO daoPersona;
	
	public void insertar(Persona p) throws Exception {
		
		daoPersona.insert(p);
		
			
	}
	
	public void guardar(Persona p) throws Exception {
		if(daoPersona.read(p.getCedula())==null)
			daoPersona.insert(p);
		else
			daoPersona.update(p);
	}

	public Persona getCliente(String cedula) {
		return daoPersona.read(cedula);
	}

	
	public List<Persona> getClientes(){
		return daoPersona.getList();
	}
	
	public Persona buscarCliente(String cedula) {
		return daoPersona.read(cedula);
	}
	
	public void eliminarCliente(String cedula) {
		daoPersona.delete(cedula);
	}
	
	public void actualizar(Persona p) {
		daoPersona.update(p);
	}

}
