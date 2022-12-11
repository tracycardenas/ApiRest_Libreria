package ec.edu.ups.pweb.demoapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pweb.demoapp.model.Autor;

@Stateless
public class AutorDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Autor op) {
		em.persist(op);
	}
	
	public void update (Autor op) {
		em.merge(op);
	}
	
	public Autor read (String cedula) {
		Autor op = em.find(Autor.class, cedula);
		return op;
	}
	
	public void delete(String cedula) {
		Autor op = em.find(Autor.class, cedula);
		em.remove(op);
	}
	
	
	public List<Autor> getList(){
		List<Autor> listado = new ArrayList<Autor>();
		
		//JPQL  -> SQL
		String jpql = "SELECT op FROM autor op";
	
		
		Query query = em.createQuery(jpql,Autor.class);

		listado = query.getResultList();
		
		return listado;
		
	}

}
