package interfaz;

import control.Control;
import logica.Cliente;

public class Main {

	public static void main(String[] args) {
		Control control = Control.getInstance();
		
		control.agregarCliente("001", "Primerio", "primerio1@gmail.com");
		control.agregarCliente("002", "Segundio", "segundio2@gmail.com");
		control.agregarCliente("003", "Tercerio", "tercerio3@gmail.com");

		for (Cliente actual : control.getListaClientes()) {
			System.out.println(actual.aLetras());
		}
		
	}

}
