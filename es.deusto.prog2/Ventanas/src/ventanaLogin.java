import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ventanaLogin extends JFrame implements WindowListener, ActionListener{
	private JTextField usuario;
	private JTextField contraseña;
	private JButton aceptar;
	private JButton cancelar;
	
	public ventanaLogin(){
		inicializarVentana();
	}

	private void inicializarVentana() {
		// Inicializamos la ventana
		this.setSize(400,400);
		this.setTitle("--- Login ---");
		this.setLayout(new GridLayout(2,2));
		this.addWindowListener(this);
		
		usuario = new JTextField(20);
		contraseña = new JTextField(20);
		
		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Soy el boton Aceptar");
			}
		});
		
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Soy el boton Cancelar");
				
			}
		});
		
		this.add(usuario);
		this.add(contraseña);
		this.add(aceptar);
		this.add(cancelar);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Cerrando");
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getSource());
	}
}
