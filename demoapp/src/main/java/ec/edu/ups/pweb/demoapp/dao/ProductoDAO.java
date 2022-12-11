package ec.edu.ups.pweb.demoapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import ec.edu.ups.pweb.demoapp.model.Producto;

@Stateless
public class ProductoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Producto op) {
		em.persist(op);
	}
	
	public void update (Producto op) {
		em.merge(op);
	}
	
	public Producto read (int id) {
		Producto op = em.find(Producto.class, id);
		return op;
	}
	
	public void delete(int id) {
		Producto op = em.find(Producto.class, id);
		em.remove(op);
	}
	
	
	public List<Producto> getList(){
		List<Producto> listado = new ArrayList<Producto>();
		
		//JPQL  -> SQL
		String jpql = "SELECT op FROM Producto op";
	
		
		Query query = em.createQuery(jpql,Producto.class);

		listado = query.getResultList();
		
		return listado;
		
	}

}
