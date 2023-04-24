package Mario_Vazquez;

import java.util.Scanner;

public class Opcion1 {    
    public static void metodoOpcion1() {//Creamos el método estático para la clase y NO tener que instanciarlo para usarlo en otra clase.
        System.out.println("Introduce un número y yo te diré si es par o no");
        Scanner teclado = new Scanner(System.in);
            int numero;//Declaramos una variable vacía como contenedor del siguiente numero que introduzcamos por teclado.
            numero = teclado.nextInt();//El siguiente int se guardará en la variable numero.

            if (numero % 2 == 0) {//Estructura de selección --> si la división entre el número y 2 da como resto 0, se cumple la condición (todo número divisible entre 2 es par...
                System.out.println("Sí! el número " + numero + " es un número par!");//...Y se imprime por pantalla.
                }
                else    {//Si no se cumple la condición salta a esta línea e imprime la sentencia siguiente.
                    System.out.println("Incorrecto!, el número " + numero + " no es un número par...");
                    }  
            
    }
   
}
