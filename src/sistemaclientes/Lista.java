package sistemaclientes;
/**
 * Clase ListaClientes que implementa una lista enlazada simple
 * para gestionar los clientes del sistema
 */
class ListaClientes {
    private Nodo cabeza;
    
    /**
     * Constructor para crear una lista vacía
     */
    public ListaClientes() {
        this.cabeza = null;
    }
    
    /**
     * Verifica si la lista está vacía
     * @return true si la lista está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return cabeza == null;
    }
    
    /**
     * Inserta un cliente en la lista de forma ordenada por cédula
     * @param cliente Cliente a insertar
     */
    public void insertarOrdenado(Cliente cliente) {
        Nodo nuevoNodo = new Nodo(cliente);
        
        // Si la lista está vacía o el nuevo cliente debe ir al principio
        if (estaVacia() || cliente.getCedula().compareTo(cabeza.getCliente().getCedula()) < 0) {
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
            return;
        }
        
        // Buscar la posición correcta para insertar
        Nodo actual = cabeza;
        while (actual.getSiguiente() != null && 
               cliente.getCedula().compareTo(actual.getSiguiente().getCliente().getCedula()) > 0) {
            actual = actual.getSiguiente();
        }
        
        // Insertar en la posición encontrada
        nuevoNodo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevoNodo);
    }
    
    /**
     * Lista todos los clientes desde la cabeza hasta el final
     * @return String con la información de todos los clientes
     */
    public String listarDerecha() {
        if (estaVacia()) {
            return "La lista de clientes está vacía";
        }
        
        StringBuilder resultado = new StringBuilder("Lista de Clientes (ordenados por cédula):\n");
        Nodo actual = cabeza;
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
}