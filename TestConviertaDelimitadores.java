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

public class TestConviertaDelimitadores {
	
        /**
	 * En esta prueba busca retornar la posición luego de que analizo cada uno de los delimitadores
	 * para que el metodo add inicie desde ahi a operar con cada uno de los diferentes operdaroes validos 
	 * almacenados en el arreglo delimiter[]
	 */
	
	
	@Test
	public void pruebaMetConviertaDelimitadores() {
		int pos = 0;
		boolean validado = false;
		
		Adicion addUno = new  Adicion();
	
		try {
			pos = addUno.conviertaDelimitadores("//[&&][#]>69**8$$7");			
		    System.out.println("La posición en la que queda es : " + pos);
		    if(pos == 10)validado = true;
		     
			
		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		junit.framework.Assert.assertTrue("El metodo ConviertaDelimitadores no ha analizado todos los delimitadores correctamente ",validado);
	}

}