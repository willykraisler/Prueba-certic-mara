package logica;

import javax.swing.JOptionPane;



public class Adicion {

	private String delimiter[];
	private int fromIndex = 0;

	/**
	    *Calcula diferentes enteros que se encuentran delimitados con diferentes caracteres <br>
	    *@param numbers cadena con todos los valores <ol>
	    *@return num resultado de la suma de los caracteres delimitados	   
	 */
     public int add(String numbers){
		int sum=0;boolean esValido = true, termino = true;String num = "";int temp=0;
		fromIndex = conviertaDelimitadores(numbers);
		if(!numbers.isEmpty()){			
			try{		
				for (int i = fromIndex; i < numbers.length() && esValido ; i++) {					

					if(i == fromIndex){
						num = construyaNumero(i,numbers);						
						sum+= Integer.parseInt(num);
						i += fromIndex-1;
					}else{	

						for(int j=0 ; j<delimiter.length && termino ; j++){

							if(delimiter[j]!=null ){
								temp = numbers.indexOf(delimiter[j],i);							
								if(temp != -1  && temp == i){									
									i += delimiter[j].length();
									num = construyaNumero(i,numbers);								
									sum+= Integer.parseInt(num);
									i += fromIndex-1;
									termino = false;								
								}										
							}else{
								termino = false;
								esValido = false;
							}
						}
					}
					termino =true; 
				}
			}catch(NumberFormatException e){
				System.out.println("El primer caracter no es un número:"+e.getMessage());
				 JOptionPane.showMessageDialog(null,"La cadena no es valida:","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		return sum;
	}
     
     /**
	    *separa los delimitadores en un arreglo<br>
	     *@param numbers cadena con todos los valores <ol>
	    *@return retorna la posicion donde empezan los numeros <ol>	   
	 */
	private int conviertaDelimitadores(String numbers) {
		boolean ok=true;		
		int cont = 0, i = 0 ;
		String deliConcatenado = "";
		delimiter =  new String[numbers.length()/2];

		if(String.valueOf((numbers.charAt(0))).equals("/") && String.valueOf((numbers.charAt(1))).equals("/") && String.valueOf((numbers.charAt(2))).equals("[") && ok ){			

			for(int k = 3 ; k < numbers.length() && ok; k++){ 

				if(!(String.valueOf((numbers.charAt(k))).equals("]")) && !(String.valueOf((numbers.charAt(k))).equals("["))){					
					deliConcatenado = deliConcatenado +  String.valueOf((numbers.charAt(k)));	
				}else if((String.valueOf((numbers.charAt(k))).equals("]"))){
					delimiter[i] = deliConcatenado;			
					deliConcatenado = "";	
					i++;
				if((String.valueOf((numbers.charAt(k+1))).equals(">"))){
						cont = k;	
						ok = false;
					}
				}

			}
		}		
		return cont+2;	
	}
	
	/**
	    *construye un numero de mas de 3 cifras<br>
	    *@param numbers cadena con todos los valores <ol>
	    *@param index donde comienza el procesamiento de la cadena hasta que finalice <ol>
	    *@throws NumberFormatException si ya no es un numero para continuar el recorrido de la cadena <ol>
	 */
	private String construyaNumero(int index, String numbers){

		boolean paso = true;String numero = "";String numeros = "0,1,2,3,4,5,6,7,8,9";
		String[] arraynumeros = numeros.split(","); boolean ok = true;
		fromIndex = 0;
		for(int k = index; k <numbers.length() && ok ;k++){
	
			try{
				Integer.parseInt(String.valueOf(numbers.charAt(k)));
				for(int j = 0;j < arraynumeros.length && paso ;j++ ){
					if(arraynumeros[j].equals(String.valueOf(numbers.charAt(k)))){
						numero = numero + String.valueOf((numbers.charAt(k)));
						paso = false;
						fromIndex++;
					}			
					if(numero.length()>3){
						System.out.println("cad1> "+ numero);
						numero = "0";
						ok = false;						
					}
					paso = true;
				}
			}catch(NumberFormatException e){				
				return numero;
			}
		}	
		return numero;
	}

}