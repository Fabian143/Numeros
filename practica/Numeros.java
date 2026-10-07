package practica;

/**
 *
 * @author Estudiantes
 */

import java.util.Scanner;

public class Numeros {
      // atributos
        Scanner llenar =new Scanner(System.in);
        public double numeros[]=new double[10];
        
       //metodos
        public void agregarnumero(int i){
            System.out.print("Digite el numero "+ (i+1) +" :");
            double numero=llenar.nextDouble();
            numeros[i]=numero;
        }
        
        public void agregar10numeros(){
            for(int i=0;i<10;i++){
                agregarnumero(i);
            }
        }
        
        public void agregarnumerorandom(int i){
            numeros[i]= Math.random();
        }
        
        public void agregar10numerosrandom(){
            for(int i=0;i<10;i++){
                agregarnumerorandom(i);
            }
        }
        
}
