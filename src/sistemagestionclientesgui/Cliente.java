/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagestionclientesgui;

/**
 *
 * @author USUARIO
 */
public class Cliente {
private String cedula;
    private String nombre;
    
    /**
     * Constructor para crear un nuevo cliente
     * @param cedula Número de cédula del cliente
     * @param nombre Nombre completo del cliente
     */
    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }
    
    /**
     * Obtiene la cédula del cliente
     * @return Cédula del cliente
     */
    public String getCedula() {
        return cedula;
    }
    
    /**
     * Establece la cédula del cliente
     * @param cedula Nueva cédula para asignar
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    /**
     * Obtiene el nombre del cliente
     * @return Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre del cliente
     * @param nombre Nuevo nombre para asignar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Representación en texto del cliente
     * @return String con la información del cliente
     */
    @Override
    public String toString() {
        return "Cliente{cedula=" + cedula + ", nombre=" + nombre + '}';
    }
}