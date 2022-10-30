package colorPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorPanel extends JFrame {
	Random rand = new Random();
	int limite = 255;
	int numeroAleatorio = rand.nextInt(limite);
	int numeroAleatorio2 = rand.nextInt(limite);
	int numeroAleatorio1 = rand.nextInt(limite);
	private JPanel	pColor;
	private JPanel	pSlider;
	
	private JSlider	sSliderR;
	private JSlider	sSliderG;
	private JSlider	sSliderB;
	
	public ColorPanel() {
		inicializar();
		changeColour();
	}
	
	private void inicializar() { 
		// Dise�o Ventana
		this.setSize(400,400);
		this.setTitle("Panel de Colores");	
		
		
		// Inicializar componentes
		
		pColor = new JPanel();
		pSlider = new JPanel();
		
		sSliderR = new JSlider(JSlider.HORIZONTAL, 0, 255, numeroAleatorio);
		sSliderR.setMajorTickSpacing(50);
		sSliderR.setMinorTickSpacing(5);
		sSliderR.setPaintTicks(true);
		sSliderR.setPaintLabels(true);
		
		sSliderG = new JSlider(JSlider.HORIZONTAL, 0, 255, numeroAleatorio1);
		sSliderG.setMajorTickSpacing(50);
		sSliderG.setMinorTickSpacing(5);
		sSliderG.setPaintTicks(true);
		sSliderG.setPaintLabels(true);
		
		sSliderB = new JSlider(JSlider.HORIZONTAL, 0, 255, numeroAleatorio2);
		sSliderB.setMajorTickSpacing(50);
		sSliderB.setMinorTickSpacing(5);
		sSliderB.setPaintTicks(true);
		sSliderB.setPaintLabels(true);
		
		// A�adir componentes
		this.add(pColor, BorderLayout.CENTER);
		this.add(pSlider, BorderLayout.SOUTH);
		pSlider.setLayout(new GridLayout(3,1));
		
		pSlider.add(sSliderR);
		pSlider.add(sSliderG);
		pSlider.add(sSliderB);
		
		// Gestionar eventos
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		sSliderR.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				changeColour();
			}
		});
		sSliderG.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				changeColour();
			}
		});
		sSliderB.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				changeColour();
			}
		});
		
	}
	private void changeColour() {
		// TODO Auto-generated method stub
		pColor.setBackground( new Color(sSliderR.getValue(), sSliderG.getValue(), sSliderB.getValue()) );
	}
}
