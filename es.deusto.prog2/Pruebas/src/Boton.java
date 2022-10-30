import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;


@SuppressWarnings("serial")
public class Boton extends JFrame implements ActionListener {
	protected String nombreCoche = "3BAB";
	protected JOptionPane registro;
	protected JPanel pCentral, pDerecha, pModelo, pColores, pLlantas, pInterior;
	protected JLabel lCoche, lSModelo, lSColor, lSLlanta, lSInterior;
	protected JLabel lDModelo,  lDColor, lDLlanta, lDInterior;
	protected JButton bModelo, bBlanco, bNegro, bGris, bAzul, bRojo, bLAero, bLSport, bIBlanco, bINegro;
	protected JPanel pSur;
	protected JLabel lN, lCU, lCC, lCE;
	protected JTextField tU;
	protected JPasswordField tC;
	protected JButton bAceptar, bCancelar, bRegistrar;
	
	
	public Boton() {
		// TODO Auto-generated constructor stub
		inicializar();
		setVisible(true);
	}
	
	public void inicializar() {
		// Diseï¿½o Ventana
		// Diseï¿½o Ventana
				this.setSize(400,400);
				this.setTitle("Inicio Sesion");
				// Inicializar componentes
				pCentral 	= new JPanel();
				pSur 		= new JPanel();
				
				lN 		= new JLabel("Iniciar Sesion");
				lCU 	= new JLabel("Usuario:");
				lCC		= new JLabel("Contraseña");
				lCE		= new JLabel("Usuario o Contraseña incorrectos");
				
				tU 		= new JTextField("" + 0,5);
				tC 		= new JPasswordField();
				
				bCancelar 	= new JButton("Cancelar");
				bAceptar 	= new JButton("Aceptar");
				bCancelar.addActionListener(this);
				bAceptar.addActionListener(this);
				bRegistrar 	= new JButton("Registrar");
				
			
				
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
				
				pSur.add(bCancelar);
				pSur.add(bAceptar);
		
		
		// Gestionar eventos
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	
	public void actionPerformed(ActionEvent e){
		 // Modelos
		 
		 if(e.getSource() == bAceptar) {
	        	System.out.println("hi2");
	        }
		 
		 // Colores
		 
		 	
	    }
	
}
