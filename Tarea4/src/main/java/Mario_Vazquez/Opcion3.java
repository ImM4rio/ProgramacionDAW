package Mario_Vazquez;

import java.util.Scanner;

public class Opcion3 {
    public static void metodoOpcion3() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dime un número y lo descompondré en factores primos.");
            int primo;//Declaramos variable vacía para contener int.
            primo = teclado.nextInt();
            System.out.print(primo + " es primo de: ");
            
                for (int contador=1; contador <= primo; contador++) //Desde el contador = 1, mientras que el contador sea menor o igual al número primo... 
                {
                    if (primo % contador  == 0) {//...se comprobará si la división da como resto 0, en ese caso... imprime, si no--> (contador ++) suma 1 y hazlo de nuevo.
                        System.out.print(contador + ", ");

                    }

                }
    }
}
