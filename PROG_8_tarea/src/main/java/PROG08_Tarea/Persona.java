package PROG08_Tarea;

import java.io.*;
/**
 *
 * @author Mario
 */
public final class Persona implements Imprimible, Serializable{
    
    private String nombre, apellido, DNI;
    
    public Persona (String nombre, String apellido, String DNI) throws IllegalArgumentException {
        
        //Condicional para que si el metodo comprobarNombre devuelve un false, salte el throw.
        if(!comprobarNombre(nombre)) {
            throw new IllegalArgumentException ("El nombre introducido no es válido, por favor, inténtelo de nuevo.");
        }
        this.nombre = nombre;
        
        //Condicional para que si el metodo comprobarApellido devuelve un false, salte el throw.
        if(!comprobarApellido(apellido)) {
            throw new IllegalArgumentException ("El apellido introducido no es válido, por favor, inténtelo de nuevo.");
        }
        this.apellido = apellido;
        
        //Condicional para que si el metodo comprobarApellido devuelve un false, salte el throw.
        if(!comprobarDNI(DNI)) {
            throw new IllegalArgumentException ("El DNI introducido no tiene un formato válido, por favor, inténtelo de nuevo.");
        }
        this.DNI = DNI;
    }
    
    public boolean comprobarNombre (String nombre) {
        return (nombre.length() < 20 && nombre.toUpperCase().matches("[A-Z ]*"));

    }
    
    public boolean comprobarApellido (String apellido) {
        return (apellido.length() < 30 && apellido.toUpperCase().matches("[A-Z ]*"));
            
    }
    
    public boolean comprobarDNI (String DNI) {
        return DNI.toUpperCase().matches("^[0-9]{8}[A-Z]{1}$");
    }

    
    
    //Metodos getters y setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    
    @Override
    public String devolverInfoString() {
        return "Titular: " + this.nombre + " " + this.apellido + " con DNI " + this.DNI;
    }
}
