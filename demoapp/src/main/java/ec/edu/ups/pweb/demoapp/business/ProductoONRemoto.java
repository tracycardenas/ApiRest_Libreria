package ec.edu.ups.pweb.demoapp.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pweb.demoapp.model.Producto;

@Remote
public interface ProductoONRemoto {
	public void insertarProducto(Producto p) throws Exception;
	public List<Producto> getProductos();
	public Producto buscarP(int id);
	public void actualizarProducto(Producto p) throws Exception;

}
