package Videojuego;

import java.util.Scanner;

public class Comprobacion {
    
    public boolean validarDNI(String dni) { //Pedimos un DNI y comprobamos 
    	
		
	
    	boolean salida = false ; 
    	if(dni.length()==9) {
    		
    		
    		String datos[] = dni.split("");
    		
    		for(int i = 0; i< datos.length-1;i++) {//tiene 9
    			
    			if (Character.isDigit(datos[i].charAt(0))){
    				int numeros = Integer.parseInt(datos[i]);
    				String letra = CalcularLetra(numeros);
    				if(letra.equals(datos[8])) {
    				salida = true;
    				}
    			}else {
    				
    			}
    		}
    		
    	}
    

    return salida ; 
    }

    
    String CalcularLetra(int numeros) {
        int resto;
        resto = numeros % 23;
        String letra="";
        
        switch(resto) {
            case 0:
                letra = "T";
                break;
            case 1:
                letra = "R";
                break;
            case 2:
                letra = "W";
                break;
            case 3:
                letra = "A";
                break;
            case 4:
                letra = "G";
                break;
            case 5:
                letra = "M";
                break;
            case 6:
                letra = "Y";
                break;
            case 7:
                letra = "F";
                break;
            case 8:
                letra = "P";
                break;
            case 9:
                letra = "D";
                break;
            case 10:
                letra = "X";
                break;
            case 11:
                letra = "B";
                break;
            case 12:
                letra = "N";
                break;
            case 13:
                letra = "J";
                break;
            case 14:
                letra = "Z";
                break;
            case 15:
                letra = "S";
                break;
            case 16:
                letra = "Q";
                break;
            case 17:
                letra = "V";
                break;
            case 18:
                letra = "H";
                break;
            case 19:
                letra ="L";
                break;
            case 20:
                letra = "C";
                break;
            case 21:
                letra = "K";
                break;
            case 22:
                letra = "E";
                break;
        }
        return letra;
    }
	 

}
