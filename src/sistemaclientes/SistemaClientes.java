package sistemaclientes;

/**
 *
 * @author SaraGarcia
 */
/**
 * Clase principal del sistema que implementa el menú y la interacción con el usuario
 */
import java.util.Scanner;

public class SistemaClientes {
    /**
     * Método principal que inicia la aplicación
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        ListaClientes lista = new ListaClientes();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        
        System.out.println("Sistema de Gestion de Clientes");
        
        // Bucle principal del menú
        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion(scanner);
            
            switch (opcion) {
                case 1:
                    insertarCliente(scanner, lista);
                    break;
                case 2:
                    listarClientes(lista);
                    break;
                case 3:
                    System.out.println("Gracias por utilizar el sistema. ¡Hasta pronto!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Muestra el menú de opciones al usuario
     */
    private static void mostrarMenu() {
        System.out.println("\n===== MENU DE OPCIONES =====");
        System.out.println("1. Insertar cliente");
        System.out.println("2. Listar clientes hacia la derecha");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opcion: ");
    }
    
    /**
     * Lee y valida la opción ingresada por el usuario
     * @param scanner Scanner para leer la entrada
     * @return Opción seleccionada (número entero)
     */
    private static int leerOpcion(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Opción inválida
        }
    }
    
    /**
     * Solicita los datos del cliente y lo inserta en la lista
     * @param scanner Scanner para leer la entrada
     * @param lista Lista donde se insertará el cliente
     */
    private static void insertarCliente(Scanner scanner, ListaClientes lista) {
        System.out.println("\n-- Insertar Nuevo Cliente --");
        
        System.out.print("Ingrese la cedula del cliente: ");
        String cedula = scanner.nextLine();
        
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        
        Cliente nuevoCliente = new Cliente(cedula, nombre);
        lista.insertarOrdenado(nuevoCliente);
        
        System.out.println("Cliente insertado correctamente.");
    }
    
    /**
     * Muestra la lista de clientes
     * @param lista Lista de clientes a mostrar
     */
    private static void listarClientes(ListaClientes lista) {
        System.out.println("\n-- Lista de Clientes --");
        System.out.println(lista.listarDerecha());
    }
}