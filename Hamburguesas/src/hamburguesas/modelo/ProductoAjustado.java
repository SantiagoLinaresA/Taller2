package hamburguesas.modelo;
import java.util.ArrayList;
////////////////////////////////////////////////////////////////
///
////////////////////////////////////////////////////////////////

public class ProductoAjustado implements Producto {
	
	private ProductoMenu productoBase;
	private ArrayList<Ingrediente>ingredienteEliminado;
	private ArrayList<Ingrediente>ingredienteAnadido;
	
	
	public ProductoAjustado(ProductoMenu productoBase){
		this.productoBase = productoBase;
		this.ingredienteEliminado = new ArrayList<>();
		this.ingredienteAnadido = new ArrayList<>();
		
	}
	
	public String getNombre() {
		return productoBase.getNombre();
	}


	public int getPrecio() {
		int total = productoBase.getPrecio();
		
		for(int i = this.ingredienteAnadido.size() - 1; i >= 0;i--) {
			
			Ingrediente unIngrediente = ingredienteAnadido.get(i);
			total = total + unIngrediente.getCostoAdicional();
		}
		return total;
	}

	public String generarTextoFactura() {
		String texto = "\t";
		texto = texto + productoBase.getNombre() + "\t\t" + productoBase.getPrecio() + "\n";
		for (int i = this.ingredienteAnadido.size() - 1; i >= 0; i--)
		{
			Ingrediente unIngrediente = ingredienteAnadido.get(i);
			texto = texto + "\t\t+ " + unIngrediente.getNombre() + "\t" + unIngrediente.getCostoAdicional()+ "\n";
		}
		for (int i = this.ingredienteEliminado.size() - 1; i >= 0; i--)
		{
			Ingrediente unIngrediente = ingredienteEliminado.get(i);
			texto = texto + "\t\t- " + unIngrediente.getNombre() + "\n";
		}
		return texto;
	}

	public ArrayList<Ingrediente> getIngredientesEliminados() {
		return ingredienteEliminado;
	}
	
	public void setIngredientesEliminados(ArrayList<Ingrediente> ingredientesEliminados) {
		this.ingredienteEliminado = ingredientesEliminados;
	}


	public ArrayList<Ingrediente> getIngredientesAgregados() {
		return ingredienteAnadido;
	}


	public void setIngredientesAgregados(ArrayList<Ingrediente> ingredientesAgregados) {
		this.ingredienteAnadido = ingredientesAgregados;
	}
	
	public int getId() 
	{
		return productoBase.getId();
	}

}
