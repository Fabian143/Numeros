package practica;

import java.util.Scanner;

/**
 *
 * @author Estudiantes
 */
public class ModificarNumeros {
    Scanner leer=new Scanner(System.in);
    
    public void cambiarnumero(int i,double numeros[]){
        double numero=leer.nextDouble();
        numeros[i]=numero;
    }
    
   
}
