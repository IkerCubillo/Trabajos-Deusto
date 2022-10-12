package es.deusto.prog3.cap01.ejercicios;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;


public class CancionTest {
	
	Cancion cancion1;
	Cancion cancion2;
	
	@Before
	public void setUp() throws Exception {
		cancion1 = new Cancion("Bad Romance");
		cancion2 = new Cancion("Edge of Glory", 320);
	}

	
//	@After
//	public void tearDown() throws Exception {
//		System.out.println( "a" );
//	}

	@Test
	public void testConstructorNombre() {
		assertEquals("Bad Romance", cancion1.nombre );
		Cancion cancion3 = new Cancion("");
		assertEquals("", cancion3.nombre );
		Cancion cancion4 = new Cancion(null);
		assertEquals("", cancion4.nombre );
	}
	
	@Test
	public void testConstructorNombreYDuracion() {
		assertEquals("Edge of Glory", cancion2.nombre );
		assertEquals(320, cancion2.getDuracionEnSegundos() );
		try {
			Cancion cancion3 = new Cancion("Hola", 0);
			assertEquals(0, cancion3.getDuracionEnSegundos() );
		} catch (CancionException e) {
			fail("Duracion incorrecta pero es cero");
		}
		
		try {
			Cancion cancion3 = new Cancion("Hola", -5);
			fail("Excepcion no lanzada");
		} catch (Exception e) {
			// Pasa el test porque genera la excepcion
		}
	}
	
	@Test
	public void testSetNombre() {
		cancion1.setNombre("Poker Face");
		assertEquals("Poker Face", cancion1.nombre);
		//  TODO null, ""
	}
	
	// TODO getters igual
	@Test
	public void testGetters() throws CancionException {
		Cancion cancion3 = new Cancion("", 1000000);
		Cancion cancion4 = new Cancion(null);
		// getNombre()
		assertEquals("Bad Romance", cancion1.getNombre());
		assertEquals("", cancion3.getNombre());
		assertEquals("", cancion4.getNombre());
		// getDuracion()
		assertEquals("00:00:00", cancion1.getDuracion());
		assertEquals("00:05:20", cancion2.getDuracion());
		assertEquals("277:46:40", cancion3.getDuracion());
		// getDuracionEnSegundos()
		assertEquals(0, cancion1.getDuracionEnSegundos());
		assertEquals(320, cancion2.getDuracionEnSegundos());
		assertEquals(1000000, cancion3.getDuracionEnSegundos());
	}
	
	// TODO setDuracionEnSegundos igual
	
	@Test
	public void testSetDuracionEnSegundos() throws CancionException {
		cancion1.setDuracionEnSegundos(45);
		assertEquals("00:00:45", cancion1.getDuracion());
		cancion1.setDuracionEnSegundos(60);
		assertEquals("00:01:00", cancion1.getDuracion());
		cancion1.setDuracionEnSegundos(62);
		assertEquals("00:01:02", cancion1.getDuracion());
		cancion1.setDuracionEnSegundos(123);
		assertEquals("00:02:03", cancion1.getDuracion());
		cancion1.setDuracionEnSegundos(3615);
		assertEquals("01:00:15", cancion1.getDuracion());
		cancion1.setDuracionEnSegundos(3600*102);
		assertEquals("102:00:00", cancion1.getDuracion());
	}
	
	@Test
	public void testGetDuracion() throws CancionException {
		cancion1.setDuracionEnSegundos(45);
		assertEquals("00:00:45", cancion1.getDuracion());
		cancion1.setDuracionEnSegundos(60);
		assertEquals("00:01:00", cancion1.getDuracion());
		cancion1.setDuracionEnSegundos(62);
		assertEquals("00:01:02", cancion1.getDuracion());
		cancion1.setDuracionEnSegundos(123);
		assertEquals("00:02:03", cancion1.getDuracion());
		cancion1.setDuracionEnSegundos(3615);
		assertEquals("01:00:15", cancion1.getDuracion());
		cancion1.setDuracionEnSegundos(3600*102);
		assertEquals("102:00:00", cancion1.getDuracion());
	}
	
	@Test
	public void testGetDuracion2() throws CancionException {
		int[] duracionSgs = {45,60,62,123,3615,3600*102};
		String[] duracionHMS = { "00:00:45", "00:01:00", "00:01:02", "00:02:03", "01:00:15", "102:00:00"};
		
		for(int i = 0; i<duracionSgs.length; i++) {
			cancion1.setDuracionEnSegundos(duracionSgs[i]);
			assertEquals(duracionHMS[i], cancion1.getDuracion());
		}
	}
	
//	@Test
//	public void testGetVentanaCancion() {
//		JFrame v = cancion2.getVentanaCancion();
//		v.setVisible(true);
//		// Titulo
//		assertEquals("Ventana canción", v.getTitle());
//		// Nombre de la cancion
//		assertEquals( cancion2.getNombre(), cancion2.tfNombre.getText());
//		// Cambio nombre de la cancion
//		cancion2.tfNombre.setText("Nombre nuevo");
//		try {
//			Robot robot = new Robot();
//			robot.keyPress(KeyEvent.VK_ENTER);
//			try{Thread.sleep(50);} catch (Exception e) {}
//			robot.keyRelease(KeyEvent.VK_ENTER);
//		} catch (AWTException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		assertEquals("Nombre nuevo", cancion2.getNombre());
//		try{Thread.sleep(5000);} catch (Exception e) {}
//		v.dispose();
//	}

}
