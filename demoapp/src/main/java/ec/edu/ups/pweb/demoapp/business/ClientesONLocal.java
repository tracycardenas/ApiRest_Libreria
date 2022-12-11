package ec.edu.ups.pweb.demoapp.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pweb.demoapp.model.Persona;

@Local
public interface ClientesONLocal {
	public void insertar(Persona p) throws Exception;
	public List<Persona> getClientes();
	public Persona buscarCliente(String cedula) ;
	public void eliminarCliente(String cedula);
	public void actualizar(Persona p);
	public Persona getCliente(String cedula);
	public void guardar(Persona p) throws Exception;

}
