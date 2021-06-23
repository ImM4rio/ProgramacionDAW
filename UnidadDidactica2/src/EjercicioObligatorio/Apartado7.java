package EjercicioObligatorio;

//7.- Diseña un programa Java para resolver una ecuación de primer grado con una incógnita (x), suponiendo que los coeficientes de la ecuación (C1 y C2) se introducen desde teclado.

    //C1x + C2 = 0

import java.util.Scanner;

/**
 *
 * @author ponAquiTuNombre
 */
public class Apartado7 {
    public static void ecuacion(){
        
            System.out.println("\nApartado7");
        

        Scanner teclado = new Scanner(System.in);
        float c1, c2, x;
        
        System.out.print("Introduce 2 numeros para la ecuacion C1x + C2 = 0"
        + "en caso de ser decimales, asegurate de que estan separados por una \",\"\n");
        //Se utiliza float por si entran decimales.
        c1 = teclado.nextFloat();
        c2 = teclado.nextFloat();
        //Operacion despejando la x, forzando el casteo a float.
        x = (float)(-c2 / c1); 
        //ImpresiÃ³n en pantalla.
        System.out.printf("\n%.2f * x + %.2f = 0", c1, c2);
        
        //El metodo devuelve el valor de x.
        System.out.println("\nx = " + x);
    }
}
