/**
 *
 * @author Mario
 */
import java.util.Scanner;
        
public class PROG02_Tarea7 {
    public static void main(String[] args)  {
        //Input
        System.out.print("Introduce 2 números para la ecuación C1x + C2 = 0"
        + "en caso de ser decimales, asegúrate de que están separados por una \",\"");
        Scanner teclado = new Scanner(System.in);
        //Se utiliza float por si entran decimales.
        float c1 = teclado.nextFloat();
        float c2 = teclado.nextFloat();
        //Operación despejando la x.
        float x = (float)(-c2 / c1);
        //Impresión en pantalla.
        System.out.printf("\n%.2f * x + %.2f = 0", c1, c2);
        System.out.printf("\nx = %.2f", x);
    }
}
