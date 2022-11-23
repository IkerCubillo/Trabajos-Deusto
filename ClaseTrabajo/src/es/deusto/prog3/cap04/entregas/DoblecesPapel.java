package es.deusto.prog3.cap04.entregas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class DoblecesPapel extends JFrame{
	private String t1 = "... Se necesita doblar ";
	private String t2 = " veces una hoja de papel del grosor de ";
	
	public static void main(String[] args) {
		DoblecesPapel ventana = new DoblecesPapel();
		ventana.setVisible(true);
	}

	public DoblecesPapel(){		
		// Configurar Pantalla
		setSize(600,300);
		setLocation(500, 300);
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle("¿Cuantas veces necesito doblar una hoja de papel para llegar a... ?");
		setLayout(new BorderLayout());
		
		// Crear Objetos
		JPanel pCentral = new JPanel();
		JPanel pSur = new JPanel();
		
		JButton bCalcular = new JButton("Calcular");
		JButton bSol = new JButton("Sol");
		JButton bLuna = new JButton("Luna");
		
		JLabel lDistancia = new JLabel("Distancia a la que está el objeto");
		JLabel lGrosor = new JLabel("Grosor de la hoja a utilizar");
		JLabel lNombre = new JLabel("Nombre del objeto");
		
		JTextField tfDistancia = new JTextField("384400000", 50);
		JTextField tfGrosor = new JTextField("0.0001", 50);
		JTextField tfNombre = new JTextField("la Luna", 50);
		
		JTextArea taResultado = new JTextArea(8,50);
		// aÑADIR oBJETOS
		
		add(pCentral, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);
		
		pCentral.add(lDistancia);
		pCentral.add(tfDistancia);
		pCentral.add(lGrosor);
		pCentral.add(tfGrosor);
		pCentral.add(lNombre);
		pCentral.add(tfNombre);
		
		pCentral.add(taResultado);
		
		
		pSur.add(bSol);
		pSur.add(bLuna);
		pSur.add(bCalcular);
		
		bCalcular.addActionListener(
			(ActionEvent e) -> {
				taResultado.setText("Para llegar a " + tfNombre.getText() + t1 +
						doblecesPapel(Long.parseLong(tfDistancia.getText()), 
						Double.parseDouble(tfGrosor.getText()), 0)+ t2 + tfGrosor.getText());
			}
		);
		bSol.addActionListener(
				(ActionEvent e) -> {
					taResultado.setText("Para llegar al Sol " + t1 + 
							doblecesPapel(150000000, 0.0000001, 0) + t2 + "0.1 mm");
				}
			);
		bLuna.addActionListener(
				(ActionEvent e) -> {
					taResultado.setText("Para llegar a la Luna " + t1 + 
							doblecesPapel(384400000, 0.0001, 0) + t2 + "0.1 mm");
				}
			);
	}

	private static int doblecesPapel(long i, double d, int n) {
		if(i < d) {
			return n;
		} else {
			return doblecesPapel(i, d*2, n + 1);
		}
	}
}