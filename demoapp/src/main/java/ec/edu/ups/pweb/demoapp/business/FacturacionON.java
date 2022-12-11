package ec.edu.ups.pweb.demoapp.business;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pweb.demoapp.dao.FacturaDAO;
import ec.edu.ups.pweb.demoapp.model.DetalleFactura;
import ec.edu.ups.pweb.demoapp.model.Factura;
import ec.edu.ups.pweb.demoapp.model.Persona;

@Stateless
public class FacturacionON implements FacturacionONRemoto{
	
	@Inject
	private FacturaDAO daoFactura;
	

	
	public void insertar(Factura p) throws Exception{
		/*for (int i = 0; i < getFacturas().size(); i++) {
			if (p.getCliente().getCedula().equals(getFacturas().get(i).getCliente().getCedula())) {
				Factura fac;
				Annotation[] Anotaciones = fac.getClass().getAnnotations();
				for (int j = 0; j < Anotaciones.length; j++) {
					System.out.println(Anotaciones);
				}
				//modelBuilder.Conventions.Remove<ManyToManyCascadeDeleteConvention>();
			}
		}*/
		daoFactura.insert(p);
			
	}
	
	public List<Factura> getFacturas(){
		System.out.println("entre al getFacturas de FACTURACIONon");
		System.out.println("FACTURAON: "+daoFactura.getList().get(0).getNumero());
		System.out.println("facturaon: "+daoFactura.getList());
		return daoFactura.getList();
	}
	
	

	
	public Factura getFactura(int codigo) {
		
		Factura factura = daoFactura.read(codigo);
		System.out.println("estoy en FacturacionON"+ factura);
		return factura;
	}

}
