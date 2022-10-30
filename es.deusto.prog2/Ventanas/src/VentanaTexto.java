import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class VentanaTexto extends Frame implements KeyListener {
	private TextField texto;
	public VentanaTexto() {
		texto = new TextField(10); add(texto);
		texto.addKeyListener(this);
		setSize(400, 200); setVisible(true);
		}
		public static void main(String[] args) {
		new Ventana();
		}
		// escuchadores de KeyEvent
		@Override
		public void keyTyped(KeyEvent evt) {
		System.out.println("Tecla: " + evt.getKeyChar());
	}
	// Sin usar, pero necesarios para cumplir la interfaz
	@Override public void keyPressed(KeyEvent evt) { }
	@Override public void keyReleased(KeyEvent evt) { }
}