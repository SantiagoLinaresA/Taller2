package hamburguesas.modelo;

public class bebidas {
	
	private String nombre;
	private int costoAdicional;
	private int id;
	
	
	public bebidas(String nombre, int costoAdicional, int id) 
	{
		this.nombre = nombre;
		this.costoAdicional = costoAdicional;
		this.setId(id);
			
	}
	
	
	
	public String getNombre()
	{
		return nombre;
	}
	
	public int getCostoAdicional()
	{
		return costoAdicional;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}

}
