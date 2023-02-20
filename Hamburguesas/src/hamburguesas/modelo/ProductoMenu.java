package hamburguesas.modelo;

public class ProductoMenu implements Producto{
	
	private String nombre;
	private int precioBase;
	private int id;
	
	public ProductoMenu(String nombre, int precioBase,int id)
	{
		this.nombre =nombre;
		this.precioBase =precioBase;
		this.setId(id);
				
	}
	
	public String getNombre() {
		
		return nombre;
		
	}
	public int getPrecio() {
		return precioBase;
	}
	public int getId() {
		return id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPrecio(int precioBase) {
		this.precioBase = precioBase;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String generarTextoFactura() {
		return ("\t" + getNombre() + "\t\t" +getPrecio());
	}
}
