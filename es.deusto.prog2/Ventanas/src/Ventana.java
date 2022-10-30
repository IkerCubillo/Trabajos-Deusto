import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends Frame{
	public Ventana() {
	}
	public static void main(String[] args) {
	new Ventana();

	JFrame ventana = new JFrame();
	JTextField tfUsuario = new JTextField(20);
	JTextField tfContraseña = new JTextField(20);
	JPanel p = new JPanel();
	
	p.setLayout(new FlowLayout());

	p.add(tfUsuario);
	
	ventana.setLayout(new FlowLayout());
	ventana.setLayout((new GridLayout(2,2)));
	ventana.setLayout((new GridLayout(1,4)));
	
	ventana.add(new TextField(20));
	ventana.add(new TextField(30));
	ventana.add(p);
	ventana.add(new Button("Aceptar"));
	ventana.add(new Button("Cancelar"));
	
	p.add(new TextField(20));
	p.setLayout(new FlowLayout());
	
	ventana.setSize(200,300);
	ventana.setVisible(true);
	
	ventana.addWindowListener( new WindowAdapter() { // Adaptador
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	});
	
	}
}
