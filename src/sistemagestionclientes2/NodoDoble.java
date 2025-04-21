package sistemagestionclientes2;
public class NodoDoble {
 private Cliente cliente;
 private NodoDoble siguiente;
 private NodoDoble anterior;
 // Crear nuevo nodo doble
 public NodoDoble(Cliente cliente){
 this.cliente = cliente;
 this.siguiente = null; 
 this.anterior = null;
 }
 //obtenemos al cliente almacenamiento del nodo 
 public Cliente getCliente(){
 return cliente;
 }
 public void setCliente (Cliente cliente){
 this.cliente=cliente;
 }
 //obtenemos el siguiente nodo de la lista
 public NodoDoble getSiguiente(){
 return siguiente;
 }
 //establecemos
 public void setSiguiente(NodoDoble siguiente){
 this.siguiente =  siguiente;
 }
 //obtenemos nodo anterior
 public NodoDoble getAnterior(){
 return anterior;
 }
 //establcemos 
 public void setAnterior(NodoDoble anterior){
 this.anterior=anterior;
 }
 
 }
 
    

