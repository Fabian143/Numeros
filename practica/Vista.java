package practica;

import java.util.Scanner;

/**
 * Clase Vista - Gestiona la interfaz del menú principal
 * @author Estudiantes
 */
public class Vista {
    private Numeros digitadornumeros;
    private Scanner leer;
    
    /**
     * Constructor de la clase Vista
     */
    public Vista() {
        this.gestor = new Numeros();
        this.leer = new Scanner(System.in);
    }
    
    /**
     * Método principal que muestra el menú y gestiona las opciones
     */
    public void mostrarMenu() {
        
        int opcion = 0;
        boolean continuar = true;
        
        while (continuar) {
            try {
                opcion = mostrarOpciones();
                
                switch (opcion) {
                    case 1:
                        ingresarNumerosPorTeclado();
                        break;
                    case 2:
                        ingresarNumerosAleatorios();
                        break;
                    case 3:
                        modificarNumeroPorIndice();
                        break;
                    case 4:
                        eliminarNumero();
                        break;
                    case 5:
                        mostrarNumeros();
                        break;
                    case 6:
                        anadirMasNumeros();
                        break;
                    case 7:
                        calcularSumatoria();
                        break;
                    default:
                        System.out.println(" Opción no válida. Intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println(" Error: " + e.getMessage());
            }
        }
    }
    
    /**
     * Muestra las opciones del menú y retorna la opción seleccionada
     */
    private int mostrarOpciones() {
        System.out.println(" 1. Ingresar 10 números por teclado");
        System.out.println("2. Ingresar 10 números aleatorios");
        System.out.println("3. Modificar número según índice");
        System.out.println("4. Eliminar un número");
        System.out.println("5. Mostrar números");
        System.out.println("6. Añadir más números");
        System.out.println("7. Calcular sumatoria de números");
        System.out.print("Selecciona una opción (1-7): ");
        
        int opcion = leer.nextInt();
        return opcion;
    }
    
    /**
     * Opción 1: Ingresar 10 números por teclado
     */
    private void ingresarNumerosPorTeclado() {
        System.out.println("\n  Ingresando 10 números por teclado...");
        try {
            digitadornumeros.agregar10numeros();
            System.out.println("\nNúmeros ingresados correctamente.");
        } catch (Exception e) {
            System.out.println(" Error al ingresar números: " + e.getMessage());
        }
    }
    
    /**
     * Opción 2: Ingresar 10 números aleatorios
     */
    private void ingresarNumerosAleatorios() {
        System.out.println("\n Generando 10 números aleatorios...");
        try {
            digitadornumeros.agregar10numerosrandom();
            System.out.println("\nNúmeros aleatorios generados correctamente.");
        } catch (Exception e) {
            System.out.println("Error al generar números: " + e.getMessage());
        }
    }
    
    /**
     * Opción 3: Modificar número según índice
     */
    private void modificarNumeroPorIndice() {
        System.out.println("\n  Modificar número según índice");
        try {
            System.out.print("Ingresa el índice (1-10): ");
            int indice = leer.nextInt();
            
            if (indice < 1 || indice > 10) {
                System.out.println(" Índice inválido. Debe estar entre 1 y 10.");
                return;
            }
            
            System.out.print("Ingresa el nuevo número: ");
            double nuevoNumero = leer.nextDouble();
            digitadornumeros.modificarNumeroPorIndice(indice, nuevoNumero);
            System.out.println(" Número modificado correctamente.");
            
        } catch (java.util.InputMismatchException e) {
            System.out.println(" Error: Debes ingresar un número válido.");
            leer.nextLine();
        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
    
    /**
     * Opción 4: Eliminar un número
     */
    private void eliminarNumero() {
        System.out.println("\nEliminar un número");
        try {
            System.out.print("Ingresa el índice del número a eliminar (1-10): ");
            int indice = leer.nextInt();
            
            if (indice < 1 || indice > 10) {
                System.out.println(" Índice inválido. Debe estar entre 1 y 10.");
                return;
            }
            digitadornumeros.eliminarNumero(indice);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Debes ingresar un número válido.");
            leer.nextLine();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Opción 5: Mostrar números
     */
    private void mostrarNumeros() {
        System.out.println("\n Números actuales:");
        try {
            new MostrarNumeros(digitadornumeros.numeros);
        } catch (Exception e) {
            System.out.println(" Error al mostrar números: " + e.getMessage());
        }
    }
    
    /**
     * Opción 6: Añadir más números
     */
    private void anadirMasNumeros() {
        System.out.println("\n➕ Añadir más números");
        try {
            System.out.print("¿Cuántos números deseas agregar? ");
            int cantidad = leer.nextInt();
            
            if (cantidad <= 0) {
                System.out.println(" Debes ingresar una cantidad mayor a 0.");
                return;
            }
            
            digitadornumeros.anadirMasNumeros(cantidad);
            System.out.println(" Números agregados correctamente.");
        } catch (java.util.InputMismatchException e) {
            System.out.println(" Error: Debes ingresar un número válido.");
            leer.nextLine();
        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
    
    /**
     * Opción 7: Calcular sumatoria
     */
    private void calcularSumatoria() {
        try {
            double sumatoria = digitadornumeros.calcularSumatoria();
            System.out.println(" \nSumatoria de los números: " + sumatoria);
        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
    
}
