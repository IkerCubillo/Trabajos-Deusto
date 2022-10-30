package sumador;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Sumador extends JFrame{
	// Elementos
	private JButton 	btIncrementar;
	private JLabel		lblNumero;
	private JTextField 	txtfNumero;
	private int numero = 0;
	
	public Sumador() {
		inicializar();
	}
	
	private void inicializar() {
		// Dise�o Ventana
		this.setSize(400,400);
		this.setTitle("Sumador");
		this.setLayout(new FlowLayout());
		
		// Inicializar componentes
		btIncrementar = new JButton("Inrementar");
		lblNumero = new JLabel(""+numero);
		txtfNumero = new JTextField("" + 0,5);
		
		// A�adir componentes
		this.add(lblNumero);
		this.add(txtfNumero);
		this.add(btIncrementar);
		
		
		// Gestionar eventos
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btIncrementar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				numero += Integer.parseInt(txtfNumero.getText());
				lblNumero.setText(""+numero);
				} catch(NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Error entrada incorrecta");
				} finally {
					txtfNumero.setText("0");
				}
			}
		});
				
		
	}
}
