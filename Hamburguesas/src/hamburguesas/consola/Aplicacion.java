package hamburguesas.consola;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import hamburguesas.modelo.Restaurante;

public class Aplicacion {
	
	private Restaurante restaurante = new Restaurante();
	
	
	public void ejecutarAplicacion() throws FileNotFoundException, IOException 
	{
		System.out.println("Bienvenido al servicio de pedidos de El Corral");
		Boolean pedido = false;

		boolean continuar = true;
		while (continuar)
		{
			System.out.println("\n1. Ver nuestro menú");
			System.out.println("2. Iniciar un nuevo pedido");
			System.out.println("3. Agregar un elemento a su pedido");
			System.out.println("4. Cerrar el pedido y guardar la factura");
			System.out.println("5. Consultar la información de su pedido con su Id");
			System.out.println("0-Salir de la aplicacion ");

			restaurante.cargarInformacionRestaurante();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción\n"));
			if (opcion_seleccionada == 1)
			{
				mostrarMenu();
			}
				
			else if (opcion_seleccionada == 2) 
			{
				String nombreCliente = input("Ingrese el nombre del cliente\n");
				String direccionCliente = input("Ingrese la direccion de envio\n");
				restaurante.iniciarPedido(nombreCliente, direccionCliente);
				pedido = true;
				System.out.println("Se ha iniciado su pedido con exito");
			}
			else if (opcion_seleccionada == 3 && pedido==true)
			{
				int idProducto = Integer.parseInt(input("Ingrese el código del producto que desea agregar a su pedido \n"));
				if (idProducto > 100 && idProducto < 123)
				{
					int cambio = Integer.parseInt(input("¿Desea modificar el Producto?\n \t1. Sí\n\t2. No\n"));
					if (cambio == 1)
					{
						boolean modificaciones = true;
						while (modificaciones)
						{
							int idIngrediente = Integer.parseInt(input("Ingrese el código del ingrediente que le gustaria modificar\n"));
							int tipo = Integer.parseInt(input("1. Agregar Ingrediente\n2. Eliminar Ingrediente\n"));
							if (tipo == 1)
							{
								restaurante.ejecutarPrepararProductoAjustado(idProducto, tipo, idIngrediente);
							}
							else if (tipo == 2)
							{
								restaurante.ejecutarPrepararProductoAjustado(idProducto, tipo, idIngrediente);
							}
							int proseguirmodificaciones = Integer.parseInt(input("¿Continuar modificaciones?\n \t1. Sí\n\t2. No\n"));
							if (proseguirmodificaciones != 1)
							{
								modificaciones = false;
							}
						}
						restaurante.ejecutarAgregarProductoAjustado();
					}
					else if (cambio == 2)
					{
						restaurante.ejecutarAgregarProducto(idProducto);
					}
					System.out.println("Producto agregado");
				}
			
				
				else if ((idProducto > 200 && idProducto < 216) || (idProducto > 300 && idProducto < 304))
				{
					restaurante.ejecutarAgregarProducto(idProducto);
					System.out.println("Producto agregado");
				}
				
				else
				{
					System.out.println("Producto no valido");
				}
			}
			
			else if (opcion_seleccionada == 3 && pedido==false) 
			{
				System.out.println("Por favor, recuerde primero iniciar su pedido");
			}
	
			else if (opcion_seleccionada == 4)
			{
				restaurante.cerrarYGuardarPedido();
				System.out.println("Pedido Cerrado con exito");
				pedido = false;
			}
			else if (opcion_seleccionada == 5)
			{
				int idPedido = Integer.parseInt(input("Ingrese el ID de su pedido\n"));
				String texto = restaurante.getPedidoPorId(idPedido);
				System.out.println(texto);
			}
			
			else
			{
				System.out.println("Saliendo de la aplicación ...");
				continuar = false;
			}
		}
	}
	
			
	
	public void mostrarMenu() 
	{
		System.out.println("1. NUESTRO MENÚ\n");
		System.out.println("\t101 - corral: 14000");
		System.out.println("\t102 - corral queso: 16000");
		System.out.println("\t103 - corral pollo: 15000");
		System.out.println("\t104 - corralita: 13000");
		System.out.println("\t105 - todoterreno: 25000");
		System.out.println("\t106 - 1/2 libra: 25000");
		System.out.println("\t107 - especial: 24000");
		System.out.println("\t108 - casera: 23000");
		System.out.println("\t109 - mexicana: 22000");
		System.out.println("\t110 - criolla: 22000");
		System.out.println("\t111 - costeña: 20000");
		System.out.println("\t112 - hawaiana: 20000");
		System.out.println("\t113 - wrap de pollo: 15000");
		System.out.println("\t114 - wrap de lomo: 22000");
		System.out.println("\t115 - ensalada mexicana: 20900");
		System.out.println("\t116 - papas medianas: 5500");
		System.out.println("\t117 - papas grandes: 6900");
		System.out.println("\t118 - papas en casco medianas: 5500");
		System.out.println("\t119 - papas en casco grandes: 6900");
		System.out.println("\n2. NUESTROS COMBOS");
		System.out.println("\t301 - combo corral (corral, papas medianas, gaseosa): 22050");
		System.out.println("\t302 - combo corral queso (corral queso, papas medianas, gaseosa): 23850");
		System.out.println("\t303 - combo todoterreno (todoterreno, papas grandes, gaseosa): 34317");
		System.out.println("\n3. INGREDIENTES EXTRA");
		System.out.println("\t201 - lechuga: 1000");
		System.out.println("\t202 - tomate: 1000");
		System.out.println("\t203 - cebolla: 1000");
		System.out.println("\t204 - queso mozzarella: 2500");
		System.out.println("\t205 - huevo: 2500");
		System.out.println("\t206 - queso americano: 2500");
		System.out.println("\t207 - tocineta express: 2500");
		System.out.println("\t208 - papa callejera: 2000");
		System.out.println("\t209 - pepinillos: 2500");
		System.out.println("\t210 - cebolla grille: 2500");
		System.out.println("\t211 - suero costeño: 3000");
		System.out.println("\t212 - frijol refrito: 4500");
		System.out.println("\t213 - queso fundido: 4500");
		System.out.println("\t214 - tocineta picada: 6000");
		System.out.println("\t215 - piña: 2500");
		System.out.println("\t401-Colombiana;5000");
		System.out.println("\t402-Seven Up;5000");
		System.out.println("\t403-Coca-Cola;5000");
		System.out.println("\t404-Uva;5000");
		System.out.println("\t405-Manzana;5000");
		System.out.println("\t406-Naranja;5000");
		System.out.println("\t407-agua cristal sin gas;5000");
		System.out.println("\t408-agua cristal con gas;5000");
		System.out.println("\t409-Fanta;5000");
	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje);
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
	}
	
	
	

}


