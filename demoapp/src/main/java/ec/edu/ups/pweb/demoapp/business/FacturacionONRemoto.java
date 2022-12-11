package ec.edu.ups.pweb.demoapp.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pweb.demoapp.model.Factura;

@Remote
public interface FacturacionONRemoto {
	public void insertar(Factura p) throws Exception;
	public List<Factura> getFacturas();
	public Factura getFactura(int codigo);

}
