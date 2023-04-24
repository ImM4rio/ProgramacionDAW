package PROG07_Tarea;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Principal {
    
    //Instanciamos un objeto de Banco y de persona para la clase principal
    static Banco Abarca = new Banco();    
    static Persona titular;
    
    static Scanner teclado = new Scanner(System.in);
    
    //Declaramos las variables que vamos a urilizar.
    static int menu, tipo, tipoCC;
    static String nombre, apellido, DNI, entidades, IBAN;
    static double saldo, interes, comisionMant, maxDesc, comision;
    static String[] arrayEntidades = new String[10];
    
    public static void main(String[] args) {
        

        try{
        do{  //Estructura de repeticion para el menu general.
        System.out.println("\n------------------Menu-----------------\n"
                + "Seleccione la opcion que desea a continuacion y pulse la tecla ENTER: \n\n"
                + "1. Abrir una nueva cuenta.\n"
                + "2. Ver un listado de las cuentas disponibles.\n"
                + "3. Obtener los datos de una cuenta concreta.\n"
                + "4. Realizar un ingreso.\n"
                + "5. Retirar efectivo de una cuenta.\n"
                + "6. Consultar el saldo actual.\n"
                + "7. Salir de la aplicacion.");
        
        menu = teclado.nextInt();
  
        switch (menu) {
            
            case 1:
                try{
                do{  //Estructura de repeticion para el menu de abrir nueva cuenta.
                System.out.println("Que clase de cuenta quiere abrir? \n"
                        + "1. Cuenta de ahorro.\n"
                        + "2. Cuenta corriente.\n"
                        + "0. Para volver atras.");
                
                tipo = teclado.nextInt();
                
                switch (tipo) {
                    
                    case 1:
                    try{
                    try{
                        
                        //Creacion cuenta de ahorro comun.
                        System.out.println("Introduce los datos a medida que se piden por la pantalla.");
                        System.out.println("Introduce el IBAN.");
                        teclado.nextLine();
                        IBAN = teclado.nextLine().toUpperCase();
                        
                        //Comprobamos con el metodo buscarCuenta de la clase Banco si esa cuenta ya existe.
                        if(Abarca.buscarCuenta(IBAN)) {
                            System.out.println("Esta cuenta ya existe en la base de datos.");
                                    break;
                        }
                        
                     
                        System.out.println("Introduce el nombre del titular.");
                        nombre = teclado.nextLine();
                        
                        System.out.println("Introduce el o los apellidos del titular.");
                        apellido = teclado.nextLine();
                        
                        System.out.println("Introduce el DNI del titular");
                        DNI = teclado.nextLine().toUpperCase();
                        
                        //Creamos el objeto titular para completar la inicializacion de la instancia de CuentaBancaria.
                        titular = new Persona(nombre, apellido, DNI);
                        
                        System.out.println("Introduce el saldo de inicio.");
                        saldo = teclado.nextDouble();
                        
                        System.out.println("Por ultimo añade el tipo de interes.");
                        interes = teclado.nextDouble();
                        
                        //Creamos el la cuenta nueva con el constructor.
                        CuentaAhorro nuevaCuenta = new CuentaAhorro(titular, IBAN, saldo, interes);
                        //Añadimos la cuenta al array.
                        Abarca.abrirCuenta(nuevaCuenta);
                        
                        
                    }catch (IllegalArgumentException e) {
                        System.err.println(e);
                    }    
                    }catch (RuntimeException r) {
                        System.err.println("Error en la creacion de cuenta de ahorro.");
                    }
                    break;
                    
                    case 2:
                    try{
                        
                        
                        do{ //Estructura de repeticion para las opciones de cuenta corriente.
                             //Creacion cuenta corriente.
                        System.out.println("Seleccione el tipo de cuenta corriente:\n"
                                + "1. Cuenta corriente personal.\n"
                                + "2. Cuenta corriente de empresa.\n"
                                + "0. Para salir");
                        tipoCC = teclado.nextInt();
                        
                        
                        switch(tipoCC) {
                            
                            case 1: //CuentaCorrientePersonal.
                            try{
                                System.out.println("Introduce los datos a medida que se piden por la pantalla.");
                                System.out.println("Introduce el IBAN.");
                                teclado.nextLine();
                                IBAN = teclado.nextLine().toUpperCase();
                        
                                if(Abarca.buscarCuenta(IBAN)) {
                                    System.out.println("Esta cuenta ya existe en la base de datos.");
                                            break;
                                }

                                System.out.println("Introduce el nombre del titular.");
                                nombre = teclado.nextLine();

                                System.out.println("Introduce el o los apellidos del titular.");
                                apellido = teclado.nextLine();

                                System.out.println("Introduce el DNI del titular");
                                DNI = teclado.nextLine().toUpperCase();

                                //Creamos el objeto titular para completar la inicializacion de la instancia de CuentaBancaria.
                                titular = new Persona(nombre, apellido, DNI);

                                System.out.println("Introduce el saldo de inicio, en caso de tener valores decimales separelos por una coma.");
                                saldo = teclado.nextDouble();
                                
                                System.out.println("Introduce la comision de mantenimiento.");
                                comisionMant = teclado.nextDouble();
                                
                                System.out.println("Introduce la serie de entidades permitidas separadas por una coma.");
                                teclado.nextLine();
                                entidades = teclado.nextLine().toUpperCase();
                                
                                arrayEntidades = entidades.split(", ");
                                
                                
                                CuentaCorrientePersonal nuevaCCP = new CuentaCorrientePersonal(titular, IBAN, saldo, arrayEntidades, comisionMant);
                                
                                Abarca.abrirCuenta(nuevaCCP);
                                break;
                                
                            }catch (RuntimeException r) {
                                System.err.println("Error en la creacion de la cuenta corriente personal.");
                            }  
                            
                            case 2: //CuentaCorrienteEmpresa.
                        
                            try{
                                
                                System.out.println("Introduce los datos a medida que se piden por la pantalla.");
                                System.out.println("Introduce el IBAN.");
                                teclado.nextLine();
                                IBAN = teclado.nextLine().toUpperCase();
                        
                                if(Abarca.buscarCuenta(IBAN)) {
                                    System.out.println("Esta cuenta ya existe en la base de datos.");
                                    break;        
                                }
                                

                                System.out.println("Introduce el nombre del titular.");
                                nombre = teclado.nextLine();

                                System.out.println("Introduce el o los apellidos del titular.");
                                apellido = teclado.nextLine();

                                System.out.println("Introduce el DNI del titular");
                                DNI = teclado.nextLine().toUpperCase();

                                //Creamos el objeto titular para completar la inicializacion de la instancia de CuentaBancaria.
                                titular = new Persona(nombre, apellido, DNI);

                                System.out.println("Introduce el saldo de inicio.");
                                saldo = teclado.nextDouble();
                                
                                System.out.println("Introduce la serie de entidades permitidas separadas por una coma.");
                                teclado.nextLine();
                                entidades = teclado.nextLine().toUpperCase();
                                
                                arrayEntidades = entidades.split(", ");
                                
                                System.out.println("Introduce el maximo descubierto permitido.");
                                maxDesc = teclado.nextDouble();
                                
                                System.out.println("Introduce el tipo de interes");
                                interes = teclado.nextDouble();
                                
                                System.out.println("Introduce la comision");
                                comision = teclado.nextDouble();
                                
                                CuentaCorrienteEmpresa nuevaCCE = new CuentaCorrienteEmpresa(titular, IBAN, saldo, arrayEntidades, maxDesc, interes, comision);
                                Abarca.abrirCuenta(nuevaCCE);
                                break;
                            
                            }catch (RuntimeException r) {
                                System.err.println("Error en la creacion de cuenta corriente de empresa.");
                            }
                            
                            
                            default:
                                if(tipoCC != 0)
                                    System.out.println("Seleccione una opción válida o pulse 0 para volver atras.");
                                break;
                            } //cierre switch tipo cuenta corriente.
                        
                        }while(tipoCC != 0); //Cierre do{ tipo cuenta corriente.
                        
                    break;
                    }catch (RuntimeException r) {
                        System.err.println("Error en la opcion 2.");
                    }
                    
                    default:
                        if(tipo != 0)
                            System.out.println("Teclee una opcion valida.");
                        
                    break;
                    } //cierre switch para tipo de cuenta.
                
                       
                }while(tipo != 0); //cierre do{ tipo de cuenta.
                
            
            
            }catch (IllegalArgumentException e) {
                    System.out.println(e);
                    }
            break;
            
            case 2:
            try{
                
                //Ver el listado de cuentas disponibles.
                if(Abarca.listarCuentas().length != 0) {
                    System.out.println(Arrays.toString(Abarca.listarCuentas()));
                         
                }else if(Abarca.listarCuentas().length == 0){
                    System.out.println("Todavia no existe ninguna cuenta.");
                }
                
                
            
            }catch (RuntimeException r) {
                        System.err.println("Error en la opcion 2.");
                    }
            break;
                
            case 3:
            try{    
                //Obtener datos de una cuenta concreta.
                System.out.println("Introduce el IBAN de la cuenta para saber su informacion.");
                
                teclado.nextLine();
                IBAN = teclado.nextLine();
                
                if(!IBAN.toUpperCase().matches("^[ES]{2}[0-9]{22}$")){
                    System.out.println("El IBAN introducido no es valido.");
                }
                        
                else if(!Abarca.buscarCuenta(IBAN.toUpperCase())) {
                    System.out.println("Esta cuenta todavía no existe.");
                }else{
                    
                System.out.println(Abarca.informacionCuenta(IBAN));
                
                }
                
                break;
            
            }catch (RuntimeException r) {
                System.out.println("Error en la opcion 3.");
            }
            
            case 4:
            try{
            try{
                
                //Retirar efectivo de una cuenta.
                System.out.println("Introduce el IBAN de la cuenta para realizar el ingreso.");
                teclado.nextLine();
                IBAN = teclado.nextLine().toUpperCase();
                if(!Abarca.buscarCuenta(IBAN)) {
                    System.out.println("Ese IBAN no corresponde a ninguna cuenta de esta base de datos.");
                    break;
                }
           
                
                System.out.println("Introduce a continuacion el ingreso.");
                    
                saldo = teclado.nextDouble();
                    Abarca.ingresoCuenta(IBAN, saldo);
                
                break;
                
            }catch (IllegalArgumentException t) {
                System.out.println(t);
            }
            }catch (RuntimeException r){
                System.out.println("Error en la opcion 4.");
            }
            
            case 5:
            try{    
            try{    
                // Realizar un ingreso.
                System.out.println("Introduce el IBAN de la cuenta para la retirada");
                teclado.nextLine();
                IBAN = teclado.nextLine().toUpperCase();
                
                if(!Abarca.buscarCuenta(IBAN)) {
                    System.out.println("Ese IBAN no corresponde a ninguna cuenta de esta base de datos.");
                }
                
                System.out.println("Introduce a continuacion el saldo a retirar.");
                saldo = teclado.nextDouble();
                
                    Abarca.retiradaCuenta(IBAN, saldo);
                
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e);
            }
            }catch (RuntimeException r) {
                System.err.println("Error con la opcion 5.");
            }   
            
            case 6:
            try{
                    
                //Consultar el saldo actual de una cuenta.
                System.out.println("Introduzca el IBAN de la cuenta para consultar su saldo actual.");
                teclado.nextLine();
                IBAN = teclado.nextLine().toUpperCase();
                
                if(!Abarca.buscarCuenta(IBAN)) {
                    System.out.println("Ese IBAN no corresponde a ninguna cuenta de esta base de datos.");
                }
                
                System.out.println(Abarca.traerCuenta(IBAN).getSaldo());
                
                break;
            }catch (RuntimeException i) {
                System.err.println("Error con la opcion 6.");
            }    
            default:
                if(menu != 7)
                    System.out.println("Teclee una opcion valida.");
                
                break;
            }
        
        }while(menu != 7); //Cierre menu.
                
        }catch (RuntimeException r) {
           System.err.println("Error en la aplicacion, contacte con el servicio tecnico.");
        }   
    }        
}
