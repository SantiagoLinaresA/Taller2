package hamburguesas.modelo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
////////////////////////////////////////////////////////////////
///
////////////////////////////////////////////////////////////////
public class Pedido {
	
	private int numeroPedidos;
    private int idPedido;
    private String nombreCliente;
    private String direccionCliente;
    private ArrayList<Producto> productos;
    
    public Pedido(String nombreCliente, String direccionCliente, int contadorPedidos) 
    {
    	Random rand = new Random();
    	this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.idPedido = rand.nextInt(99999);
		this.numeroPedidos = contadorPedidos;
		this.productos = new ArrayList<>();
    }
    
    public int getIdPedido() 
    {
        return idPedido;
    }
    
    public void agregarProducto(Producto nuevoItem)
    {
    	
    	productos.add(nuevoItem);
    }
    
    private int getPrecioNetoPedido() 
    {
    	int net = 0;
    	for (int i = this.productos.size() - 1; i >= 0; i--)
		{
			Producto unProducto = productos.get(i);
			net = net + unProducto.getPrecio();
		}
    	return net;
    }
    
    private int getPrecioTotalPedido() 
    {
        int precioTotal = this.getPrecioNetoPedido() +  this.getPrecioIVAPedido();

        return precioTotal;
    }
    
    private int getPrecioIVAPedido() 
    {
        int neto = this.getPrecioNetoPedido();
        int precioIVA = neto * 19 / 100;

        return precioIVA;
    }
    
    public String generarTextoFactura() 
    {
    	String textoProductos = "";
    	for (int i = this.productos.size() - 1; i >= 0; i--)
		{
			Producto unProducto = productos.get(i);
			textoProductos = textoProductos + unProducto.generarTextoFactura() + "\n";
		}
    	
        String TextoFactura = "RESTAURANTE EL CORRAL\n\nCliente: " + this.nombreCliente + 
        					  "\nDirección del cliente: " +  this.direccionCliente +
        					  "\nID Pedido: " + this.idPedido +
        					  "\n #Pedido: " + this.numeroPedidos +
        					  "\n\n PRODUCTOS\n" + textoProductos +
        					  "\n\n Valor Neto pedido: " + this.getPrecioNetoPedido() + 
        					  "\n Valor con IVA(19%) pedido: " + this.getPrecioIVAPedido() + 
        					  "\n TOTAL: " + this.getPrecioTotalPedido();
        
        

        return TextoFactura;
    }
    
    public void guardarFactura() throws IOException
    {
        String ruta = "Data/facturas/" + idPedido + ".txt";
        String contenido = this.generarTextoFactura();
        File file = new File(ruta);
        if (!file.exists()) 
        {
           file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contenido);
        bw.close();
    }
}
