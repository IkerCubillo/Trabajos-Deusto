package concesionario;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class VentanaInicio extends JFrame implements ActionListener{
	
	protected JPanel pCentral, pSur;
	protected JLabel lN, lCU, lCC, lCE;
	protected static JTextField tU;
	protected JPasswordField tC;
	protected JButton bAceptar, bCancelar, bRegistrar;
	static String textFilePath = "src/data/registros.txt";
	protected static HashMap<Integer,Integer> userRegisters = new HashMap<>();
	protected static HashMap<Integer,String> userOrders = new HashMap<>();
		
	public VentanaInicio() {
		// TODO Auto-generated constructor stub
		inicializar();
		setVisible(true);
	}
	
	public void inicializar() {
		lecturaRegistros();
		
		// Diseï¿½o Ventana
		this.setSize(400,400);
		this.setTitle("Inicio Sesion");
		// Inicializar componentes
		pCentral 	= new JPanel();
		pSur 		= new JPanel();
		
		lN 		= new JLabel("Iniciar Sesion");
		lCU 	= new JLabel("Usuario:");
		lCC		= new JLabel("Contraseña");
		lCE		= new JLabel("");
		
		tU 		= new JTextField("CreadorSupremo");
		tC 		= new JPasswordField("IkerCubillo");
		
		bCancelar 	= new JButton("Cancelar");
		bAceptar 	= new JButton("Aceptar");
		bRegistrar 	= new JButton("Registrarse");
		bCancelar.addActionListener(this);
		bAceptar.addActionListener(this);
		bRegistrar.addActionListener(this);
		
	
		
		// Añadir componentes
		pCentral.setSize(400,50);
		
		getContentPane().add(lN, BorderLayout.NORTH);
		getContentPane().add(pCentral, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		
		lN.setHorizontalAlignment(SwingConstants.CENTER);
		lCU.setHorizontalAlignment(SwingConstants.CENTER);
		lCC.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		pSur.setLayout( new GridLayout(1, 2));
		
		pCentral.setLayout(new GridLayout(0,2));
		
		pCentral.add(lCU);
		pCentral.add(tU);
		pCentral.add(lCC);
		pCentral.add(tC);
		pCentral.add(lCE);
		
		pSur.add(bCancelar);
		pSur.add(bAceptar);
		
		// Gestionar eventos
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void lecturaRegistros() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(textFilePath));

			String line;
			while((line = br.readLine()) != null) {
				String[] campos = line.split(";");
				int A = Integer.parseInt(campos[0]);
				int B = Integer.parseInt(campos[1]); 
				String C = campos[2];
				userRegisters.put(A, B);
				userOrders.put(A, C);
				
			} br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e){
		 if(e.getSource() == bAceptar) {
			 if (userRegisters.containsKey(tU.getText().hashCode())) {
				 if (userRegisters.get(tU.getText().hashCode()) == tC.getText().hashCode() ) {
					 if(userOrders.get(tU.getText().hashCode()).equals("null")) {
					 } else {
						VentanaConcesionario.nombreCoche = userOrders.get(tU.getText().hashCode());
					 }
					VentanaConcesionario vc = new VentanaConcesionario();
					this.dispose();

				 } else {
					 lCE.setText("Contraseña incorrecta");
					 pCentral.add(bRegistrar);
				 }
			 } else {
				 lCE.setText("Usuario incorrecto");
				 pCentral.add(bRegistrar);
			 }
//			 
		}
		 else if(e.getSource() == bCancelar) {
			 System.exit(0);
		 }
		 else if(e.getSource() == bRegistrar && !userRegisters.containsKey(tU.getText().hashCode())) {
			 Usuario newUser = new Usuario(tU.getText().hashCode(), tC.getText().hashCode(), null);
//			 userRegisters.put(newUser.getUsuarioHash(),newUser.getUserData());
			 userRegisters.put(tU.getText().hashCode(),tC.getText().hashCode());
			 this.dispose();
			 VentanaConcesionario vc = new VentanaConcesionario();
		 }
	}

	public static void guardarCompra(String nombreCoche) {
		userOrders.put(tU.getText().hashCode(),nombreCoche);
	}
}
