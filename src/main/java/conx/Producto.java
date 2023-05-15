package conx;

public class Producto {
	private int id;
	private String nombre;
	private String tipo;
	private int cantidad;
	private double precio;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(int id, String nombre, String tipo, int cantidad, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}



	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("nombre: ")
		.append(nombre)
		.append("precio: ")
		.append(precio);
		return sb.toString();
	}



	
	
}