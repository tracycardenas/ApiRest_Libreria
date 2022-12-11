package ec.edu.ups.pweb.demoapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Factura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "fac_codigo")
	private int numero;
	
	private Date fecha;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="per_cedula")
	private Persona cliente;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fac_codigo")
	private List<DetalleFactura> detalles;
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Persona getCliente() {
		return cliente;
	}
	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}
	public List<DetalleFactura> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
	public void addDetalle(DetalleFactura det) {
		if(detalles == null) 
			detalles = new ArrayList<DetalleFactura>();
		 
		detalles.add(det);
		
	}
	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", fecha=" + fecha + ", cliente=" + cliente + ", detalles=" + detalles
				+ "]";
	}
	
	
	
}
