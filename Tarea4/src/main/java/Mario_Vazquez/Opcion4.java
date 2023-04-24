package Mario_Vazquez;

import java.util.Scanner;

public class Opcion4 {
   
   public static void metodoOpcion4 (){
       System.out.println("Cómo te llamas?");
       
       Scanner teclado = new Scanner(System.in);
       String nombre;
       nombre = teclado.nextLine();
       System.out.println("Hola " + nombre + ", cuántos años tienes?");
       int edad;
       edad = teclado.nextInt();
       
       if (edad <= 25)//Si es menor o igual a 25.
           System.out.println("Tienes " + edad + " años, estás en el grupo A, en una década tendrás " + (edad + 10) + " años.");
       else if (edad <= 50)//Si no se cumplió la anterior y es menor igual a 50
           System.out.println("Tienes " + edad + " años, estás en el grupo B, en una década tendrás " + (edad + 10) + " años.");
       else if (edad >= 51)//Si no se cumplieron las anteriores y es mayor igual a 51
           System.out.println("Tienes " + edad + " años, estás en el grupo C, en una década tendrás " + (edad + 10) + " años.");


   }
}
