package EjercicioObligatorio;

/**
 *
 * @author ponTuNombreAqui
 */
public class Apartado3 {
    
    public static void apartado3() {
        
        System.out.println("\nApartado3");
        
       /**@param casado Variable para saber si un empleado esta casado (true) o no (false).*/
       boolean casado = true;
                
       /**@param MAXIMO Variable para saber el valor maximo no modificable (final establece el valor como final, no modificable).*/
       final long MAXIMO = 999999;
       
       /**@param diasem Variable para saber el valor; di­a de la semana en valor numerico [1-7].*/
       byte diasem = 1;
       
       /**@param diaAnual Variable para saber el valor di­a del anho.*/
       short diaAnual = 300;
       
       /**@param miliseg Varible para saber el valor del tiempo Unix.*/
       long miliseg = System.currentTimeMillis();
       
       /**Valor total de la factura.*/
       float totalfactura = 10350.677734f;
       
       /**@param poblacion variable para saber el valor poblacion.*/
       long poblacion = 6775235741l;
       
       /**@param sexo Variable para conocer el sexo.*/
       char sexo = 'M';
       
    /*impresion con println(); para cada print con ln java establece una nueva li­nea.
     * Aunque tambien se podri­a hacer escribiendo para cada linea de texto impreso
     * una nueva li­nea de texto con un + y un \n, estableciendo el comienzo de una nueva linea
     * como en el ejemplo siguiente con print()
     */
    
    System.out.println("-----EJERCICIOS DE VARIABLES Y TIPOS DE DATOS-----");
    System.out.println("\tEl valor de la variable casado es " + casado);
    System.out.println("\tEl valor de la variable MAXIMO es " + MAXIMO);
    System.out.println("\tEl valor de la variable diasem es " + diasem);
    System.out.println("\tEl valor de la variable diaAnual es " + diaAnual);
    System.out.println("\tEl valor de la variable miliseg es " + miliseg);
    System.out.println("\tEl valor de la variable totalfactura es " + totalfactura);
    System.out.println("\tEl valor de la variable poblacion es " + poblacion);
    System.out.println("\tEl valor de la variable sexo es " + sexo); //cierre del ultimo System.put.println
             
    /*Para print() no nos separa cada string si no que lo imprimire todo en la misma linea
     * por lo que necesitamos separar cada una de las li­neas de parrafo para que quede con el formato
     * final, para ello utilizaremos \n.
     */  
    
    System.out.print(
            "\n-----EJERCICIOS DE VARIABLES Y TIPOS DE DATOS-----"
                    + "\n\tEl valor de la variable casado es " + casado
                    + "\n\tEl valor de la variable MAXIMO es " + MAXIMO
                    + "\n\tEl valor de la variable diasem es " + diasem
                    + "\n\tEl valor de la variable diaAnual es " + diaAnual
                    + "\n\tEl valor de la variable miliseg es " + miliseg
                    + "\n\tEl valor de la variable totalfactura es " + totalfactura
                    + "\n\tEl valor de la variable poblacion es " + poblacion
                    + "\n\tEl valor de la variable sexo es " + sexo);//cierre del print().
    
    
    /*Impresion con printf() en esta impresion debemos utilizar los especificadores de formatos
    * en este caso seran %s para strings, %d para numeros enteros, %f para decimales y %e
    * para notacion cienti­fica
    */
  
      
    System.out.printf("\n\n-----EJERCICIOS DE VARIABLES Y TIPOS DE DATOS-----");//Doble \n, una li­nea para separarse del print() anterior y otra para dejar espacio en blanco.
    System.out.printf("\n\tEl valor de la variable casado es %s", casado);
    System.out.printf("\n\tEl valor de la variable MAXIMO es %d", MAXIMO);
    System.out.printf("\n\tEl valor de la variable diasem es %d", diasem);
    System.out.printf("\n\tEl valor de la variable diaAnual es %d", diaAnual);
    System.out.printf("\n\tEl valor de la variable miliseg es %d", miliseg);
    System.out.printf("\n\tEl valor de la variable totalfactura es %6f", totalfactura); //En esta caso establecemos con el numero el total de decimales que queremos.
    System.out.printf("\n\tEl valor de la variable totalfactura en notacion cienti­fica es %e", totalfactura);
    System.out.printf("\n\tEl valor de la variable poblacion es %d", poblacion);
    System.out.printf("\n\tEl valor de la variable sexo es %s", sexo);
    
    
    
    
    } //Cierre del metodo.
    
}//Cierre de la clase

    

