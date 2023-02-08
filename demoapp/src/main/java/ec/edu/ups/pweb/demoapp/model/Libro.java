package ec.edu.ups.pweb.demoapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="libro")
public class Libro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="lib_id")
	private String id;
	
	@Column(name="lib_nombre")
	private String nombre;
	
	@Column(name="lib_cantPag")
	private String cantPag;
	
	@Column(name="lib_id_autor")
	private String id_autor;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCantPag() {
		return cantPag;
	}

	public void setCantPag(String cantPag) {
		this.cantPag = cantPag;
	}

	public String getId_autor() {
		return id_autor;
	}

	public void setId_autor(String id_autor) {
		this.id_autor = id_autor;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", cantPag=" + cantPag + ", id_autor=" + id_autor + "]";
	}
	
	
	
	

}
