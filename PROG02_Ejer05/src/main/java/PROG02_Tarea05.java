/**
 *
 * @author Mario
 */
//Importamos de java la clase Scanner.
import java.util.Scanner;

public class PROG02_Tarea05 {
    
public static void main(String[] args){
    
    //Método para introducir números por el teclado, tanto el n1 como el n2.
    Scanner teclado = new Scanner(System.in);
    int n1 = teclado.nextInt();
    int n2 = teclado.nextInt();
    //& = resto de la división.
    int resto = n1 % n2;  
    
    //Si el resto no es igual a 0 quiere decir que el segundo no es múltiplo del primero.
    if(resto == 0)  {
        System.out.printf("Correcto! %d es múltiplo de %d", n1, n2);
    }   else    {
        System.out.print("\nLo siento, en este caso " + n1 + " y " + n2 + " no son múltiplos");
    }
    }
}