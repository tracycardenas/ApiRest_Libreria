package ec.edu.ups.pweb.demoapp.business;

import javax.ejb.Local;

@Local
public interface CalculadoraONLocal {
	
	public double suma(double a, double b);

}
