package ec.edu.ups.pweb.demoapp.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pweb.demoapp.model.Operacion;

@Remote
public interface CalculadoraONRemoto {
	
	public double suma(double a, double b);
	public double resta(double a, double b);
	public List<Operacion> getSumas();
	public List<Operacion> getRestas();

}
