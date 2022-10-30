package concesionario;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

@SuppressWarnings("serial")
public class VentanaConcesionario extends JFrame implements ActionListener {
	protected static Coche nombreCoche = new Coche("3", "B", "A", "N", false, false);
	protected JOptionPane registro;
	protected JPanel pCentral, pDerecha, pModelo, pColores, pLlantas, pInterior;
	protected JLabel lCoche, lSModelo, lSColor, lSLlanta, lSInterior, lSTemporizador;
	protected JLabel lDModelo, lDColor, lDLlanta, lDInterior;
	protected JButton bModelo, bBlanco, bNegro, bGris, bAzul, bRojo, bLAero, bLSport, bIBlanco, bINegro, bComprar;
	protected int precio;
	protected String descripcionComprar;
	protected static boolean compraRealizada = false;
	ImageIcon icon = new ImageIcon("src/img/teslaLogo.png");
	String nombreCocheFinal = nombreCoche.toString();
	protected static Usuario usuarioActual;
	int count = 1;
	boolean stop = false;

	public VentanaConcesionario() {
		// TODO Auto-generated constructor stub
		inicializar();
		setVisible(true);
	}

	public void inicializar() {
		// Diseï¿½o Ventana
		this.setSize(1440, 861);
		this.setTitle("Concesionario");

		// Inicializar componentes
		pCentral = new JPanel();
		pDerecha = new JPanel();
		pModelo = new JPanel();
		pColores = new JPanel();
		pLlantas = new JPanel();
		pInterior = new JPanel();

		lCoche = new JLabel(new ImageIcon("src/img/" + nombreCoche.getNombreCoche() + ".png"));

		lSTemporizador = new JLabel("<html><b>Tiempo restante</b>		10:00</html>");
		lSModelo = new JLabel("Seleccionar modelo");
		lSColor = new JLabel("Seleccionar pintura");
		lSLlanta = new JLabel("Seleccionar llantas");
		lSInterior = new JLabel("Seleccionar interior");

		labelConfiguracion(lSModelo, 1);
		labelConfiguracion(lSColor, 1);
		labelConfiguracion(lSLlanta, 1);
		labelConfiguracion(lSInterior, 1);

		lDModelo = new JLabel();
		lDModelo.setIcon(new ImageIcon("src/img/descripcionTemporal.png"));
		lDColor = new JLabel("<html><b>Blanco perla multicapas</b>		Incluido</html>");
		lDLlanta = new JLabel(
				"<html><b>Llantas Aero de 18</b>		Incluido<br>Autonomia estimada segun configuracion: 510 km</html>");
		lDInterior = new JLabel("<html><b>Todo negro</b>		Incluido</html>");

		labelConfiguracion(lDModelo, 2);
		labelConfiguracion(lDColor, 2);
		labelConfiguracion(lDLlanta, 2);
		labelConfiguracion(lDInterior, 2);

		bComprar = new JButton(descripcionComprar);

		bComprar.addActionListener(this);
		bComprar.setContentAreaFilled(false);
		bComprar.setBorder(new RoundedBorder(20));
		bComprar.setFont(new Font("Arial", Font.PLAIN, 30));

		try { // Como Comprobar???
			bModelo = new JButton(new ImageIcon("src/img/Modelo3.png"));
			botonConfiguracion(bModelo);
			bBlanco = new JButton(new ImageIcon("src/img/ColorBlanco.png"));
			botonConfiguracion(bBlanco);
			bNegro = new JButton(new ImageIcon("src/img/ColorNegro.png"));
			botonConfiguracion(bNegro);
			bGris = new JButton(new ImageIcon("src/img/ColorGris.png"));
			botonConfiguracion(bGris);
			bAzul = new JButton(new ImageIcon("src/img/ColorAzul.png"));
			botonConfiguracion(bAzul);
			bRojo = new JButton(new ImageIcon("src/img/ColorRojo.png"));
			botonConfiguracion(bRojo);

			bLAero = new JButton(new ImageIcon("src/img/LlantaAero.png"));
			botonConfiguracion(bLAero);
			bLSport = new JButton(new ImageIcon("src/img/LlantaSport.png"));
			botonConfiguracion(bLSport);

			bIBlanco = new JButton(new ImageIcon("src/img/InteriorBlanco.png"));
			botonConfiguracion(bIBlanco);
			bINegro = new JButton(new ImageIcon("src/img/InteriorNegro.png"));
			botonConfiguracion(bINegro);
		} catch (Exception e1) { // ERROR Si hay error, botones texto
			bModelo = new JButton("Model 3");
			bBlanco = new JButton("Blanco");
			bNegro = new JButton("Negro");
			bGris = new JButton("Gris");
			bAzul = new JButton("Azul");
			bRojo = new JButton("Rojo");

			bLAero = new JButton("Llanta Aero");
			bLSport = new JButton("Llanta Sport");

			bIBlanco = new JButton("Blanco");
			bINegro = new JButton("Negro");
		}
		// Aï¿½adir componentes
		getContentPane().add(pCentral, BorderLayout.CENTER);
		getContentPane().add(pDerecha, BorderLayout.EAST);

		pDerecha.setLayout(new BoxLayout(pDerecha, BoxLayout.Y_AXIS));

		pCentral.setLayout(new BorderLayout());
		pModelo.setLayout(new BorderLayout());
		pColores.setLayout(new BorderLayout());
		pLlantas.setLayout(new BorderLayout());
		pInterior.setLayout(new BorderLayout());

		pDerecha.add(pModelo);
		pDerecha.add(pColores);
		pDerecha.add(pLlantas);
		pDerecha.add(pInterior);

		JPanel pICentral = new JPanel();
		JPanel pIModelo = new JPanel();
		JPanel pIColores = new JPanel();
		JPanel pILlantas = new JPanel();
		JPanel pIInterior = new JPanel();

		pCentral.add(lSTemporizador, BorderLayout.NORTH);
		pCentral.add(lCoche, BorderLayout.CENTER);
		pCentral.add(bComprar, BorderLayout.SOUTH);
		pCentral.add(pICentral, BorderLayout.SOUTH);

		pICentral.add(bComprar);

		pModelo.add(lSModelo, BorderLayout.NORTH);
		pModelo.add(pIModelo, BorderLayout.CENTER);
		pModelo.add(lDModelo, BorderLayout.SOUTH);

		pIModelo.add(bModelo);

		pColores.add(lSColor, BorderLayout.NORTH);
		pColores.add(pIColores, BorderLayout.CENTER);
		pColores.add(lDColor, BorderLayout.SOUTH);

		pIColores.add(bBlanco);
		pIColores.add(bNegro);
		pIColores.add(bGris);
		pIColores.add(bAzul);
		pIColores.add(bRojo);

		pLlantas.add(lSLlanta, BorderLayout.NORTH);
		pLlantas.add(pILlantas, BorderLayout.CENTER);
		pLlantas.add(lDLlanta, BorderLayout.SOUTH);

		pILlantas.add(bLAero);
		pILlantas.add(bLSport);

		pInterior.add(lSInterior, BorderLayout.NORTH);
		pInterior.add(pIInterior, BorderLayout.CENTER);
		pInterior.add(lDInterior, BorderLayout.SOUTH);

		pIInterior.add(bINegro);
		pIInterior.add(bIBlanco);

		actualizarDatos();
		iniciarTemporizador();
		// Gestionar eventos
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				if (compraRealizada) {
					ventanaEmergenteCompra();
				} else {
					Object[] ops = { "Terminar sin comprar", "Continuar comprando" };
					int reps = JOptionPane.showOptionDialog(null, "Aun no ha realizado el pedido de su Tesla Model 3",
							"Compra sin realizar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, icon, ops,
							ops[1]);
					if (reps == JOptionPane.YES_OPTION) {
						guardarDatos();
						System.exit(0);
					}
				}
			}
		});
	}

	public void iniciarTemporizador() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				Timer timer = new Timer();

				timer.scheduleAtFixedRate(new TimerTask() {
					int i = 600;

					public void run() {

						lSTemporizador.setText("Tiempo hasta cierre automatico: " + i);
						i--;

						if (i < 0) {
							timer.cancel();
							lSTemporizador.setText("Cerrando");
							try {
								Thread.sleep(10000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							guardarDatos();
							System.exit(0);
						}
					}
				}, 0, 1000);
			}
		});
		t.start();
	}

	protected void guardarDatos() {
		VentanaInicio.userData.put(usuarioActual.getUsuarioHash(), usuarioActual.getUserData());
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(VentanaInicio.textFilePath));
			for (int user : VentanaInicio.userData.keySet()) {
				String line = user + ";" + VentanaInicio.userData.get(user).get(0);
				for (int i = 1; i < VentanaInicio.userData.get(user).size(); i++) {
					line += ";" + VentanaInicio.userData.get(user).get(i);
				}
				bw.write(line);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void establecerImagenCoche() {
		lCoche.setIcon(new ImageIcon("src/img/" + nombreCoche.getNombreCoche() + ".png"));
	}

	public void actionPerformed(ActionEvent e) {
		// Modelos

		if (e.getSource() == bModelo) {
			nombreCoche.setModelo("3");
		}

		// Colores

		else if (e.getSource() == bBlanco) {
			nombreCoche.setColor("B");
		} else if (e.getSource() == bNegro) {
			nombreCoche.setColor("N");
		} else if (e.getSource() == bGris) {
			nombreCoche.setColor("G");
			;
		} else if (e.getSource() == bAzul) {
			nombreCoche.setColor("A");
		} else if (e.getSource() == bRojo) {
			nombreCoche.setColor("R");
		}

		// Llantas

		else if (e.getSource() == bLAero) {
			nombreCoche.setLlanta("A");
		} else if (e.getSource() == bLSport) {
			nombreCoche.setLlanta("S");
		}

		// Interior

		else if (e.getSource() == bINegro) {
			nombreCoche.setInterior("N");
		} else if (e.getSource() == bIBlanco) {
			nombreCoche.setInterior("B");
		}
		actualizarDatos();
		establecerImagenCoche();

		// Central

		if (e.getSource() == bComprar) {
			nombreCocheFinal = nombreCoche.toString();
			compraRealizada = true;
			VentanaInicio.guardarCompra(nombreCoche);
			ventanaEmergenteCompra();
		}
	}

	public void ventanaEmergenteCompra() {
		Object[] ops = { "Continuar comprando", "Terminar compra" };
		String mensaje = "Ha comprado con exito un " + nombreCocheFinal;
		int reps = JOptionPane.showOptionDialog(null, mensaje, "Compra Realizada", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE, icon, ops, ops[1]);
		if (reps == JOptionPane.NO_OPTION) {
			guardarDatos();
			System.exit(0);
		}
	}

	private void actualizarDatos() {
		if (nombreCoche.getColor().substring(0, 1).toUpperCase().equals("B")) {
			lDColor.setText("<html><b>Blanco perla multicapas</b>		Incluido</html>");
		} else if (nombreCoche.getColor().substring(0, 1).toUpperCase().equals("R")) {
			lDColor.setText("<html><b>Multicapas roja</b>		€ 2.100</html>");
		} else {
			if (nombreCoche.getColor().substring(0, 1).toUpperCase().equals("N")) {
				lDColor.setText("<html><b>Negro solido</b>		€ 1.050</html>");
			} else if (nombreCoche.getColor().substring(0, 1).toUpperCase().equals("G")) {
				lDColor.setText("<html><b>Plata medianoche metalizado</b>		€ 1.050</html>");
			} else {
				lDColor.setText("<html><b>Azul oscuro metalizado</b>		€ 1.050</html>");
			}
		}

		if (nombreCoche.getLlanta().substring(0, 1).equals("S")) {
			lDLlanta.setText(
					"<html><b>Llantas Sport de 19</b>		€ 1.600<br>Autonomia certificada (WLTP): 491 km</html>");
		} else {
			lDLlanta.setText(
					"<html><b>Llantas Aero de 18</b>		Incluido<br>Autonomia estimada segun configuracion: 510 km</html>");
		}

		if (nombreCoche.getInterior().substring(0, 1).toUpperCase().equals("B")) {
			lDInterior.setText("<html><b>Negro y blanco</b>		€ 1.050</html>");
		} else {
			lDInterior.setText("<html><b>Todo negro</b>		Incluido</html>");
		}

		precio = nombreCoche.getPrecio();
		descripcionComprar = "Comprar Tesla Model 3 por € " + precio;
		bComprar.setText(descripcionComprar);
	}

	public void botonConfiguracion(JButton boton) {
		boton.addActionListener(this);
		boton.setOpaque(false);
		boton.setContentAreaFilled(false);
		boton.setBorderPainted(false);
	}

	public void labelConfiguracion(JLabel label, int num) {
		label.setHorizontalAlignment(SwingConstants.CENTER);
		if (num == 1) {
			label.setFont(new Font("Arial", Font.BOLD, 30));
		} else {
			label.setFont(new Font("Arial", Font.PLAIN, 15));
		}
	}
}
