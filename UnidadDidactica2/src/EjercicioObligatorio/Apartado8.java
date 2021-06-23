package EjercicioObligatorio;

//8.- Diseña un programa Java que calcule la suma, resta, multiplicacion y division de dos numeros introducidos por teclado. 
// Incorpora tambien las funciones que permitan realizar la potencia de un numero y la raiz cuadrada del otro. 

/**
 *
 * @author ponAquiTuNombre
 */

import java.util.Scanner;

public class Apartado8 {
    
    public static void cuentas() {
        
            System.out.println("\nApartado8");
        
        Scanner teclado = new Scanner(System.in);
        int x, y;
        
        System.out.println("Introduce dos numeros por teclado y pulsa Enter.");
        x = teclado.nextInt();
        y= teclado.nextInt();
        
        System.out.println("x + y = " + (x + y));
        System.out.println("x - y = " + (x - y));
        System.out.println("x * y = " + (x * y));
        System.out.println("x / y = " + (x / y));
        System.out.println("x ^ 2 = " + (x * x));
        System.out.printf("\u221A x = %.2f \n", Math.sqrt(y)); //Dentro de la clase Math llamamos al metodo sqrt() que recibe como argumento un numero y realiza la raiz cuadrada.
    }
}
