package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

public class App {

	private HashMap<String, Usuario> listaUsuarios;
	private HashMap<String, Producto> productosDisponibles;
	private HashMap<String, String> tagsProductos;
	private HashMap<String , HashSet<String>> mapaDeTags;
	public App() {
		listaUsuarios=new HashMap();
		mapaDeTags=new HashMap();
		productosDisponibles=new HashMap();
		tagsProductos = new HashMap<>();
		cargarInfoProductos();
		cargarUsuarios();
		System.out.println(listaUsuarios.size());
		System.out.println(productosDisponibles.size());
		System.out.println(tagsProductos.size());
		System.out.println(mapaDeTags.size());
	}
		
	/**
	 * @return the listaUsuarios
	 */
	public HashMap<String, Usuario> getListaUsuarios() {
		return listaUsuarios;
	}



	/**
	 * @return the productosDisponibles
	 */
	public HashMap<String, Producto> getProductosDisponibles() {
		return productosDisponibles;
	}



	/**
	 * @return the tagsProductos
	 */
	public HashMap<String, String> getTagsProductos() {
		return tagsProductos;
	}



	/**
	 * @return the mapaDeTags
	 */
	public HashMap<String, HashSet<String>> getMapaDeTags() {
		return mapaDeTags;
	}



	/**
	 * @param listaUsuarios the listaUsuarios to set
	 */
	public void setListaUsuarios(HashMap<String, Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}



	/**
	 * @param productosDisponibles the productosDisponibles to set
	 */
	public void setProductosDisponibles(HashMap<String, Producto> productosDisponibles) {
		this.productosDisponibles = productosDisponibles;
	}



	/**
	 * @param tagsProductos the tagsProductos to set
	 */
	public void setTagsProductos(HashMap<String, String> tagsProductos) {
		this.tagsProductos = tagsProductos;
	}



	/**
	 * @param mapaDeTags the mapaDeTags to set
	 */
	public void setMapaDeTags(HashMap<String, HashSet<String>> mapaDeTags) {
		this.mapaDeTags = mapaDeTags;
	}

	public void cargarInfoProductos() {
		try {
			BufferedReader in=new BufferedReader(new FileReader(new File("InfoProductos.csv")));
			String l = in.readLine();
			int cantidadProductos=Integer.parseInt(l);
			for (int i = 0; i < cantidadProductos; i++) {
				String actual=in.readLine();
				String[] line=actual.split(";");
				String productoActual=line[0];
				tagsProductos.put(productoActual, actual);
				productosDisponibles.put(productoActual, new Producto(productoActual,Integer.parseInt(line[1])));
				int pos=2;
				while(pos<line.length&&!line[pos].equals("")) {
					String tagActual=line[pos];
					HashSet<String> listaDeltag=mapaDeTags.get(tagActual);
					if(listaDeltag==null) {
						listaDeltag=new HashSet();
						listaDeltag.add(productoActual);
						mapaDeTags.put(tagActual, listaDeltag);
						
					}else {
						listaDeltag.add(productoActual);
					}
					pos++;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	

	public void cargarUsuarios() {
		try {
			BufferedReader in=new BufferedReader(new FileReader(new File("generados.csv")));
			String line=in.readLine();
			while(line!=null) {
				String[] datos=line.split(";");
				String ID=datos[0];
				String Nombre=datos[1];
				String producto=datos[2];
				Usuario actual=listaUsuarios.get(ID);
				if(actual==null) {
					actual=new Usuario(ID, "micorreo@alpina.com", Nombre);
					listaUsuarios.put(ID, actual);
				}
				actual.agregarProducto(tagsProductos.get(producto));
				line = in.readLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public ArrayList<Producto> generarRecomendaciones(String ID) {
		Usuario aRecomendar=listaUsuarios.get(ID);
		PriorityQueue<Tag>  listaDeTagsFaboritos=aRecomendar.getSegmento();
		ArrayList<Producto> recomendacion=new ArrayList();
		boolean salir=false;
		while(recomendacion.size()!=2&&!salir) {
			if(recomendacion.size()==0&&listaDeTagsFaboritos.size()>=1) {
				String tags=listaDeTagsFaboritos.peek().getTag();
				HashSet<String> setDeProductos=mapaDeTags.get(tags);
				for (Iterator iterator = setDeProductos.iterator(); iterator.hasNext();) {
					String string = (String) iterator.next();
					
					if(!aRecomendar.getMapProductos().containsKey(string)) {
						recomendacion.add(productosDisponibles.get(string));
					}
					
				}
				
				
			}else if(listaDeTagsFaboritos.size()>=2){
				Tag primero=listaDeTagsFaboritos.poll();
				String tags=listaDeTagsFaboritos.peek().getTag();
				listaDeTagsFaboritos.add(primero);
				HashSet<String> setDeProductos=mapaDeTags.get(tags);
				for (Iterator iterator = setDeProductos.iterator(); iterator.hasNext();) {
					String string = (String) iterator.next();
					
					if(!aRecomendar.getMapProductos().containsKey(string)) {
						recomendacion.add(productosDisponibles.get(string));
						salir = true;
					}
					
				}
			}else {
				salir=true;
			}
		}
		return recomendacion;
	}
	
	
}
