package mundo;

public class Tag implements Comparable<Tag>{

	private String tag;
	private int cantidad;
	
	public Tag(String tag) {
		this.tag = tag;
		this.cantidad = 1;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int compareTo(Tag o) {
		
		return o.getCantidad()-cantidad;
	}
	
	
	
}
