package EjercicioObligatorio;

//5.- Disenha un programa Java que pida dos numeros por teclado, determine si el primero es multiplo del segundo y muestre el resultado.

import java.util.Scanner;


/**
 *
 * @author ponTuNombreAqui
 */
public class Apartado5 {
   /**En este caso crearemos un metodo estatico al que llamaremos desde el metodo main del proyecto para simplificar la entrega,
    * podremos comprobar que en el metodo main vamos llamando a los metodos de los demas apartados.
    * Si se quiere hacer en un proyecto diferente escribiremos     public static void main(String[] args) { ...codigo... } en vez de
    * public class Apartado5{ ...codigo... } y tendremos que hacer un proyecyo nuevo para cada uno de los apartados.
    *
    * Este metodo estatico recibira dos parametros que seran dos numeros diferentes que pediremos por teclado, a traves de la clase Scanner
    * devolviendonos un booleano en funcion de si es multiplo o no.
    * 
    * @param num1
    * @param num2
    * @return 
    */

    
   public static void multiplo(){       
       
        Scanner teclado = new Scanner(System.in);
        int num1, num2;
        
        System.out.println("\nApartado5");
        
        System.out.println("\nTeclea un numero por teclado y pulsa Enter");
        //Almacenaremos en la variable num1 de tipo int el siguiente int que introduzcamos por teclado.
        num1 = teclado.nextInt();
        
        System.out.println("Ahora introduce el segundo numero y pulsa Enter de nuevo para saber si el primero es multiplo del segundo.");
        num2 = teclado.nextInt();
        
        /**El siguiente if, comprueba si la condicion entre parentesis es verdadera (true), es decir, si el valor devuelto por el metodo (el return)
         * es true, se ejecutara el codigo que continua.
         * Si la condicion no se cumple, es decir, es false (el metodo devuelve false), no se ejecutara el codigo y saltara al codigo comprendido dentro
         * del else.
         */
        if(num1 % num2 == 0){
            System.out.println("Correcto! El primer numero es multiplo del segundo!");
        }else{
            System.out.println("Lo siento, pero el primer numero no es multiplo del segundo.");
        }
   }
}
