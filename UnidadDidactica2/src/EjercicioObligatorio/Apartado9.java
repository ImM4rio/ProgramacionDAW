package EjercicioObligatorio;

//9.- Diseña un programa Java que solicite un número de 5 dígitos del teclado, separe el número en sus dígitos individuales
//y los muestre por pantalla.

/**
 *
 * @author ponTuNombreAqui
 */

import java.util.Scanner;

public class Apartado9 {
    public static void apartado9() {
        
            System.out.println("\nApartado9");
        
        //Creamos un nuevo objeto de la clase Scanner, y creamos una nueva variable donde almacenaremos el numero.
        int numero;
        Scanner teclado = new Scanner(System.in); 
        
        //A continuacion pediremos al usuario que introduzca el numero de 5 digitos por teclado.
        System.out.println("Introduce un numero de 5 digitos y a continuacion pulsa Enter.");
        
        numero = teclado.nextInt();
        
        //Ahora realizaremos una comprobacion para ver si el numero introducido tiene 5 digitos.
        if(String.valueOf(numero).length() != 4) {
            /**
             * En la condicion anterior evaluamos si el numero es diferente a 5 digitos.
             * El metodo valueOf(int i) de la clase String nos devuelve el valor numerico en un tipo de dato String, sobre el cual
             * llamamos al metodo lenght(), el cual nos devuelve un int con el numero de caracteres que contiene el String, de esta manera
             * podemos comprobar el total de digitos, sin olvidarnos de que este metodo empieza a contar desde 0.
             * En un numero 12345, el 1 ocupa la posicion 0, el 2 la posicion 1... y asi sucesivamente, por lo que el resultado de lenght()
             * para un numero de 5 digitos sera igual a 4.
             * 
             * Esto, se podria realizar de la misma manera con el metodo toString(int i) dentro de la clase Integer, es decir.
             * Integer.toString(numero), el cual nos devolveria el valor tipo String del numero sobre el cual podriamos aplicar
             * nuevamente el metodo length()
             * 
             * El signo de exclamacion anterior al signo igual quiere decir 'diferente', de esta manera el if seria:
             * Si(La longitud de caracteres del numero es diferente a 4) { ...codigo...]
             */
            
            
            for(int i = 0; i < 5; i++){
                /**
                 * Con esta estructura de control decimos lo siguiente:
                 * por(cada vuelta del bucle desde que el numero i es igual a 0 ; mientras que i sea menor que 5 (cuando llegue a 4, sal del bucle); suma 1 a i) 
                 * { ...haz lo siguiente... 
                 * imprime en una linea, sin saltos de linea, el valor del caracter del numero que este en la posicion (i) (recordando que la posicion empieza en 0)
                 * y a continuacion anhade un espacio.} 
                 * 
                 * Asi para la primera vuelta del bucle donde i = 0 sera:
                 * for(i = 0; se cumple que 0 es menor que 5; haz lo siguiente y luego suma 1 a i)
                 * 
                 * En la siguiente vuelta i = 1:
                 * for(i = 1, se cumple que 1 es menor que 5; haz lo siguiente y luego suma 1 a i)
                 * 
                 * .
                 * .
                 * .
                 * 
                 * En la ultima vuelta i = 4:
                 * for(i = 4, se cumple que 4 es menor que 5; haz lo siguiente y luego suma 1 a i)
                 * En el siguiente bucle, donde i sera igual a 5 ya no se cumple la condicion de que i es menor que 5 (5 no es menor que 5)
                 * asi que continuara el flujo del programa.
                 */
                System.out.print(String.valueOf(numero).charAt(i) + " ");
            }
            
        }else{
            /**
             * Si no se cumple la condicion anterior entraremos en el codigo comprendido entre las llaves del else.
             */
            System.out.println("El numero debe tener 5 digitos.");
        }
        
    }
}
