/**
 * 
 */
package es.deusto.prog3.cap01.resueltos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.deusto.prog3.cap01.ejercicios.UtilsString;

/**
 * @author i.cubillo
 *
 */
public class UtilsStringTest {

//	@Before
//	public void setUp() throws Exception {
//		System.out.println("b");
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		System.out.println("a");
//	}
//
	@Test
	public void test() {
		System.out.println("t");
//		fail("Not yet implemented");
	}
	
	@Test
	public void test2() {
		// Versión 2
				String prueba = "Hola\nEsto es un string con tres líneas\ny\tvarios\ttabuladores.";
				String prueba2 = "Hola#Esto es un string con tres líneas#y|varios|tabuladores.";
				// System.out.println( prueba );
				// System.out.println( quitarTabsYSaltosLinea( prueba ));
				if (prueba2.equals(UtilsString.quitarTabsYSaltosLinea(prueba))) {
					System.out.println( "OK" );
				} else {
					System.out.println( "FAIL" );
				}
				
				assertEquals(prueba2, UtilsString.quitarTabsYSaltosLinea(prueba));
//		fail("Not yet implemented");
	}
}
