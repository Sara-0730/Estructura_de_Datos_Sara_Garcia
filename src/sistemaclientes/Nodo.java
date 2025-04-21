package sistemaclientes;
/**
 * Clase Nodo que representa cada elemento de la lista enlazada
 * Contiene un cliente y una referencia al siguiente nodo
 */
class Nodo {
    private Cliente cliente;
    private Nodo siguiente;
    
    /**
     * Constructor para crear un nuevo nodo
     * @param cliente Cliente que se almacenará en el nodo
     */
    public Nodo(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
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
    public Nodo getSiguiente() {
        return siguiente;
    }
    
    /**
     * Establece el siguiente nodo en la lista
     * @param siguiente Nuevo nodo siguiente
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}