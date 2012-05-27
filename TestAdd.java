package pruebas;
import logica.Adicion;
import org.junit.Test;



public class TestAdd {
	@Test
	public void pruebaMetAdd() {
		int sum = 0;
		boolean validado = false;
		
		Adicion addUno = new  Adicion();
	
		try {
			sum = addUno.add("//[**][$$]>69**8$$7");			
		    System.out.println("La sumas es : " +sum);
		    if(sum == 84)validado = true;
		     
			
		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		junit.framework.Assert.assertTrue("El metodo add no ha sumado correctamente",validado);
	}
}
