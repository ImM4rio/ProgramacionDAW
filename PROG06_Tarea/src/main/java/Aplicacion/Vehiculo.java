package Aplicacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mario
 */
public class Vehiculo {
    
    //Declaramos los atributos de clase y los encapsulamos.
    private String marca, matricula, fecha, descripcion, propietario, DNI;
    private long kms;
    private float precio;

    
    /**Metodo constructor para todas las entradas
    * 
    * @param marca
    * @param matricula
    * @param kms
    * @param fecha
    * @param descripcion
    * @param precio
    * @param propietario
    * @param DNI
     * @throws java.text.ParseException
    */
    
    public Vehiculo (String marca, String matricula, long kms, String fecha, String descripcion, float precio, String propietario, String DNI)
        throws IllegalArgumentException, ParseException { //Excepciones.
        
        if(!comprobarFecha(fecha)){
            //Si la comprobación de la fecha mediante el método devuelve false.
            throw new IllegalArgumentException("La fecha tiene que ser anterior a la actual.");
        }
            this.fecha = fecha;
        
       
        if(!comprobarMatricula(matricula)) {
            //Si la comprobación de la fecha mediante el método devuelve false.
            throw new IllegalArgumentException("Introduce una matricula correcta con el formato dd-MM-yyyy.");
        }
            this.matricula = matricula;
        
        
        if(kms < 0){
            //Si el numero de kms es menor que 0.
            throw new IllegalArgumentException("El numero de kms no puede tener valores negativos.");
        }
        
            this.kms = kms;
 
        
        if(!comprobarDNI(DNI)){
            //Si el DNI no se corresponde a la estructura 00000000A.
            throw new IllegalArgumentException ("El DNI introducido no se corresponde con un DNI valido.");
        }
        this.DNI = DNI;
        
        
        if(!comprobarNombre(propietario)) {
            //Si el nombre tiene caracteres numericos, no se compone de tres elementos o es mayor a 40 caracteres.
            throw new IllegalArgumentException("El nombre introducido no es valido.");
        }
            this.propietario = propietario;
        
       
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
    } 

    
    /**Metodo para comprobar si la fecha de matriculacion es mayor a la actual.
     * 
     * @param fecha
     * @return Si la fecha nueva es superior a la actual.
     * @throws ParseException 
     */
    public static boolean comprobarFecha(String fecha) throws ParseException {
       
       Date fechaActual = new Date(System.currentTimeMillis()); //Instanciamos un objeto que obtiene la fecha actual.
       SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");//Establecemos el formato que dara entrada.
       Date fechaNueva = date.parse(fecha); //Pasa al formato la fecha introducida.
        
        //Comprobamos si es posterior a la actual y pedimos que nos devuelva un tipo boolean en funcion a ello.
        
        return fechaNueva.before(fechaActual);       
       
    }      
    
    /**Metodo para comprobar la matricula y de esta forma poder trabajar individualmente con la comprobacion de matricula.
     * 
     * @param matricula
     * @return devuelve un booleano que nos dice si la matricula es valida.
     */
    public static boolean comprobarMatricula(String matricula) { 
        //Para el String introducido se comprobara si los primeros 4 digitos {4} se corresponden con valores entre 0-9 y los siguientes tres con valores entre A-Z.
        return matricula.toUpperCase().matches("^[0-9]{4}[A-Z]{3}$");
    }
    
    /**Metodo para comprobar el DNI
     * 
     * @param DNI
     * @return devuelve tipo de dato booleanon que nos dice si el DNI es valido.
     */
    public static boolean comprobarDNI(String DNI) {   
        return DNI.toUpperCase().matches("^[0-9]{8}[A-Z]{1}$");
    }
    
    public static boolean comprobarNombre(String propietario) {
        
        String nombreCompuesto = propietario;
        String[] separarNombre = nombreCompuesto.split(" ");
        
        //Mediante expresion regular verifico que solo contenga espacios o caracteres alfabeticos.
        if(!propietario.matches("[a-zA-Z ]+")) {
            return false;
                 
        //Sin expresiones regulares verifico que se compone de al menos tres palabras y que la longitud no es >40.
        }else if(separarNombre.length != 3 || propietario.length() > 40) {
            return false;
        } 
        return true;
    }


    @Override
    public String toString() {
        return "Esta matricula: " + matricula + " pertenece a un " + marca + " con " + kms + "km, matriculado el " + fecha + " por " + propietario + " con DNI " + DNI + " cuyo estado es " + descripcion + " y esta a la venta por " + precio + "€.\n\n";
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula.toUpperCase();
    }

    public long getKms() {
        return kms;
    }

    public void setKms(long kms) {
        this.kms = kms;
        
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
        
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
    
}
