package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import logica.Cliente;
import logica.Estado;
import logica.Linea;
import logica.Producto;
import logica.Unidad;
import logica.Orden;

public class Control {
	private static Control instance = new Control();
	private Map<String,Cliente> listaClientes = new HashMap<>();
	private Map<Integer,Producto> listaProductos = new HashMap<>();
	private Map<Integer,Orden> listaOrdenes = new HashMap<>();
	
	private Control() {
	}
	
	public static Control getInstance() {
		return instance;
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
		List<Orden> lTemp = new ArrayList<Orden>();
		for (Orden actual : listaOrdenes.values()) {
			if (actual.getEstado().equals(estado)) {
				lTemp.add(actual);
			}
		}
		return lTemp;
	}
	
	public void agregarCliente(String id, String nombre, String email) {
		Cliente c = new Cliente(id, nombre, email);
		listaClientes.put(id, c);
	}
	
	public void actualizarCliente(String id, String nombre, String email) {
		listaClientes.put(id, new Cliente(id, nombre, email));
	}
	
	public boolean borrarCliente(String id) {
		return listaClientes.remove(id, listaClientes.get(id));
	}
	
	public List<Producto> getListaProductos() {
		return new ArrayList<Producto>(listaProductos.values());
	}
	
	public Producto getProducto(int codProd) throws Exception {
		if (!listaProductos.containsKey(codProd)) {
			throw new Exception("Error: Producto no registrado.");
		}
		return listaProductos.get(codProd);
	}
	
	public void agregarProducto(String nombre, float existencias, Unidad unidad, float precio) {
		Producto p = new Producto(nombre, existencias, unidad, precio);
		listaProductos.put(p.getCodigo(), p);
	}
	
	public void actualizarProducto(int codProd, String nombre, float existencias, Unidad unidad, float precio) {
		listaProductos.put(codProd, new Producto(nombre, existencias, unidad, precio));
	}
	
	public boolean borrarProducto(int codProd) {
		return listaProductos.remove(codProd,listaProductos.get(codProd));
	}
	
	public List<Orden> getListaOrdenes() {
		return new ArrayList<Orden>(listaOrdenes.values());
	}
	
	public float getMontoOrdenesPendientes() {
		float debito = 0;
		for (Orden actual : listaOrdenes.values()) {
			if (actual.getEstado().equals(Estado.PENDIENTE)) {
				for (Linea linea : actual.getLineas()) {
					debito += linea.getCantidad();
				}
			}
		}
		return debito;
	}
	
	public int crearOrden(String idCliente) {
		Orden nueva = new Orden(idCliente,Estado.INICIADA);
		listaOrdenes.put(nueva.getNumero(), nueva);
		return nueva.getNumero();
	}
	
	public Orden getOrden(int numOrden) {
		return listaOrdenes.get(numOrden);
	}
	
	public List<Linea> getLineasDeOrden(int numOrden) {
		return new ArrayList<Linea>(listaOrdenes.get(numOrden).getLineas());
	}
	
	public void setEstadoOrden(int numOrden, Estado estado) {
		listaOrdenes.get(numOrden).setEstado(estado);
	}
	
	public void agregarLineaAOrden(int numOrden, int codProd, float cantidad) {
		Orden orden = listaOrdenes.get(numOrden);
		Producto producto = listaProductos.get(codProd);
		orden.addLinea(new Linea(producto,cantidad));
	}
	
	public void actualizarLinea(int numOrden, int numLinea, int codProd, float cantidad) {
		Orden orden = listaOrdenes.get(numOrden);
		Producto producto = listaProductos.get(codProd);
		orden.delLinea(numLinea);
		orden.addLinea(new Linea(producto,cantidad));
	}
	
	public void borrarLinea(int numOrden, int numLinea) {
		Orden orden = listaOrdenes.get(numOrden);
		orden.delLinea(numLinea);
	}
	
	public void borrarOrden(int numOrden) {
		listaOrdenes.remove(numOrden);
	}

}
