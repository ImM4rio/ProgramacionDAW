package Aplicacion;

import java.text.ParseException;


/**
 *
 * @author Mario
 */
public class Concesionario {
    
    //Declaramos los atributos de concesionario de forma privada.
    private int posicion= 0;
    private Vehiculo[] stock;
    
    //Constructor vacío de la clase con la posicion y el array de vehículos con un límite de 50 elementos.
    public Concesionario () {
        this.posicion = 0;
        this.stock = new Vehiculo[50];
    }
    
    /**Metodo que recibe como parametro una matricula y devuelve un objeto de la clase vehiculo si coincide con alguna matricula ya introducida.
     * 
     * @param matricula
     * @return objeto de Vehiculo
     */
    public Vehiculo buscarVehiculo(String matricula){
        for(int i = 0; i < posicion; i++){
            if(matricula.equals(stock[i].getMatricula())){
            return stock[i];
            }
        }
        return null;
    }
    
    /**Metodo que agrega vehiculo al objeto instanciado de concesionario.
     * 
     * @param marca
     * @param matricula
     * @param kms
     * @param fecha
     * @param descripcion
     * @param precio
     * @param propietario
     * @param DNI
     * @return int.
     * @throws java.text.ParseException
     */
    public int agregarVehiculo(String marca, String matricula, long kms, String fecha, String descripcion, float precio, String propietario, String DNI) throws IllegalArgumentException, ParseException {
        //Comprobamos si el coche exite.
        Vehiculo coche = buscarVehiculo(matricula);
        
        if(coche != null) {
           return -2;
            
        }else if(posicion < 50) {
            
            //Empleamos este método constructor para dar los throw del método constructor que los arroja en la clase vehiculo.
            Vehiculo nuevoCoche = new Vehiculo(marca, matricula, kms, fecha, descripcion, precio, propietario, DNI);
            
            //Empleamos los setters para moldear la nueva instancia de clase de Vehiculo.
            nuevoCoche.setMarca(marca);
            nuevoCoche.setMatricula(matricula);
            nuevoCoche.setFecha(fecha);
            nuevoCoche.setKms(kms);
            nuevoCoche.setDescripcion(descripcion);
            nuevoCoche.setPrecio(precio);
            nuevoCoche.setPropietario(propietario);
            nuevoCoche.setDNI(DNI);
            
            //Asignamos el nuevoCoche a una posicion (inicialmente 0) del array de objetos stock[].
            stock[posicion] = nuevoCoche;
            
            //Cada vez que se añada un nuevoCoche se sumará uno a la posición.
            posicion ++;
        }else{
            return -1;
        }
        
        return 0;
    }
    
    /**Metodo para listar todos los vehiculos disponibles.
     */
    public void listarVehiculos() {
        System.out.println("En este momento hay " + posicion + " vehículo/s introducidos en la app.");
        for(int i = 0; i < posicion; i++){
            if(stock[i] != null)
                System.out.println(stock[i].toString());
            
        }
    }
    
    /**Metodo para actualizar los kms del vehiculo, dando como parametro la matricula y los km por los que se quiere cambiar.
     * 
     * @param matricula
     * @param kms
     * @return  booleano en funcion de si cambiaron o no.
     */
    public boolean actualizaKMS(String matricula, long kms) {   
        for(int k = 0;k < posicion; k++){
            if(matricula.equals(stock[k].getMatricula())) {
                stock[k].setKms(kms);
                return true;
            }
        }
        return false;
    }
    
    /**Método para eliminar un objeto del array.
     *En este método tratamos el index del array con posicion - 1 para que no genere errores con elementos null, de la misma forma adelantamos todos los elementos una
     *posición y al último elemento, como ya lo hemos adelantado, para que no aparezca por duplicado lo borramos dándole un valor null.
     * @param matricula
     */
    public void eliminarVehiculo(String matricula) {
       
       for(int e = 0; e < posicion - 1; e++) {
           if(stock[e].getMatricula().equals(matricula)) {
               stock[e] = null;
               for(int p = e;p <= (posicion - 1); p++) {
                  if(p == (posicion - 1)){
                       stock[p] = null;
                  }
                    stock[p] = stock [p + 1];
                  
               }
                   
           }
       }
    }
            
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Vehiculo[] getStock() {
        return stock;
    }

    public void setStock(Vehiculo[] stock) {
        this.stock = stock;
    }

    
        
}
    

