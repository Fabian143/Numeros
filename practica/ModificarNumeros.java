package practica;

import java.util.Scanner;

/**
 * Clase para modificar y eliminar números del arreglo.
 * @author Estudiantes
 */
public class ModificarNumeros {
    private final Scanner leer = new Scanner(System.in);

    public void cambiarnumero(int i, double numeros[]) {
        double numero = leer.nextDouble();
        numeros[i] = numero;
    }

    /**
     * Elimina el número de la posición indicada poniendo 0.
     */
    public void eliminarPorCero(int indice, double[] numeros) {
        if (indice < 0 || indice >= numeros.length) {
            throw new IllegalArgumentException("Índice fuera de rango.");
        }
        numeros[indice] = 0;
    }

    /**
     * Elimina el número de la posición indicada usando desplazamiento del array.
     * El último lugar queda en 0.
     */
    public void eliminarPorArray(int indice, double[] numeros) {
        if (indice < 0 || indice >= numeros.length) {
            throw new IllegalArgumentException("Índice fuera de rango.");
        }

        for (int i = indice; i < numeros.length - 1; i++) {
            numeros[i] = numeros[i + 1];
        }
        numeros[numeros.length - 1] = 0;
    }
}
