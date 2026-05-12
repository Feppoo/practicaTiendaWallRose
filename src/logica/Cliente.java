package logica;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private List<Orden> ordenes = new ArrayList<>();
	private String id;
	private String nombre;
	private String email;
	
	public Cliente(String id, String nombre, String email, List<Orden> ordenes) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.ordenes = ordenes;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Orden> getListaOrdenes() {
		return ordenes;
	}
	
	public boolean addOrden(Orden orden) {
		return ordenes.add(orden);
	}
	
	public boolean delOrden(Orden orden) {
		return ordenes.remove(orden);
	}
}
