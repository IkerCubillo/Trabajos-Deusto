package ventanas;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;

import deustea.*;

public class VentanaPrincipal extends JFrame {
	protected Deustea deustea;
	protected JButton botonGestionPedidos;
	protected JButton botonPreparacionPedidos;
	protected VentanaGestionPedidos ventanaGestionPedidos;
	protected VentanaPreparacionPedidos ventanaPreparacionPedidos;
	protected String nombreFichero = "deustea.txt";
	
	public VentanaPrincipal() {
		deustea = new Deustea();
		deustea.inicializar();
		// TAREA3: cargar pedidos
//		Deustea.cargarPedidos(nombreFichero); comentado debidoa  que no funciona
		
		
		ventanaGestionPedidos = new VentanaGestionPedidos(deustea);
		ventanaPreparacionPedidos = new VentanaPreparacionPedidos(deustea);
		
		Container cp = this.getContentPane();
		
		cp.add(new JLabel(new ImageIcon("deustea.png")), BorderLayout.CENTER);
		
		JPanel abajo = new JPanel();
		
		botonGestionPedidos = new JButton("Gestionar pedidos");
		botonPreparacionPedidos = new JButton("Preparar pedidos");
		
		botonGestionPedidos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ventanaGestionPedidos.setVisible(true);
			}
		});
		
		botonPreparacionPedidos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ventanaPreparacionPedidos.recargarModelos(deustea);
				ventanaPreparacionPedidos.setVisible(true);
			}
		});
		
		abajo.add(botonGestionPedidos);
		abajo.add(botonPreparacionPedidos);
		
		cp.add(abajo, BorderLayout.SOUTH);
		
		// TAREA3: guardar pedidos al cerrar la ventana
		
		
		
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				Deustea.guardarPedidos(nombreFichero);
			}
			
		});
		
		
		this.setTitle("Deustea");
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		VentanaPrincipal v = new VentanaPrincipal();
		v.setVisible(true);
	}

}
