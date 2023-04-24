
/**
 *
 * @author Mario
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ordenaTres {

    public static void main(String[] args) {

        List numeros = new ArrayList();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dame tres números y déjame ordenarlos de en el orden que eligas!"
                + "\nc, para que los ordende en orden creciente y d, para orden decreciente");
        do {
            int n = teclado.nextInt();
            numeros.add(n);
        } while (numeros.size() < 3);

        char orden = teclado.next().charAt(0);
        if (orden == 'c') {
            Collections.sort(numeros);
            System.out.println(numeros);
        }
        if (orden == 'd') {
            Collections.sort(numeros, Collections.reverseOrder());
            System.out.println(numeros);

        }

    }
}
