package ec.edu.ups.pweb.demoapp.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pweb.demoapp.model.Libro;

@Local
public interface LibroONLocal {
	public void insertar(Libro p) throws Exception;
	public List<Libro> getLibros();
	public Libro buscarLibro(String id) ;
	public void eliminarLibro(String id);
	public void actualizar(Libro p);
	public Libro getLibro(String id);
	public void guardar(Libro p) throws Exception;

}
