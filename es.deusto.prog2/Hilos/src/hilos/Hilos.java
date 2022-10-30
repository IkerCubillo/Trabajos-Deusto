package hilos;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Hilos extends Frame{
	
	private JPanel pPrincipal;
	private JTextField tfCount;
	private JButton btnStart;
	private JButton btnStop;
	private JLabel lCounter;
	int count = 1;
	boolean stop = false;
	
	public Hilos() {
		inicializar();
	}
	
	public void inicializar() {
		this.setSize(400,400);
		
		
		lCounter = new JLabel("Counter");
		pPrincipal = new JPanel();
		tfCount = new JTextField(16);
		btnStart = new JButton("Start Counting");
		btnStop = new JButton("Finish Counting");
		
		this.add(pPrincipal);
		pPrincipal.setLayout(new FlowLayout());
		
		pPrincipal.add(lCounter);
		pPrincipal.add(tfCount);
		pPrincipal.add(btnStart);
		pPrincipal.add(btnStop);
		tfCount.setEditable(false);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				Thread t = new Thread(new Runnable() {
					@Override
					public void run() {
					// c�digo del hilo
						stop = false;
						for (int i = 0; i < 100000000; i++) {
							if (stop) break; // Si se pulsa el bot�n stop, salimos del bucle
							tfCount.setText(count + "");
							++count;
						}
					}
				});
				t.start();
			}
		});
		
		
		
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				stop = true;
			}
		});
	}
}
