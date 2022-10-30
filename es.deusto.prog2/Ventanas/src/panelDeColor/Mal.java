package panelDeColor;

public class Mal {
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
		private JPanel	pColorR;
		private JPanel	pColorG;
		private JPanel	pColorB;
		private JPanel	pCBG;
		
		private CheckboxGroup cbg;
		private ButtonGroup bg;
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
			
			pColorR = new JPanel();
			pColorG = new JPanel();
			pColorB = new JPanel();
			pCBG = new JPanel();
			
			pColorR.setBackground(new Color(255,000,000));
			pColorG.setBackground(new Color(000,255,000));
			pColorB.setBackground(new Color(000,000,255));
			pCBG.setLayout(new FlowLayout());
			
			cbg = new CheckboxGroup();
			bg = new ButtonGroup();
			
			cBR = new JCheckBox("Red");
			cBG = new JCheckBox("Green"); 
			cBB = new JCheckBox("Blue"); 
			
			
			
			// Añadir componentes
			this.add(pColorR, BorderLayout.CENTER);
			
			this.add(pColorG, BorderLayout.CENTER);
			this.add(pColorB, BorderLayout.CENTER);
			this.add(bg, BorderLayout.SOUTH);
			
			bg.add(cBR);
			bg.add(cBG);
			bg.add(cBB);
			
			
			this.add(pCBG, BorderLayout.SOUTH);
			
//			add(new Checkbox("Red", cbg, true));
//			add(new Checkbox("Blue", cbg, false));
//			add(new Checkbox("Green", cbg, false));
			
		      /* 
	        jCheckBox1 = new JCheckBox();
	        buttonGroup.add(jCheckBox1);
	        txJPanel.add(jCheckBox1,gridBagConstraints);

	        jCheckBox2 = new JCheckBox();
	        buttonGroup.add(jCheckBox2);
	        txJPanel.add(jCheckBox2,gridBagConstraints);

	        jCheckBox3 = new JCheckBox();
	        buttonGroup.add(jCheckBox3);
	        txJPanel.add(jCheckBox3,gridBagConstraints);

	        jCheckBox4 = new JCheckBox();
	        buttonGroup.add(jCheckBox4);
	        txJPanel.add(jCheckBox4,gridBagConstraints);
	        */
			// Gestionar eventos
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			
			
		}
	}

}
