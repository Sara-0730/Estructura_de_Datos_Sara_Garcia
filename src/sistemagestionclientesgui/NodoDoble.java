/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagestionclientesgui;

/**
 *
 * @author USUARIO
 */
public class NodoDoble {
    private Cliente cliente;
    private NodoDoble siguiente;
    private NodoDoble anterior;
    
    /**
     * Constructor para crear un nuevo nodo doble
     * @param cliente Cliente que se almacenará en el nodo
     */
    public NodoDoble(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
        this.anterior = null;
    }
    
    /**
     * Obtiene el cliente almacenado en el nodo
     * @return Cliente del nodo
     */
    public Cliente getCliente() {
        return cliente;
    }
    
    /**
     * Establece el cliente del nodo
     * @param cliente Nuevo cliente para asignar
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    /**
     * Obtiene el siguiente nodo en la lista
     * @return Referencia al siguiente nodo
     */
    public NodoDoble getSiguiente() {
        return siguiente;
    }
    
    /**
     * Establece el siguiente nodo en la lista
     * @param siguiente Nuevo nodo siguiente
     */
    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
    
    /**
     * Obtiene el nodo anterior en la lista
     * @return Referencia al nodo anterior
     */
    public NodoDoble getAnterior() {
        return anterior;
    }
    
    /**
     * Establece el nodo anterior en la lista
     * @param anterior Nuevo nodo anterior
     */
    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}