package panelDeColor;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelDeColor extends JFrame{	
	private JPanel	pColor;
	private JPanel	pCB;
	
	private CheckboxGroup cbg;
	private JCheckBox cBR;
	private JCheckBox cBG;
	private JCheckBox cBB;
	
	
	public PanelDeColor() {
		inicializar();
	}
	
	private void inicializar() {
		// Diseño Ventana
		this.setSize(400,400);
		this.setTitle("Panel de Colores");
		this.setLayout(new GridLayout(2, 2 ));
		// Inicializar componentes
		
		pColor = new JPanel();
		pCB = new JPanel();
		
		pCB.setLayout(new GridLayout(3, 1));
		
		cbg = new CheckboxGroup();
		
		cBR = new JCheckBox("Red");
		cBG = new JCheckBox("Green"); 
		cBB = new JCheckBox("Blue"); 
		
		
		
		// Añadir componentes
		this.add(pColor, BorderLayout.CENTER);
		
		this.add(pCB, BorderLayout.SOUTH);
		
		pCB.add(cBR);
		pCB.add(cBG);
		pCB.add(cBB);
		
		add(new Checkbox("Red", cbg, true));
		add(new Checkbox("Blue", cbg, false));
		add(new Checkbox("Green", cbg, false));
		

		// Gestionar eventos
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
	}
}
