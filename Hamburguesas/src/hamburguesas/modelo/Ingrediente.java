package hamburguesas.modelo;


public class Ingrediente {
	
	// ************************************************************************
	// Atributos
	// ************************************************************************
	
	private String nombre;
	
	private int costoAdicional;
	
	private int id;
	
	// ************************************************************************
	// Constructores
	// ************************************************************************
	
	public Ingrediente(String nombre, int costoAdicional, int id) 
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




