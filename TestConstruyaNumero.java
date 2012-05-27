/**
 * 
 */
package pruebas;
import logica.Adicion;


import org.junit.Test;

/**
 * @author Otilanor
 *
 */

public class TestConstruyaNumero {
	
        /**
	 * Esta prueba retorna en un string el numero que se pudo construir menor que 1000
	 * de lo contrario retorna 0 y se le pasa como parametro los números que  
	 */
	
	
	@Test
	public void pruebaMetConstruyaNumero() {
		String numero = "";
		boolean validado = false;
		
		Adicion addUno = new  Adicion();
	
		try {
			numero = addUno.construyaNumero(10,"//[&&][#]>698**8");			
		    System.out.println("La posición en la que queda es : " + numero);
		    if(numero.equals("698"))validado = true;
		     
			
		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		junit.framework.Assert.assertTrue("El metodo contruyaNumero no pudo construir el número correctamente ",validado);
	}

}