/**
 *
 * @author Mario
 */
import java.util.Scanner;

public class PROG02_Tarea8 {
    public static void main(String[] args)  {
        
        Scanner teclado = new Scanner(System.in);
        float x = teclado.nextFloat();
        float y = teclado.nextFloat();
        System.out.print("\nx = "+ x +", e y = " + y);
        //Valores .2f para aproximar a los dos decimales.
        System.out.printf("\n\nx + y = %.2f", x + y);
        System.out.printf("\nx - y = &.2f", x - y);
        System.out.printf("\nx * y = %.2f", x * y);
        System.out.printf("\nx / y = %.2f", x / y);
        System.out.printf("\nx^2 = %.2f", x * x);
        System.out.printf("\n\u221A x = %.2f", Math.sqrt(x));
      
    }
}
