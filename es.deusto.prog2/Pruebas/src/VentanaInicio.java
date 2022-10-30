import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import es.deusto.proyecto.fichero.LeerUsuariosEnFichero;
import es.deusto.proyecto.fichero.UsuarioEncontradoException;
import es.deusto.proyecto.fichero.UsuarioNoEncontradoException;

public class VentanaInicio extends JFrame implements Runnable {

JLabel lblUser, lblPassword, lblRelojPrimario, reloj;
JTextField txtUser;
JPasswordField txtPassword;
JButton btnLogin, btnRegister, btnshow;
JCheckBox chckbxshow;

char echo;
   

public VentanaInicio() {
inicializar();
}

private void inicializar() {

//DEFINIR LOS OBJETOS


lblUser = new JLabel("User");
lblPassword = new JLabel("Password");
txtUser = new JTextField();
txtPassword = new JPasswordField();
btnLogin = new JButton("Login");
btnRegister = new JButton("Register");
btnshow = new JButton("Show");
lblRelojPrimario = new JLabel();
reloj = new JLabel();


//SUS COORDENADAS RESPECTIVAS

lblUser.setBounds(30, 35, 80, 25);
lblPassword.setBounds(120, 35, 160, 25);
txtUser.setBounds(30, 65, 80, 25);
txtPassword.setBounds(120, 65, 160, 25);
btnLogin.setBounds(30, 110, 80, 25);
btnRegister.setBounds(200, 110, 100, 25);
reloj.setBounds(10, 0, 300, 25);


txtPassword.setLayout(new BorderLayout());
chckbxshow = new JCheckBox();
chckbxshow.setOpaque(false);
txtPassword.add(chckbxshow, BorderLayout.EAST);


//EVENTOS

this.addWindowListener( new WindowAdapter() {
public void windowClosing(WindowEvent e) {
System.out.println("Cerrando");
System.exit(0);
}
});

btnRegister.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
dispose();
VentanaRegistrarse ventanaRegistrar = new VentanaRegistrarse();
ventanaRegistrar.setVisible(true);


}
});

chckbxshow.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
if (chckbxshow.isSelected()) {


echo = txtPassword.getEchoChar();
txtPassword.setEchoChar((char)0);

} else {
txtPassword.setEchoChar(echo);
}
}
});


// CAMBIAR DE VENTANA + COMPROBAR USUARIO + LEER FICHERO

btnLogin.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

try {
LeerUsuariosEnFichero luef = new LeerUsuariosEnFichero();
luef.usuarioExistente(txtUser.getText(), txtPassword.getText());


} catch (UsuarioNoEncontradoException unee) {
JOptionPane.showMessageDialog(null, "Error, usuario NO encontrado");
txtUser.setText("");
txtPassword.setText("");

} catch (UsuarioEncontradoException UEE) {
// TODO Auto-generated catch block
JOptionPane.showMessageDialog(null, "     Usuario encontrado!! \nACCEDIENDO A LA TIENDA ....");

dispose();
VentanaCompra ventanaBuy = new VentanaCompra();
ventanaBuy.setVisible(true);
}


}
});


//INCLUIRLOS A LA VENTANA

this.add(lblUser);
this.add(lblPassword);
this.add(txtUser);
this.add(txtPassword);
this.add(btnLogin);
this.add(btnRegister);
this.add(reloj);




//BASICOS PARA LA VENTANA

this.setSize(350, 200);
this.setTitle("Phoneshop");
this.setLayout(null);
this.setResizable(false);
this.setLocationRelativeTo(null);
   this.setVisible(true);
}