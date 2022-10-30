package concesionario;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.xml.crypto.Data;

@SuppressWarnings("serial")
public class VentanaInicio extends JFrame implements ActionListener {

	protected JPanel pCentral, pSur;
	protected JLabel lN, lCU, lCC, lCE;
	protected static JTextField tU;
	protected JPasswordField tC;
	protected JButton bAceptar, bCancelar, bRegistrar;
	static String textFilePath = "src/data/registros.txt";
	protected static HashMap<Integer, ArrayList<Object>> userData = new HashMap<>();

	public VentanaInicio() {
		// TODO Auto-generated constructor stub
		inicializar();
		setVisible(true);
	}

	public void inicializar() {
		lecturaRegistros();

		// Diseï¿½o Ventana
		this.setSize(400, 400);
		this.setTitle("Inicio Sesion");
		// Inicializar componentes
		pCentral = new JPanel();
		pSur = new JPanel();

		lN = new JLabel("Iniciar Sesion");
		lCU = new JLabel("Usuario:");
		lCC = new JLabel("Contraseña");
		lCE = new JLabel("");

		tU = new JTextField();
		tC = new JPasswordField();

		bCancelar = new JButton("Cancelar");
		bAceptar = new JButton("Aceptar");
		bRegistrar = new JButton("Registrarse");
		bCancelar.addActionListener(this);
		bAceptar.addActionListener(this);
		bRegistrar.addActionListener(this);

		// Añadir componentes
		pCentral.setSize(400, 50);

		getContentPane().add(lN, BorderLayout.NORTH);
		getContentPane().add(pCentral, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);

		lN.setHorizontalAlignment(SwingConstants.CENTER);
		lCU.setHorizontalAlignment(SwingConstants.CENTER);
		lCC.setHorizontalAlignment(SwingConstants.CENTER);

		pSur.setLayout(new GridLayout(1, 2));

		pCentral.setLayout(new GridLayout(0, 2));

		pCentral.add(lCU);
		pCentral.add(tU);
		pCentral.add(lCC);
		pCentral.add(tC);
		pCentral.add(lCE);

		pSur.add(bCancelar);
		pSur.add(bAceptar);

		// Gestionar eventos
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void lecturaRegistros() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(textFilePath));

			String line;
			while ((line = br.readLine()) != null) {
				String[] campos = line.split(";");
				int A = Integer.parseInt(campos[0]);
				int B = Integer.parseInt(campos[1]);
				String C = campos[2];
				ArrayList<Object> newlist = new ArrayList<>();
				newlist.add(B);
//				newlist.add(C);
				for (int i = 2; i < campos.length; i++) {
					String D = campos[i];
					newlist.add(D);
				}

				userData.put(A, newlist);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bAceptar) {
			if (userData.containsKey(tU.getText().hashCode())) {
				if (userData.get(tU.getText().hashCode()).get(0).equals(tC.getText().hashCode())) {
					if (userData.get(tU.getText().hashCode()).get(1).equals("null")) {
					} else {
						String eCoche = (String) userData.get(tU.getText().hashCode())
								.get(userData.get(tU.getText().hashCode()).size() - 1);
						ArrayList<Object> listaAniadir = new ArrayList<Object>();
						for (int i = 0; i < userData.get(tU.getText().hashCode()).size(); i++) {
							listaAniadir.add(userData.get(tU.getText().hashCode()).get(i));
						}
						VentanaConcesionario.nombreCoche = new Coche(eCoche.substring(0, 1), eCoche.substring(1, 2),
								eCoche.substring(2, 3), eCoche.substring(3, 4), false, false);
						VentanaConcesionario.usuarioActual = new Usuario(tU.getText().hashCode(),
								tC.getText().hashCode(), VentanaConcesionario.nombreCoche);
						VentanaConcesionario.usuarioActual.setUserData(listaAniadir);
					}
					VentanaConcesionario vc = new VentanaConcesionario();
					this.dispose();
				}
			} else {
				lCE.setText("Contraseña incorrecta");
				pCentral.add(bRegistrar);
			}
		} else if (e.getSource() == bCancelar) {
			System.exit(0);
		} else if (e.getSource() == bRegistrar && !userData.containsKey(tU.getText().hashCode())) {
			Usuario newUser = new Usuario(tU.getText().hashCode(), tC.getText().hashCode(), null);
			userData.put(newUser.getUsuarioHash(), newUser.getUserData());
			VentanaConcesionario.usuarioActual = newUser;
			this.dispose();
			VentanaConcesionario vc = new VentanaConcesionario();
		}
	}

	public static void guardarCompra(Coche nombreCoche) {
		VentanaConcesionario.usuarioActual.setCocheActual(nombreCoche);
		if (VentanaConcesionario.usuarioActual.getUserData()
				.get(VentanaConcesionario.usuarioActual.getUserData().size() - 1).equals("null")) {
			VentanaConcesionario.usuarioActual.getUserData()
					.set(VentanaConcesionario.usuarioActual.getUserData().size() - 1, nombreCoche.getNombreCoche());
		} else {
			VentanaConcesionario.usuarioActual.getUserData().add(nombreCoche.getNombreCoche());
		}
	}
}
