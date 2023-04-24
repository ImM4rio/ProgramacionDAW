/**
 *
 * @author Mario
 */
import java.util.Scanner;
        
public class ordenaDos {
    public static void main(String[] args) {
               
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dame dos números y yo te diré cuál es mayor!.");
            int n1 = teclado.nextInt();
            int n2 = teclado.nextInt();
        
        
            if (n1 > n2)    {
                System.out.printf("\nEl número %d es mayor al número %d", n1, n2);
            }else if (n1 < n2)  {
                System.out.printf("El número %d es mayor al número %d", n2, n1);
            }else if (n1 == n2) {
                System.out.println("No me engañes!, los dos son el mismo número");
        }
    }
}
