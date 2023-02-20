package hamburguesas.modelo;
import java.util.ArrayList;

import hamburguesas.modelo.ProductoMenu;

public class ProductoAjustado implements Producto {
	
	private ProductoMenu productoBase;
	private ArrayList<ingredientes>ingredienteEliminado;
	private ArrayList<ingredientes>ingredienteAnadido;
	
	
	public ProductoAjustado(ProductoMenu productoBase)
	{
		this.productoBase = productoBase;
		this.ingredienteEliminado = new ArrayList<>();
		this.ingredienteAnadido = new ArrayList<>();
		
	}
	


}
