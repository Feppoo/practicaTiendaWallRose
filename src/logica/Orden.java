package logica;

import java.time.LocalDate;

public class Orden {
	private static int consecutivo = 0;
	private int numero;
	private LocalDate fecha;
	private Estado estado;
	
	public Orden(Estado estado) {
		numero = ++consecutivo;
		fecha = LocalDate.now();
		this.estado = estado;
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
	
}
