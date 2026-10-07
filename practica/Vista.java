package practica;

import java.util.Scanner;

/**
 * Clase Vista - Gestiona la interfaz del menú principal
 * @author Estudiantes
 */
public class Vista {
    private Numeros gestor;
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
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   Bienvenido al Gestor de Números     ║");
        System.out.println("╚════════════════════════════════════════╝");
        
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
                    case 8:
                        continuar = salir();
                        break;
                    default:
                        System.out.println("❌ Opción no válida. Intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
                leer.nextLine(); // Limpiar buffer
            }
        }
    }
    
    /**
     * Muestra las opciones del menú y retorna la opción seleccionada
     */
    private int mostrarOpciones() {
        System.out.println("\n┌────────────────────────────────────────┐");
        System.out.println("│          MENÚ PRINCIPAL               │");
        System.out.println("├────────────────────────────────────────┤");
        System.out.println("│ 1. Ingresar 10 números por teclado    │");
        System.out.println("│ 2. Ingresar 10 números aleatorios     │");
        System.out.println("│ 3. Modificar número según índice      │");
        System.out.println("│ 4. Eliminar un número                 │");
        System.out.println("│ 5. Mostrar números                    │");
        System.out.println("│ 6. Añadir más números                 │");
        System.out.println("│ 7. Calcular sumatoria de números      │");
        System.out.println("│ 8. Salir                              │");
        System.out.println("└────────────────────────────────────────┘");
        System.out.print("Selecciona una opción (1-8): ");
        
        int opcion = leer.nextInt();
        return opcion;
    }
    
    /**
     * Opción 1: Ingresar 10 números por teclado
     */
    private void ingresarNumerosPorTeclado() {
        System.out.println("\n✏️  Ingresando 10 números por teclado...");
        try {
            gestor.agregar10numeros();
            System.out.println("✅ Números ingresados correctamente.");
        } catch (Exception e) {
            System.out.println("❌ Error al ingresar números: " + e.getMessage());
        }
    }
    
    /**
     * Opción 2: Ingresar 10 números aleatorios
     */
    private void ingresarNumerosAleatorios() {
        System.out.println("\n🎲 Generando 10 números aleatorios...");
        try {
            gestor.agregar10numerosrandom();
            System.out.println("✅ Números aleatorios generados correctamente.");
            mostrarNumeros();
        } catch (Exception e) {
            System.out.println("❌ Error al generar números: " + e.getMessage());
        }
    }
    
    /**
     * Opción 3: Modificar número según índice
     */
    private void modificarNumeroPorIndice() {
        System.out.println("\n✏️  Modificar número según índice");
        try {
            System.out.print("Ingresa el índice (0-9): ");
            int indice = leer.nextInt();
            
            if (indice < 0 || indice > 9) {
                System.out.println("❌ Índice inválido. Debe estar entre 0 y 9.");
                return;
            }
            
            System.out.print("Ingresa el nuevo número: ");
            double nuevoNumero = leer.nextDouble();
            
            gestor.modificarNumeroPorIndice(indice, nuevoNumero);
            System.out.println("✅ Número modificado correctamente.");
        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Debes ingresar un número válido.");
            leer.nextLine();
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    /**
     * Opción 4: Eliminar un número
     */
    private void eliminarNumero() {
        System.out.println("\n🗑️  Eliminar un número");
        try {
            System.out.print("Ingresa el índice del número a eliminar (0-9): ");
            int indice = leer.nextInt();
            
            if (indice < 0 || indice > 9) {
                System.out.println("❌ Índice inválido. Debe estar entre 0 y 9.");
                return;
            }
            
            gestor.eliminarNumero(indice);
            System.out.println("✅ Número eliminado correctamente (establecido a 0).");
        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Debes ingresar un número válido.");
            leer.nextLine();
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    /**
     * Opción 5: Mostrar números
     */
    private void mostrarNumeros() {
        System.out.println("\n📊 Números actuales:");
        try {
            new MostrarNumeros(gestor.numeros);
        } catch (Exception e) {
            System.out.println("❌ Error al mostrar números: " + e.getMessage());
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
                System.out.println("❌ Debes ingresar una cantidad mayor a 0.");
                return;
            }
            
            gestor.anadirMasNumeros(cantidad);
            System.out.println("✅ Números agregados correctamente.");
        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Debes ingresar un número válido.");
            leer.nextLine();
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    /**
     * Opción 7: Calcular sumatoria
     */
    private void calcularSumatoria() {
        System.out.println("\n🧮 Calculando sumatoria...");
        try {
            double sumatoria = gestor.calcularSumatoria();
            System.out.println("✅ Sumatoria de los números: " + sumatoria);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    /**
     * Opción 8: Salir del programa
     */
    private boolean salir() {
        System.out.println("\n👋 ¿Estás seguro de que deseas salir? (s/n)");
        String respuesta = leer.next().toLowerCase();
        if (respuesta.equals("s")) {
            System.out.println("✅ Gracias por usar el programa. ¡Adiós!");
            return false;
        }
        return true;
    }
}
