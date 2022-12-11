package ec.edu.ups.pweb.demoapp.business;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pweb.demoapp.dao.LibroDAO;
import ec.edu.ups.pweb.demoapp.model.Libro;

@Stateless
public class LibroON implements LibroONRemoto, LibroONLocal{
	
	@Inject
	private LibroDAO daoLibro;
	
	public void insertar(Libro p) throws Exception {
		
		daoLibro.insert(p);
		
			
	}
	
	public void guardar(Libro p) throws Exception {
		if(daoLibro.read(p.getId())==null)
			daoLibro.insert(p);
		else
			daoLibro.update(p);
	}

	public Libro getLibro(String id) {
		return daoLibro.read(id);
	}

	
	public List<Libro> getLibros(){
		return daoLibro.getList();
	}
	
	public Libro buscarLibro(String id) {
		return daoLibro.read(id);
	}
	
	public void eliminarLibro(String id) {
		daoLibro.delete(id);
	}
	
	public void actualizar(Libro p) {
		daoLibro.update(p);
	}


}
