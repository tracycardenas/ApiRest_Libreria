package ec.edu.ups.pweb.demoapp.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pweb.demoapp.business.ClientesONLocal;
import ec.edu.ups.pweb.demoapp.model.Persona;

@Named
@RequestScoped
public class ClientesBean {
	
	@Inject
	private ClientesONLocal clientesON;

	private String cedula;
	/*
	private String nombre;
	private String direccion;*/
	
	
	private Persona persona = new Persona();
	
	
	private List<Persona> clientes;
	
	
	public ClientesBean() {
		
	}
	
	@PostConstruct
	public void init() {
		this.loadCLientes();
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		System.out.println("set " + cedula);
		this.cedula = cedula;
	}

	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public List<Persona> getClientes() {
		return clientes;
	}
	public void setClientes(List<Persona> clientes) {
		this.clientes = clientes;
	}
	
	public void loadData() {
		if(cedula==null)
			return;
		
		Persona p = clientesON.getCliente(cedula);
		persona = p;
	}
	
	public void loadDataEditar() {
		Persona p = clientesON.getCliente(persona.getCedula());
		persona = p;
	}
	
	
	public String guardar() {
		
		System.out.println("Guaradndo " + this.persona.getNombre());
	
		
		try {
			clientesON.guardar(this.persona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "listado-personas?faces-redirect=true";
	}
	
	public String editar(String cedula){
		System.out.println(cedula);
		return "persona?faces-redirect=true&id="+cedula;
	}
	
	public void loadCLientes() {
		this.clientes = clientesON.getClientes();
	}
	
}

