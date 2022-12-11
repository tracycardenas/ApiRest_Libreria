package ec.edu.ups.pweb.demoapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pweb.demoapp.model.Operacion;

@Stateless
public class OperacionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Operacion op) {
		em.persist(op);
	}
	
	public void update (Operacion op) {
		em.merge(op);
	}
	
	public Operacion read (int id) {
		Operacion op = em.find(Operacion.class, id);
		return op;
	}
	
	public void delete(int id) {
		Operacion op = em.find(Operacion.class, id);
		em.remove(op);
	}
	
	
	public List<Operacion> getList(String operacion){
		List<Operacion> listado = new ArrayList<Operacion>();
		
		//JPQL  -> SQL
		String jpql = "SELECT op FROM Operacion op 	"
				+ "WHERE op.operacion= ?1 "
				+ "AND op.r > ?2";
		
		Query query = em.createQuery(jpql,Operacion.class);
		query.setParameter(1, operacion);
		query.setParameter(2, 20.0);
		listado = query.getResultList();
		
		return listado;
		
	}

}
