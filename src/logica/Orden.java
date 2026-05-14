package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Orden {
	private List<Linea> lineas;
	private Cliente cliente;
	private static int consecutivo = 0;
	private int numero;
	private LocalDate fecha;
	private Estado estado;
	
	public Orden(String idCliente, Estado estado) {
		numero = ++consecutivo;
		fecha = LocalDate.now();
		this.estado = estado;
		this.lineas = new ArrayList<>();
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	public List<Linea> getLineas() {
		return lineas;
	}
	
	public boolean addLinea(Linea linea) {
		return lineas.add(linea);
	}
	
	public boolean delLinea(Linea linea) {
		return lineas.remove(linea);
	}
}
