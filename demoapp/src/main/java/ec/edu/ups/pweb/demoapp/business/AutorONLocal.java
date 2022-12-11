package ec.edu.ups.pweb.demoapp.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pweb.demoapp.model.Autor;

@Local
public interface AutorONLocal {
	public void insertar(Autor p) throws Exception;
	public List<Autor> getAutores();
	public Autor buscarAutor(String cedula) ;
	public void eliminarAutor(String cedula);
	public void actualizar(Autor p);
	public Autor getAutor(String cedula);
	public void guardar(Autor p) throws Exception;

}
