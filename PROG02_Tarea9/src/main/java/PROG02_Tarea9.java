/**
 *
 * @author Mario
 */

//Indico que deseo que el programa utilice Scanner(clase) de java.util. 
import java.util.Scanner;
        
public class PROG02_Tarea9 {
    public static void main(String[] args){ 
    Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un número entero de 5 dígitos junto con una direción \"i\" o \"l\" para la izquierda \n e"
                + " \"d\" o \"r\" y yo lo descompondré por ti hacia una u otra dirección");
          //El programa coje el número que se teclea.  
          int numero = teclado.nextInt();
          char direccion = teclado.next().charAt(0);
          //Delimito el número a 5 cifras, aunque tambien se podría hacer con lenght.
          if (numero <= 99999)  {
              //Asigno a la variable num la cadena de caracteres del numero; es decir, lo que se introdujo por teclado.
              String num = String.valueOf(numero);
              //Pido que imprima por pantalla en la dirección ordenada.
              if (direccion == 'd' || direccion == 'r') {
              System.out.println(num.charAt(0)+ "   " + num.charAt(1) + "   " + num.charAt(2) + "   " + 
                      num.charAt(3)+ "   " + num.charAt(4));
               }else if (direccion == 'i' || direccion == 'l')    {
                System.out.println(num.charAt(4)+ "   " + num.charAt(3) + "   " + num.charAt(2) + "   " + 
                      num.charAt(1)+ "   " + num.charAt(0));
                  } 
   
           else    {
              System.out.println("\nLo siento, introduce un número entero de 5 dígitos"
                      + "\n Por ejemplo:     12345      00021\n O asegúrate de introducir correctamente la dirección.");
          }
          }
          
    }
}
   
