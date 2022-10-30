package conversorMonetario;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConversorMonetario extends JFrame{
	
		// Elementos
		private JTextField 	txtfMoneda;
		private JTextField 	txtfCambio;
		private JLabel		lblNumero;
		private int numero = 0;
		
		public ConversorMonetario() {
			inicializar();
		}
		
		private void inicializar() {
			// Diseño Ventana
			this.setSize(400,400);
			this.setTitle("Conversor Monetario");
			this.setLayout(new FlowLayout());
			
			// Inicializar componentes
			txtfMoneda = new JTextField("" + 0,5);
			txtfCambio = new JTextField("" + 0,5);
			lblNumero = new JLabel(""+numero);
			
			// Añadir componentes
			this.add(txtfMoneda);
			this.add(txtfCambio);
			this.add(lblNumero);
			
			
			// Gestionar eventos
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			
			txtfMoneda.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					System.out.println(txtfMoneda.getText());
					lblNumero.setText(""+Integer.parseInt(txtfMoneda.getText())*Integer.parseInt(txtfCambio.getText()));
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
			txtfCambio.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
								
				}
							
				@Override
				public void keyReleased(KeyEvent e) {
					System.out.println(txtfMoneda.getText());
					lblNumero.setText(""+Integer.parseInt(txtfMoneda.getText())*Integer.parseInt(txtfCambio.getText()));
				}
							
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
								
				}
			});
		
	}
}
