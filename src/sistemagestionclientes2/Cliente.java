package sistemagestionclientes2;
public class Cliente {
    private String cedula;
    private String nombre;
    //crear nuevo cliente
public Cliente(String cedula, String nombre){
this.cedula= cedula;
this.nombre= nombre;
}   
//Obtener cedula del cliente 
public String getCedula(){
return cedula;
}
//establecer la cedula del cliente 
public void setCedula(String cedula){
this.cedula = cedula;
}
//obtener nombre del cliente
public String getNombre(){
return nombre;
}
//establcer nombre de cliente 
public void setNombre( String nombre){
this.nombre=nombre;
}
//texto del cliente
    @Override
 public String toString() {
        return "Cliente{cedula=" + cedula + ", nombre=" + nombre + '}';
    }

}
    

