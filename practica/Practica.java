package practica;

import java.util.Scanner;

/**
 *
 * @author Estudiantes
 */
public class Practica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        System.out.println("Bienvenido al progama, vamos a jugar con numeros ");
        String terminar="s";
        Numeros digitarnumeros=new Numeros();
        
        while(terminar.equals("s")){
            digitarnumeros.agregar10numeros();
            MostrarNumeros mostrarnumeros= new MostrarNumeros(digitarnumeros.numeros);
            System.out.println("Si quiere repetir el programa presione s sino cualquier otra cosa");
            terminar=leer.nextLine();
        }
        System.out.println("Adios gracias por usar el programa :)");
            
                
        
    }
    
}
