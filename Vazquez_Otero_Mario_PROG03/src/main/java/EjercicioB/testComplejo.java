package EjercicioB;

import java.util.Scanner;//Importamos la clase Scanner para la entrada por System.in.

public class testComplejo {
    public static void main(String[] args) {//Método principal.
        
        Complejo a = new Complejo();//Creamos una instancia de la clase Complejo
            
        
        Scanner teclado = new Scanner(System.in);//Creamos una instancia de la clase Scanner.
        
        //Entrada para los valores del objeto Complejo a.
        System.out.println("Introduce por teclado la parte entera de un número");
        double real_a = teclado.nextDouble();
        System.out.println("Ahora introduce la parte imaginaria.");
        double imag_a = teclado.nextDouble();
        
        //Damos a real e imag el valor introducido mediante Scanner pasándole el método Setter.
        a.cambia_Real(real_a);
        a.cambia_Imag(imag_a);
        
        //Imprimimos por pantalla el retorno de los método getters para el objeto Complejo a.
        System.out.println(a.consulta_Real()+ "," + a.consulta_Imag());
        
        
        
        Complejo b = new Complejo();//Instanciamos el nuevo objeto b a partir de la clase Complejo.
        System.out.println("Ahora, teclea que valor real quieres dar al objeto.");
        double real_b = teclado.nextDouble();
        System.out.println("Muy bien, lo estás haciendo de lujo!!, ya me has dicho que valor real quieres, dime ahora la parte imaginaria.");
        double imag_b = teclado.nextDouble();
        
        //De nuevo seteamos los valores, esta vez, de las variables atributo del Complejo b.
        b.cambia_Real(real_b);
        b.cambia_Imag(imag_b);
        
        //Imprimimos por pantalla la consulta para qué valores componen el objeto b.
        System.out.println(b.consulta_Real()+ "," + b.consulta_Imag());
        
        
        a.Sumar(b);//Llamamos al método sumar con el Complejo b como argumento.
        System.out.println(a.consulta_Real() + "," + a.consulta_Imag());//Imprimimos por pantalla el valor seteado en el método sumar.
        
        
        System.out.println(a.toString());
        
        
    }    
    
}
            
                
    
