package contador;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Contador extends JFrame{
	private JButton incrementar;
	private JButton decrementar;
	private JLabel	numeroActual;
	private int numero = 0;
	
	public Contador() {
		inicializarContador();
	}

	private void inicializarContador() {
		// Establecer ventana
		this.setSize(400,200);
		this.setTitle("CONTADOR");
		this.setLayout(new FlowLayout());
		
		
		// Inicializar elementos
		incrementar = new JButton("Incrementar");
		decrementar = new JButton("Decrementar");
		numeroActual = new JLabel(""+numero);
		numeroActual.setFont(new Font("Serif", Font.PLAIN, 94));
		//lblNumero
				
		// Agregar componentes
		this.add(numeroActual);
		this.add(incrementar);
		this.add(decrementar);
		
		
		// Control de eventos
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		incrementar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numero ++;
				numeroActual.setText(""+numero);
			}
		});
		
		decrementar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numero --;
				numeroActual.setText(""+numero);
			}
		});
	}
}