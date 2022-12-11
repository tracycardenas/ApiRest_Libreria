package ec.edu.ups.pweb.demoapp.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pweb.demoapp.dao.ProductoDAO;
import ec.edu.ups.pweb.demoapp.model.Producto;

@Stateless
public class ProductoON implements ProductoONRemoto{
	
	@Inject
	private ProductoDAO proDAO;
	
	public void insertarProducto(Producto p) throws Exception {
		proDAO.insert(p);	
	}
	
	public List<Producto> getProductos(){
		return proDAO.getList();
	}
	
	public Producto buscarP(int id) {
		Producto p = proDAO.read(id);
		return p;
	}
	
	public void actualizarProducto(Producto p) throws Exception {
		proDAO.update(p);
	}

}
