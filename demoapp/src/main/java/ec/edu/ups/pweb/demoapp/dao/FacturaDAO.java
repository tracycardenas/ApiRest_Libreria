package ec.edu.ups.pweb.demoapp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pweb.demoapp.model.DetalleFactura;
import ec.edu.ups.pweb.demoapp.model.Factura;
import ec.edu.ups.pweb.demoapp.model.Operacion;
import ec.edu.ups.pweb.demoapp.model.Persona;

@Stateless
public class FacturaDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(Factura op) {
		em.persist(op);
		
	}

	public void update(Factura op) {
		em.merge(op);
	}

	public Factura read(int id) {
		Factura op = em.find(Factura.class, id);
		op.getDetalles().size();
		op.getCliente().getCedula();
		op.getDetalles().get(0).getProducto().getCodigo();
		System.out.println(op);
		return op;
	}

	public void delete(int id) {
		Factura op = em.find(Factura.class, id);
		em.remove(op);
	}

	public List<Factura> getList() { //Lazy
		List<Factura> listado = new ArrayList<Factura>();

		// JPQL -> SQL
		String jpql = "SELECT op FROM Factura op";

		Query query = em.createQuery(jpql, Factura.class);

		listado = query.getResultList();
		System.out.println("LISTFACDAO: "+listado);

		return listado;

	}

	public void insertDet(DetalleFactura op) {
		em.persist(op);
	}

	public void updateDet(DetalleFactura op) {
		em.merge(op);
	}

	public DetalleFactura readDet(int id) {
		DetalleFactura op = em.find(DetalleFactura.class, id);
		return op;
	}

	public void deleteDet(int id) {
		DetalleFactura op = em.find(DetalleFactura.class, id);
		em.remove(op);
	}

	public List<DetalleFactura> getListDet() {
		List<DetalleFactura> listado = new ArrayList<DetalleFactura>();

		// JPQL -> SQL
		String jpql = "SELECT op FROM DetalleFactura op";

		Query query = em.createQuery(jpql, DetalleFactura.class);

		listado = query.getResultList();

		return listado;

	}

}
