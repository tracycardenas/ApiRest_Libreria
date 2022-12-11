package ec.edu.ups.pweb.demoapp.business;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pweb.demoapp.dao.AutorDAO;
import ec.edu.ups.pweb.demoapp.model.Autor;

@Stateless
public class AutorON implements AutorONRemoto, AutorONLocal{
	
	@Inject
	private AutorDAO daoAutor;
	
	public void insertar(Autor p) throws Exception {
		
		daoAutor.insert(p);
		
			
	}
	
	public void guardar(Autor p) throws Exception {
		if(daoAutor.read(p.getCedula())==null)
			daoAutor.insert(p);
		else
			daoAutor.update(p);
	}

	public Autor getAutor(String cedula) {
		return daoAutor.read(cedula);
	}

	
	public List<Autor> getAutores(){
		return daoAutor.getList();
	}
	
	public Autor buscarAutor(String cedula) {
		return daoAutor.read(cedula);
	}
	
	public void eliminarAutor(String cedula) {
		daoAutor.delete(cedula);
	}
	
	public void actualizar(Autor p) {
		daoAutor.update(p);
	}


}
