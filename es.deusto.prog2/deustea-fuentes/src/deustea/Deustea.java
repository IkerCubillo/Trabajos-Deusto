package deustea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Deustea {
	public static ArrayList<Pedido> pedidos;
	protected ArrayList<Producto> productos;
	protected ArrayList<Servicio> servicios;
	protected ArrayList<Recambio> recambios = new ArrayList<>();
	protected ArrayList<Pedido> arraylistVacia1 = new ArrayList<>();
	protected ArrayList<Pedido> arraylistVacia2 = new ArrayList<>();
	protected ArrayList<Pedido> arraylistVacia3 = new ArrayList<>();
	// TAREA2: Mapa
	protected static HashMap<Estado, ArrayList<Pedido>> pedidosPorEstado = new HashMap<>(); 
	
	/** Constructor con argumentos
	 * @param pedidos almacenados
	 * @param productos disponibles
	 * @param servicios disponibles
	 */
	public Deustea(ArrayList<Pedido> pedidos, ArrayList<Producto> productos, ArrayList<Servicio> servicios, HashMap<Estado, ArrayList<Pedido>> pedidosPorEstado) {
		super();
		this.setPedidos(pedidos);
		this.setProductos(productos);
		this.setServicios(servicios);
		this.setPedidosPorEstado(pedidosPorEstado);
	}
	
	/** Constructor por defecto, con todas las estructuras de datos vacías
	 */
	public Deustea() {
		super();
		this.pedidos = new ArrayList<Pedido>();
		this.productos = new ArrayList<Producto>();
		this.servicios = new ArrayList<Servicio>();
		this.pedidosPorEstado = new HashMap<Estado, ArrayList<Pedido>>();
		
	}

	/**
	 * @return pedidos almacenados
	 */
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	/**
	 * @param pedidos almacenados
	 */
	public void setPedidos(ArrayList<Pedido> pedidos) {
		if (pedidos != null) {
			this.pedidos = pedidos;
		}
	}

	/**
	 * @return productos disponibles
	 */
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	/**
	 * @param productos disponibles
	 */
	public void setProductos(ArrayList<Producto> productos) {
		if (pedidos != null) {
			this.productos = productos;
		}
	}

	/**
	 * @return servicios disponibles
	 */
	public ArrayList<Servicio> getServicios() {
		return servicios;
	}

	/**
	 * @param servicios disponibles
	 */
	public void setServicios(ArrayList<Servicio> servicios) {
		if (servicios != null) {
			this.servicios = servicios;
		}
	}

	/** Convierte un Deustea en String
	 */
	@Override
	public String toString() {
		return "Deustea [pedidos=" + pedidos + ", productos=" + productos + ", servicios=" + servicios + ", pedidosPorEstado=" + pedidosPorEstado +"]";
	}
	
	public HashMap<Estado, ArrayList<Pedido>> getPedidosPorEstado() {
		return pedidosPorEstado;
	}

	/**
	 * @param servicios disponibles
	 */
	public void setPedidosPorEstado(HashMap<Estado, ArrayList<Pedido>> pedidosPorEstado) {
		if (pedidosPorEstado != null) {
			this.pedidosPorEstado = pedidosPorEstado;
		}
	}
	
	/**
	 * @param pedidosPorEstado pedidos clasificados por su estado
	 */
	public void inicializar() {
		ArrayList<Mueble> muebles = new ArrayList<Mueble>(); 
		
		// Cargamos los muebles desde fichero
		try {
			Scanner sc = new Scanner(new File("deustea.csv"));
			String[] categorias = { "COCINA", "CAMAS", "ESTANTERIAS", "ARMARIOS", "DESAYUNO", "SILLAS", 
					"ALMACENAMIENTO", "INFANTIL", "SOFAS", "MESAS" };
						
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				int pos = Arrays.asList(categorias).indexOf(campos[2]);
				Mueble nuevo = new Mueble(Integer.parseInt(campos[0]), campos[1], Categoria.values()[pos], Double.parseDouble(campos[3]));
				this.productos.add(nuevo);
				muebles.add(nuevo);
			}
			
			sc.close();
			
		} catch (IOException e) {
			System.err.println("Error cargando productos");
		}
		
		// TAREA1: Crear los recambios aleatoriamente
		
		for(int i = 0; i <= 100; i++) {
			// implementar random
			
			Mueble mr = muebles.get(i);
			Recambio e = new Recambio(i, mr.getNombre() , mr, i);
			recambios.add(e);
		}
		
		// Creamos los servicios
		for (TipoServicio tipo : TipoServicio.values()) {
			for (int i = 0; i < 4; i++) {
				this.servicios.add(new Servicio(tipo, i));
			}
		}
	}
	
	/** Añade un pedido a las estructuras de datos de Deustea
	 * @param pedido que se añade
	 */
	public void anyadirPedido(Pedido pedido) {
		pedidos.add(pedido);
		// TAREA2: actualizar el mapa
		
		try {
			
			pedidosPorEstado.get(pedido.getEstado()).add(pedido);
		} catch (Exception e) {
			ArrayList<Pedido> arrayVacia = new ArrayList<>();
			arrayVacia.add(pedido);
			pedidosPorEstado.put(pedido.getEstado(), arrayVacia);
		}	
//		System.out.println(pedidosPorEstado);
	}
	
	/** Borra un pedido de las estructuras de datos de Deustea
	 * @param pedido que se borra
	 */
	public void borrarPedido(Pedido pedido) {
		pedidos.remove(pedido);
		// TAREA2: actualizar el mapa
		pedidosPorEstado.get(pedido.getEstado()).remove(pedido);
//		System.out.println(pedidosPorEstado);
	}
	
	/** Actualiza el estado de un pedido y las estructuras de datos de Deustea
	 * @param pedido que se actualiza
	 * @param estado nuevo
	 */
	public void actualizarEstadoPedido(Pedido pedido, Estado estado) {
//		System.out.println(pedidosPorEstado);
		pedidosPorEstado.get(pedido.getEstado()).remove(pedido);
//		System.out.println(pedidosPorEstado);
		int posicion = pedidos.lastIndexOf(pedido);
		pedidos.get(posicion).setEstado(estado);
		// TAREA2: actualizar el mapa
		try {
			pedidosPorEstado.get(pedido.getEstado()).add(pedido);
		} catch (Exception e) {
			ArrayList<Pedido> arrayVacia = new ArrayList<>();
			arrayVacia.add(pedido);
			pedidosPorEstado.put(pedido.getEstado(), arrayVacia);
		}
//		System.out.println(pedidosPorEstado);
	}
	
	/** Regenera el mapa pedidosPorEstado
	 */
	public static void regenerarPedidosPorEstado() {
		// TAREA2: regenerar el mapa
		pedidosPorEstado.clear();
		for(Pedido pedidoRegenerar: pedidos) {
			try {
				pedidosPorEstado.get(pedidoRegenerar.getEstado()).add(pedidoRegenerar);
			} catch (Exception e) {
				ArrayList<Pedido> arrayVacia = new ArrayList<>();
				arrayVacia.add(pedidoRegenerar);
				pedidosPorEstado.put(pedidoRegenerar.getEstado(), arrayVacia);
			}
		}
	}
	
	/** Guarda los datos de pedidos en un fichero binario
	 * @param fichero en el que se guardan los datos
	 */
	
	public void guardarPedidos(String nombreDelFichero, ArrayList<Pedido> datosPedido) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(nombreDelFichero));
			for(Pedido ePedido: datosPedido) {
				String line = ePedido.getCliente() + ";" + ePedido.getFecha() + ";" + ePedido.getElementos() + ";" + ePedido.getEstado() ;
				System.out.println(line);
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void guardarPedidos(String fichero) {
		// TAREA3: ficheros
		
		try {
			FileOutputStream fos = new FileOutputStream(fichero);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
//			oos.write(pedidos); comentado apra que no de error
			oos.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
			for(Pedido ePedido: pedidos) {
				String line = ePedido.getCliente() + ";" + ePedido.getFecha() + ";" + ePedido.getElementos() + ";" + ePedido.getEstado() ;
				System.out.println(line);
				bw.write(line);
				bw.newLine();
				
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** Carga los datos de pedidos desde un fichero binario
	 * @param fichero desde el que se cargan los datos
	 */
	public static void cargarPedidos(String fichero) {
		// TAREA3: ficheros
		
		try {
			ArrayList<Pedido> aPedido = new ArrayList<>();
			FileInputStream fis = new FileInputStream(fichero);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			
			aPedido = (ArrayList<Pedido>) read(ois);
			
			pedidos = aPedido;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		try {
//			BufferedReader br = new BufferedReader(new FileReader(fichero));
//			
//			String linea = br.readLine();
//			while (linea != null) {
//				String[] campos = linea.split(";");
//				String A = campos[0];
////				Date B = (Date) campos[1];
////				ArrayList<Pagable> = campos[2];
//				Estado D = (Estado) campos[3];
//				Pedido nPedido = new Pedido(A, B, C, null);
//				nPedido.setEstado(D);
//				pedidos.add(null);
//				
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		regenerarPedidosPorEstado();
	}

	private static ArrayList<Pedido> read(ObjectInputStream ois) {
		// TODO Auto-generated method stub
		return null;
	}

}
