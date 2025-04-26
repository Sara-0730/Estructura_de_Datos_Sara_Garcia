/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagestionclientesgui;

/**
 *
 * @author USUARIO
 */
public class ListaClientesDoble {
 private NodoDoble primero;   // Referencia al primer nodo
    private NodoDoble ultimo;    // Referencia al último nodo
    private int tamaño;         // Contador de elementos
    
    /**
     * Constructor para crear una lista vacía
     */
    public ListaClientesDoble() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }
    
    /**
     * Verifica si la lista está vacía
     * @return true si la lista está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return primero == null;
    }
    
    /**
     * Obtiene el tamaño actual de la lista
     * @return Número de elementos en la lista
     */
    public int getTamaño() {
        return tamaño;
    }
    
    /**
     * Inserta un cliente en la lista de forma ordenada por cédula
     * @param cliente Cliente a insertar
     */
    public void insertarOrdenado(Cliente cliente) {
        NodoDoble nuevoNodo = new NodoDoble(cliente);
        
        // Caso 1: Lista vacía
        if (estaVacia()) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
            tamaño++;
            return;
        }
        
        // Caso 2: Insertar al inicio (si es menor que el primero)
        if (cliente.getCedula().compareTo(primero.getCliente().getCedula()) < 0) {
            nuevoNodo.setSiguiente(primero);
            primero.setAnterior(nuevoNodo);
            primero = nuevoNodo;
            tamaño++;
            return;
        }
        
        // Caso 3: Insertar al final (si es mayor que el último)
        if (cliente.getCedula().compareTo(ultimo.getCliente().getCedula()) > 0) {
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            ultimo = nuevoNodo;
            tamaño++;
            return;
        }
        
        // Caso 4: Insertar en el medio
        NodoDoble actual = primero;
        while (actual != null && cliente.getCedula().compareTo(actual.getCliente().getCedula()) > 0) {
            actual = actual.getSiguiente();
        }
        
        // Insertar antes del nodo actual
        NodoDoble anterior = actual.getAnterior();
        
        anterior.setSiguiente(nuevoNodo);
        nuevoNodo.setAnterior(anterior);
        
        nuevoNodo.setSiguiente(actual);
        actual.setAnterior(nuevoNodo);
        
        tamaño++;
    }
    
    /**
     * Lista todos los clientes desde el primero hasta el último
     * @return String con la información de todos los clientes (de izquierda a derecha)
     */
    public String listarDerecha() {
        if (estaVacia()) {
            return "La lista de clientes está vacía";
        }
        
        StringBuilder resultado = new StringBuilder("Lista de Clientes (ordenados por cédula - Hacia la derecha):\n");
        NodoDoble actual = primero;
        int contador = 1;
        
        while (actual != null) {
            resultado.append(contador).append(". ");
            resultado.append("Cédula: ").append(actual.getCliente().getCedula());
            resultado.append(", Nombre: ").append(actual.getCliente().getNombre());
            resultado.append("\n");
            
            actual = actual.getSiguiente();
            contador++;
        }
        
        return resultado.toString();
    }
    
    /**
     * Lista todos los clientes desde el último hasta el primero
     * @return String con la información de todos los clientes (de derecha a izquierda)
     */
    public String listarIzquierda() {
        if (estaVacia()) {
            return "La lista de clientes está vacía";
        }
        
        StringBuilder resultado = new StringBuilder("Lista de Clientes (ordenados por cédula - Hacia la izquierda):\n");
        NodoDoble actual = ultimo;
        int contador = 1;
        
        while (actual != null) {
            resultado.append(contador).append(". ");
            resultado.append("Cédula: ").append(actual.getCliente().getCedula());
            resultado.append(", Nombre: ").append(actual.getCliente().getNombre());
            resultado.append("\n");
            
            actual = actual.getAnterior();
            contador++;
        }
        
        return resultado.toString();
    }
    
    /**
     * Obtiene todos los clientes para mostrar en una tabla
     * @return Array bidimensional con los datos de los clientes
     */
    public Object[][] getDatosTabla() {
        if (estaVacia()) {
            return new Object[0][0];
        }
        
        Object[][] datos = new Object[tamaño][2];
        NodoDoble actual = primero;
        int fila = 0;
        
        while (actual != null) {
            datos[fila][0] = actual.getCliente().getCedula();
            datos[fila][1] = actual.getCliente().getNombre();
            
            actual = actual.getSiguiente();
            fila++;
        }
        
        return datos;
    }
    
    /**
     * Obtiene todos los clientes en orden inverso para mostrar en una tabla
     * @return Array bidimensional con los datos de los clientes en orden inverso
     */
    public Object[][] getDatosTablaInverso() {
        if (estaVacia()) {
            return new Object[0][0];
        }
        
        Object[][] datos = new Object[tamaño][2];
        NodoDoble actual = ultimo;
        int fila = 0;
        
        while (actual != null) {
            datos[fila][0] = actual.getCliente().getCedula();
            datos[fila][1] = actual.getCliente().getNombre();
            
            actual = actual.getAnterior();
            fila++;
        }
        
        return datos;
    }
}