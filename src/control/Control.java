package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import logica.Cliente;
import logica.Estado;
import logica.Producto;
import logica.Orden;

public class Control {
	private Map<String,Cliente> listaClientes = new HashMap<>();
	private Map<Integer,Producto> listaProductos = new HashMap<>();
	private Map<Integer,Orden> listaOrdenes = new HashMap<>();
	
	public Control() {
	}
	
	public List<Cliente> getListaClientes() {
		return new ArrayList<Cliente>(listaClientes.values());
	}
	
	public Cliente getCliente(String id) throws Exception {
		if (!listaClientes.containsKey(id)) {
			throw new Exception("Error: Cliente no registrado.");
		}
		return listaClientes.get(id);
	}

	public List<Orden> getOrdenesCliente(Estado estado) {
		List<Orden> lista = new ArrayList<Orden>();
		for (Cliente actual : listaClientes.values()) {
			for (Orden fijada : actual.getListaOrdenes()) {
				if (fijada.getEstado().equals(estado)) {
					lista.add(fijada);
				}
			}
		}
		return lista;
	}
	
	public void agregarCliente(String id, String nombre, String email) {
		Cliente c = new Cliente(id, nombre, email);
		listaClientes.put(id, c);
	}
	
	public void actualizarCliente(String id, String nombre, String email) {
		//Por implementar...
	}
}
