
package Mario_Vazquez;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Opcion2 {
    public static void metodoOpcion2 () {
        
    Scanner teclado = new Scanner(System.in);//Dentro de cada método si quieres que funcione tenemos que crear el objeto de la clase java.util.Scanner
        
    String [] Meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};//Inicializamos un String array.
            List<String> MesesAño = Arrays.asList(Meses); //Lo convertimos en una lista, esto lo uso por un consejo que vi en stackoverflow.
       
            System.out.println("Introduce un año!");
            int year;//Declaramos de nuevo una variable vacía donde almacenar el next.Int()
            year = teclado.nextInt();
            if((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))){//Si se cumple que, resto /4 = 0 y resto /100 != 0 o divisible /400.
                System.out.println("Ese año fue o será un año bisiesto!");
                
                System.out.println("Ahora dime el número correspondiente al mes del año!");
                int mes = teclado.nextInt();//No necesitamos declarar variable vacía puesto que trataremos el int inmediatamente.
                if (mes % 2 != 0 || mes == 8) {//Si es un mes impar o el 8 mes...
                System.out.println("Has escogido el mes de " + MesesAño.get(mes-1) + ", este mes tiene 31 días");//... imprimimos
                //mes - 1 porque la lista empieza el conteo desde 0 de forma que Enero ocupa el puesto 0 en la lista.
                }
                else if (mes == 2){//Y si es febrero, dentro del supuesto de que es un año bisiesto.
                    System.out.println("Has escogido " + MesesAño.get(mes-1) + " y tiene 29 días en año bisiesto!");
                }
                else    {//Si no se cumple ninguna de las dos condiciones anteriores.
                    System.out.println(MesesAño.get(mes-1) + " tiene 30 días!");
                }
            } else {//Si no se cumplen las condiciones para que sea un año bisiesto.
                System.out.println("Este año fue o será un año NO bisiesto.");
                System.out.println("Ahora dime el número correspondiente al mes del año!");
                int mes_no = teclado.nextInt();
                
                    if (mes_no % 2 != 0 || mes_no == 8) {
                    System.out.println("Has escogido el mes de " + MesesAño.get(teclado.nextInt()-1) + ", este mes tiene 31 días");
                    }
                    else if(mes_no == 2)
                    System.out.println("Has escogido el mes de " + MesesAño.get(mes_no-1) + ", este mes tiene 28 días");
                        else    {
                        System.out.println("Has escogido el mes de " + MesesAño.get(mes_no-1) + ", este mes tiene 30 días");
                        }
                    
                }  
    }
}

