package Mario_Vazquez;

import java.util.Scanner;

/**
 *
 * @author Mario
 */

//En esta clase vamos a crear el método main, así que será desde donde originaremos el código del programa.
public class Tarea4 {

    //Método principal desde el que llamaremos a cada uno de los métodos de las opciones.
    public static void main(String[] args) {
    int menu; //Declaramos una variable menu vacía que utilizaremos para la estructura de control while y switch. Lo tomaremos como un contenedor
              //...porque si no, cada vez que llamemos el .nextInt() se perderá tras cada pulsación.
    Scanner teclado = new Scanner(System.in);//Instanciamos un objeto de clase.
    do{//Limitamos el bucle que queremos crear ... 
    System.out.println("\nEscoge una de las 5 opciones! teclea el número de opción y dale a \"Enter\""
            + "\n Opción 1 : Dame un número entero y yo te diré si es par!"
            + "\n Opción 2: Dime un mes en formato numérico junto a su año y te indicaré cuántos días tiene ese mes!"
            + "\n Opción 3: Descompondré el número que me digas en factores primos!"
            + "\n Opción 4: Dime tu nombre y tu edad y te diré cuantos años tendrás en una década!"
            + "\n Opción 0: Sal del programa.");
        menu = teclado.nextInt();//Aquí almacenaremos en la variable menú el siguiente int que se origine por el input del teclado.
    
    switch (menu){ //Estructura de selección para diferenciar entre los posibles casos de la variable menu.
        
        case 1://Caso 1 -> cuando menu = 1;
            Opcion1.metodoOpcion1(); //Llamamos al método estático de la clase Opcion1, si no fuese static tendríamos que instanciar un objeto de esa clase y luego llamar al método del objeto instanciado.
            
            break; //Finalizamos el programa.
    
        case 2:
            Opcion2.metodoOpcion2();
            
            break;
            
        case 3:
            Opcion3.metodoOpcion3();
            
            break;
        
        case 4:
            Opcion4.metodoOpcion4();
            
            break;
        
        default: //crearemos esto para que cuando el switch no nos derive a ningún caso...
                if (menu != 0)//...y sea el valor introducido diferente a 0, saldrá el siguiente mensaje:
                System.out.println("Opción incorrecta, inténtalo de nuevo o pulsa 0 para salir");
            
            break;
        }
    }while (menu != 0);//... mientras no se cumpla esta condición la estructura do se repetirá formando un bucle hasta que se salga del do{} con 0, saliendo del programa.
    }//Ten en cuenta que se repetirá solo las sentencias del do{}
}




    

