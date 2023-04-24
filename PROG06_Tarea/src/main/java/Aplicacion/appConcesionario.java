package Aplicacion;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class appConcesionario{
    
    /**Variables estáticas para la clase appConcesionario junto con la instancia de objetos.
     * 
     */
    static Concesionario VazOteCars = new Concesionario();
    static Scanner teclado = new Scanner(System.in);
    static String matricula, marca, fecha, descripcion, propietario, DNI;
    static float precio;
    static long kms;
    //Variable para los cases de la estructura switch.
    static int menu;
    
    public static void main(String[] args) {

        try{
        //do while como estructura de control de flujo para el menú.
        do{
            System.out.println("1. Nuevo Vehículo.\n2. Listar Vehículos.\n3. Buscar Vehículo.\n4. Modificar kms Vehículo.\n5. Eliminar un vehículo.\n6. Salir");
            
            //Inicializamos la variable menú declarada anteriormente por el valor que introducimos por el teclado.
            menu = teclado.nextInt();
            
            switch (menu) {
                
                case 1:
                    try{
                    System.out.println("Introduce los datos del vehículo según se van pidiendo.");
                    System.out.println("Cual es la matrícula del coche?");
                    
                    teclado.nextLine();
                    matricula = teclado.nextLine().toUpperCase();
                    
                    //Si la matrícula coincide a algún vehículo que ya esté metido en la applicación se imprimirá el mensaje y se romperá el case.
                    if(VazOteCars.buscarVehiculo(matricula) != null){    
                        System.out.println("Este vehículo ya existe.\n");
                         break;            
                    }else{
                        //Si no existe el vehiculo se continuará el flujo.
                        System.out.println("Introduce la marca del vehículo");
                            marca = teclado.nextLine();
                            
                        System.out.println("Introduce los kms del vehículo.");
                            kms = teclado.nextLong();
                            teclado.nextLine();
                            

                        System.out.println("Introduce la fecha de matriculación con formato dd-MM-yyyy");
                            fecha = teclado.nextLine();

                        System.out.println("Introduce la descripción del vehículo.");
                            descripcion = teclado.nextLine();                 

                        System.out.println("Introduce el precio de venta del vehículo.");
                            precio = teclado.nextFloat();
                            teclado.nextLine();

                        System.out.println("Introduce el nombre del propietario.");
                            propietario = teclado.nextLine();
                            
                        System.out.println("Introduce el DNI del propietario");
                            DNI = teclado.nextLine();


                        VazOteCars.agregarVehiculo(marca, matricula, kms, fecha, descripcion, precio, propietario, DNI);
                    }
                    }catch (IllegalArgumentException e) {
                        System.err.println(e);
                    }catch (ParseException ex) {
                        System.err.println("Error en el formato de la fecha.");
                }
                    break;

                    
                    
                case 2:
                    try{
                        
                    //Llama al método que nos devuelve los objetos del array de la clase concesionario stock[].
                    VazOteCars.listarVehiculos();
                    
                    //Si todavía no se ha creado un vehículo, es decir, la variable posicion es == 0.
                    if(VazOteCars.getPosicion() == 0)
                        System.out.println("Aún no se ha introducido ningún vehículo.\n");
                    }catch (RuntimeException e) {
                        System.err.println("Ha ocurrido un error con la opción 2, por favor, inténtelo de nuevo.");
                    }
                    break;
                    
                
                case 3:
                    try{
                    teclado.nextLine();
                    
                    System.out.println("Introduce la matrícula del vehículo que buscas.");
                    matricula = teclado.nextLine().toUpperCase();
                    
                    //Si la matricula que introducimos nos retorna un valor null dentro del array no existe, en caso contrario se retornará el objeto que coincida con esa matrícula.
                    if(VazOteCars.buscarVehiculo(matricula) == null) {
                        System.out.println("Este vehículo no existe en el concesionario.\n");
                    
                    }else{
                        VazOteCars.buscarVehiculo(matricula);
                    }
                    
                    }catch (RuntimeException e) {
                        System.err.println("Ha ocurrido un error con la opción 3, por favor, inténtelo de nuevo.");
                    }
                    break;
                 
                    
                case 4:
                    try{
                    System.out.println("Introduce la matrícula del vehículo.");
                    teclado.nextLine();
                    matricula = teclado.nextLine().toUpperCase();
                    
                    //Primero comprobamos si la matrícula existe en el Array y si lo hace pide los kms.
                    if(VazOteCars.buscarVehiculo(matricula)!= null) {
                        System.out.println("Ahora introduce el nuevo kilometraje.");
                        kms = teclado.nextLong();
                        
                        //Método que actualiza los kms del objeto vehículo.
                        VazOteCars.actualizaKMS(matricula, kms);
                        
                    }else{
                        System.out.println("Esta matrícula no existe en el concesionario.\n");
                    }
                    }catch (RuntimeException e) {
                        System.out.println("Ha ocurrido un error con la opción 4, por favor, inténtelo de nuevo.");
                    }
                    break;
                
                
                case 5:
                    try{
                    System.out.println("introduce la matrícula del vehículo que quieres borrar.");
                    teclado.nextLine();
                    matricula = teclado.nextLine().toUpperCase();
                    if(VazOteCars.buscarVehiculo(matricula) == null) {
                        System.out.println("Este vehículo no existe en la base de datos de nuestra app.");
                    }else{
                    VazOteCars.eliminarVehiculo(matricula);
                        System.out.println("Se ha eliminado el vehículo con matrícula " + matricula);
                    }
                    }catch (RuntimeException w) {
                        System.err.println("Error en la opción 5, por favor, inténtelo de nuevo.");
                    }
                        
                    break;
                    
                default:
                    //Por defecto añadimos esta opción para contemplar todas las entradas para menú y que no rompa el programa.
                    if(menu != 6)
                        System.out.println("Opción incorrecta, inténtalo de nuevo o pulsa 5 para salir\n");
                    
                    break;
                    
            }
        }while (menu != 6);
        
        //En caso de que la app falle capturamos un error.
        }catch (RuntimeException a) {
                System.err.println("Error en la applicación, contacta con el servicio técnico.");
               }
    } 
}
    

