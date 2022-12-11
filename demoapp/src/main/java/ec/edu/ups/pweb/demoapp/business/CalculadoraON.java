package ec.edu.ups.pweb.demoapp.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pweb.demoapp.dao.OperacionDAO;
import ec.edu.ups.pweb.demoapp.model.Operacion;

@Stateless
public class CalculadoraON  implements CalculadoraONRemoto, CalculadoraONLocal{
	
	@Inject
	private OperacionDAO operacionDao;
	
	public double suma(double a, double b) {
		double c = a+b;
		
		Operacion op = new Operacion();
		op.setA(a);
		op.setB(b);
		op.setOperacion("+");
		op.setR(c);
		operacionDao.insert(op);
	
		System.out.println("SUMANDO DESDE SERVER: "+a+" + "+b);
		//logica para guardar suma en BD
		return c;
	}
	
	public double resta(double a, double b) {
		double c = a-b;
		Operacion op = new Operacion();
		op.setA(a);
		op.setB(b);
		op.setOperacion("-");
		op.setR(c);
		operacionDao.insert(op);
	
		System.out.println("RESTANDO DESDE SERVER: "+a+" - "+b);
		//logica para guardar resta en BD
		return c;
	}
	
	public List<Operacion> getSumas(){
		return operacionDao.getList("+");
		
	}
	
	public List<Operacion> getRestas(){
		return operacionDao.getList("-");
		
	}

}
