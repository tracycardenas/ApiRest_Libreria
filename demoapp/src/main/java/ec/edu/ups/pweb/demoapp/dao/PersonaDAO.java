package ec.edu.ups.pweb.demoapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pweb.demoapp.model.Operacion;
import ec.edu.ups.pweb.demoapp.model.Persona;

@Stateless
public class PersonaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Persona op) {
		em.persist(op);
	}
	
	public void update (Persona op) {
		em.merge(op);
	}
	
	public Persona read (String cedula) {
		Persona op = em.find(Persona.class, cedula);
		return op;
	}
	
	public void delete(String cedula) {
		Persona op = em.find(Persona.class, cedula);
		em.remove(op);
	}
	
	
	public List<Persona> getList(){
		List<Persona> listado = new ArrayList<Persona>();
		
		//JPQL  -> SQL
		String jpql = "SELECT op FROM Persona op";
	
		
		Query query = em.createQuery(jpql,Persona.class);

		listado = query.getResultList();
		
		return listado;
		
	}

}
