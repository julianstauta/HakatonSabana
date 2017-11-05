package mundo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Usuario {
	
	private String idUsuario;
	private String nombre;
	private String correo;
	private PriorityQueue<Producto> compras;
	private PriorityQueue<Tag> segmento;
	private HashMap<String, Tag> mapTags;
	private HashMap<String, Producto> mapProductos;
	private int puntos;
	private int cantidadCompras;
	public Usuario(String id, String correo, String nombre) {
		this.nombre=nombre;
		this.idUsuario=id;
		this.correo=correo;
		compras=new PriorityQueue();
		segmento=new PriorityQueue();
		mapTags=new HashMap();
		mapProductos=new HashMap();
		puntos=0;
		
	}


	public void agregarProducto(String producto) {
		
		String[] info=producto.split(";");
		Producto actual=mapProductos.get(info[0]);
		if(actual==null) {
			actual=new Producto(info[0], Integer.parseInt(info[1]));
			compras.add(actual);
			mapProductos.put(info[0], actual);
		}else {
			actual.setCantidad(actual.getCantidad()+1);
		}
		puntos+=Integer.parseInt(info[1]);
		for (int i = 2; i < info.length; i++) {
			Tag tagActual=mapTags.get(info[i]);
			if(tagActual==null) {
				tagActual=new Tag(info[i]);
				segmento.add(tagActual);
				mapTags.put(info[i], tagActual);
			}else {
				tagActual.setCantidad(tagActual.getCantidad()+1);
			}
		}
		
	}
	
	
	public String getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}

	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public PriorityQueue<Producto> getCompras() {
		return compras;
	}


	public void setCompras(PriorityQueue<Producto> compras) {
		this.compras = compras;
	}


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}


	public PriorityQueue<Tag> getSegmento() {
		return segmento;
	}


	public void setSegmento(PriorityQueue<Tag> segmento) {
		this.segmento = segmento;
	}


	public HashMap<String, Tag> getMapTags() {
		return mapTags;
	}


	public void setMapTags(HashMap<String, Tag> mapTags) {
		this.mapTags = mapTags;
	}


	public HashMap<String, Producto> getMapProductos() {
		return mapProductos;
	}


	public void setMapProductos(HashMap<String, Producto> mapProductos) {
		this.mapProductos = mapProductos;
	}


	public int getCantidadCompras() {
		return cantidadCompras;
	}


	public void setCantidadCompras(int cantidadCompras) {
		this.cantidadCompras = cantidadCompras;
	}
	
	
	
}
