package Aplicacion;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Iterator;


/**
 *
 * @author Mario
 */
public class Concesionario {
    
    //Declaramos los atributos de concesionario de forma privada.
    private int posicion= 0;
    private ArrayList <Vehiculo> stock;
    //private Vehiculo[] stock;
    
    //Constructor vacío de la clase con la posicion y el array de vehículos con un límite de 50 elementos.
    public Concesionario () {
        this.posicion = 0;
        this.stock = new ArrayList();
    }
    
    /**Metodo que recibe como parametro una matricula y devuelve un objeto de la clase vehiculo si coincide con alguna matricula ya introducida.
     * 
     * @param matricula
     * @return objeto de Vehiculo
     */
    public Vehiculo buscarVehiculo(String matricula){
        Iterator<Vehiculo> i = stock.iterator();
            while(i.hasNext()) {
                Vehiculo coche = i.next();
                    if(matricula.equals(coche.getMatricula())){
                        return coche;
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
           
        }else if(coche == null){
            
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
            stock.add(nuevoCoche);
            
            //Cada vez que se añada un nuevoCoche se sumará uno a la posición.
            posicion ++;
            Collections.sort(stock);
            
        }else{
            return -1;
        }
        
        return 0;
    }
    
    /**Metodo para listar todos los vehiculos disponibles.
     */
    public void listarVehiculos() {
        System.out.println("En este momento hay " + posicion + " vehículo/s introducidos en la app.");
        Iterator <Vehiculo> i = stock.iterator();
            while(i.hasNext()){
                Vehiculo coche = i.next();
                    System.out.println(coche.toString());          
        }
    }
    
    /**Metodo para actualizar los kms del vehiculo, dando como parametro la matricula y los km por los que se quiere cambiar.
     * 
     * @param matricula
     * @param kms
     * @return  booleano en funcion de si cambiaron o no.
     */
    public boolean actualizaKMS(String matricula, long kms) {  
        Iterator <Vehiculo> i = stock.iterator();
            while(i.hasNext()){
                Vehiculo coche = i.next();
                    if(coche.getMatricula().equals(matricula))
                        coche.setKms(kms);
                        return true;
            }
        return false;
    }
    
    /**Método para eliminar un objeto del array.
     *En este método tratamos el index del array con posicion - 1 para que no genere errores con elementos null, de la misma forma adelantamos todos los elementos una
     *posición y al último elemento, como ya lo hemos adelantado, para que no aparezca por duplicado lo borramos dándole un valor null.
     * @param matricula
     */
    public void eliminarVehiculo(String matricula) {
       stock.remove(this.buscarVehiculo(matricula));
       posicion --;
       
    }
            
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public ArrayList<Vehiculo> getStock() {
        return stock;
    }

    public void setStock(ArrayList<Vehiculo> stock) {
        this.stock = stock;
    }



    
        
}
    

