package mundo;

public class Producto implements Comparable<Producto>{
	private String nombre;
	private int cantidad;
	private int puntos;
	private String imagen;
	public Producto(String nombre, int puntos) {
		this.nombre = nombre;
		cantidad=1;
		this.puntos=puntos;
	}
	@Override
	public int compareTo(Producto o) {
		
		return o.cantidad-cantidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
	
}
