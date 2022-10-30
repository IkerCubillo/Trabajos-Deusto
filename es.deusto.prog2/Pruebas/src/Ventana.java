import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame {
	protected JPanel pInterior;
	protected JLabel lSInterior;
	protected JLabel lDInterior;
	
	

	public Ventana() {
		inicializar();
		// TODO Auto-generated constructor stub
	}
	
	public void inicializar() {	
		this.setSize(1440,861);
		this.setTitle("Concesionario");
		
		pInterior = new JPanel();
		
		lSInterior = new JLabel("Seleccionar interior");
		
		lDInterior = new JLabel("patata");
		
		pInterior.setLayout(new BorderLayout());
		
		this.add(pInterior);
		
		
		pInterior.add(lSInterior,BorderLayout.NORTH);
		
		pInterior.add(lDInterior, BorderLayout.SOUTH);
	}
	
}
