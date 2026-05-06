package logica;

public class Producto {
	private static int consecutivo = 0;
	private int codigo;
	private String nombre;
	private float existencias;
	private Unidad unidad;
	private float precio;
	
	public Producto(String nombre, float existencias, Unidad unidad, float precio) {
		codigo = ++consecutivo;
		this.nombre = nombre;
		this.existencias = existencias;
		this.unidad = unidad;
		this.precio = precio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getExistencias() {
		return existencias;
	}

	public void setExistencias(float existencias) {
		this.existencias = existencias;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
