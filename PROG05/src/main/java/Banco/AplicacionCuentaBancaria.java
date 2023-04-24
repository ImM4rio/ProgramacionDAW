package Banco;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class AplicacionCuentaBancaria {
    //Instanciamos los objetos para NO encapsularlos dentro del método como me pasó en el examen...
      
    static Scanner teclado = new Scanner(System.in);
    static CuentaBancaria cuenta;
    
    public static void main(String[] args) {
        
    //Declaramos las variables que vamos a utilizar en las sentencias del método main.
    String CC, titular1;   
    boolean comprobarCCC, seguir;
    int opcion;
    
        do{
            try{
                //Nombre titular con el throw en la clase cuenta bancaria.
                seguir = true;
                System.out.println("Introduce el nombre del titular");
                    titular1 = teclado.nextLine();

                    do{
                        //Comprobación del número de cuenta.
                        comprobarCCC = true;
                        System.out.println("Introduce el número de cuenta cliente.");
                        CC = teclado.nextLine();
                        CC = CC.trim();
                        
                        for(int i=0;i<CC.length();i++){
                            if(CC.charAt(i) - 48 < 0 || CC.charAt(i) - 48 > 9) //Se restan 48 para convertir carácter a entero.
                                comprobarCCC = false;
                            
                        }
                                if(!comprobarCCC)
                                    System.err.println("Introduce dígitos numéricos.");
                        
                    }while (!comprobarCCC || CC.length() != 20);
                    
                    //Si las sentencias anteriores se cumplen se crea el nuevo objeto de la clase.
                    cuenta = new CuentaBancaria(titular1, CC);
            
            
            }catch(IllegalArgumentException e){
                System.err.println("Error, asegúrese de la corrección de los datos.");
                seguir = false;
            }
        }while(!seguir);
        
        opcion = 0;
        
        do{
            try{
                System.out.println("-----Menú Principal-----");
                System.out.println("------------------------");
                System.out.println("1) Ver el número de cuenta completo");
                System.out.println("2) Ver el titular de la cuenta");
                System.out.println("3) Ver el código de la entidad");
                System.out.println("4) Ver el código de la oficina");
                System.out.println("5) Ver el número de la cuenta");
                System.out.println("6) Ver los dígitos de control de la cuenta");
                System.out.println("7) Realizar un ingreso");
                System.out.println("8) Retirar efectivo");
                System.out.println("9) Consultar saldo");
                System.out.println("0) Salir de la aplicación");
                
                opcion = teclado.nextInt();
                
            switch (opcion) {
                case 0:
                    break;
                
                case 1:
                    System.out.printf("número de cuenta: %s-%s-%s-%s\n", cuenta.getEntidad(), cuenta.getOficina(), CuentaBancaria.obtenerDC(cuenta.getEntidad(), cuenta.getOficina(), cuenta.getNumCuenta()), cuenta.getNumCuenta());
                    break;
                
                case 2:
                    System.out.printf("Titular: %s\n", cuenta.getTitular());
                    break;
                    
                case 3:
                    System.out.printf("Cósigo de la entidad: %s", cuenta.getEntidad());
                    break;
                    
                case 4:
                    System.out.printf("Código de la oficina: %s\n", cuenta.getOficina());
                    break;
                
                case 5:
                    System.out.printf("Cuenta nº: %s\n", cuenta.getNumCuenta());
                    break;
                
                case 6:
                    System.out.printf("Dígitos de control: %s\n", CuentaBancaria.obtenerDC(cuenta.getEntidad(), cuenta.getOficina(), cuenta.getNumCuenta()));
                    break;
                    
                case 7:
                    ingresar();
                    break;
               
                case 8:
                    retirar();
                    break;
                
                case 9:
                    System.out.printf("Saldo = %s euros", cuenta.getSaldo());
                    break;
                    
                default:
                    System.out.println("Introduce un valor entre 0 y 9.");           
            }
        }catch (NumberFormatException f){
            System.err.println("Sólo valores entre 0 y 9.");
        }catch (IllegalArgumentException iae){
            System.err.println(iae);
            
        }
    }while(opcion != 0);   
    }
    
    //Método utilizado para ingresar dinero con las restricciones definidas.
    public static void ingresar() {
        double dinero;
        try{
            System.out.println("¿Cuánto quiere ingresar?");
            dinero = Double.parseDouble(teclado.nextLine());
            
            if(dinero < 0) throw new IllegalArgumentException("Sólo se admiten valores positivos");
            cuenta.ingresar(dinero);
            
        }catch(NumberFormatException nfe){
                System.err.println("Sólo se admiten valores numéricos.");
        }catch(IllegalArgumentException iae){
            System.err.println(iae);
        }
    }
    
    //Método similar para retirar dinero.
    public static void retirar() {
        double dinero;
        try{
            System.out.println("¿Cuánto quiere retirar?");
            dinero = Double.parseDouble(teclado.nextLine());
            
            if(dinero < 0) throw new IllegalArgumentException("Solo se admiten valores numéricos.");
        }catch(NumberFormatException nfe){
            System.err.println("Sólo valores numéricos.");
        }catch(IllegalArgumentException iae) {
            System.err.println(iae);
            
        }
    }
    
}

