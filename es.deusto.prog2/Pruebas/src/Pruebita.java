
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 * Example of Fonts.
 * 
 * @author Chuidiang
 * 
 */
public class Pruebita {

   public static void main(String[] args) throws InterruptedException {
	   
	  
	   
      // List all available fonts.
      String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getAvailableFontFamilyNames();
      System.out.println(Arrays.toString(fontNames));

      // A windows with a label.
      JFrame frame = new JFrame("Fonts Example");
      JLabel label = new JLabel();
      
      Object[]ops = {"Sí","No","Cancelar" };
	   JOptionPane.showOptionDialog( frame, "¿Confirmar?", "Borrado",
	   JOptionPane.YES_NO_CANCEL_OPTION,
	   JOptionPane.QUESTION_MESSAGE, null,
	   ops, ops[0]);
      
      label.setHorizontalAlignment(SwingConstants.CENTER);
      frame.getContentPane().add(label);
      frame.setSize(400, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);

      // Show a text for each font
      for (String font : fontNames) {
         label.setText("Hi, I'm " + font);
         label.setFont(new Font(font, Font.PLAIN, 15));
         Thread.sleep(1000);
      }
   }

}