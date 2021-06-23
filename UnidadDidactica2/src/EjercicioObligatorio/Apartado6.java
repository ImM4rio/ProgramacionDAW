package EjercicioObligatorio;

//6.- Diseña un programa Java que cree un tipo enumerado para los meses del año. El programa debe realizar las siguientes operaciones:
    //Crear una variable m del tipo enumerado y asignarle el mes de marzo. Mostrar por pantalla su valor.
    //Asignar a la variable m, la cadena de texto "MARZO". Mostrar por pantalla el valor de la variable de tipo enumerado tras realizar la asignación.


/**
 *
 * @author ponAquiTuNombre
 */
public class Apartado6 {
    
    //Cuando conocemos todos lo valores en tiempo de compilacion podemos utilizar los enum.
    public enum Meses {
        ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, 
        NOVIEMBRE, DICIEMBRE;
        
    }
    
    public static void apartado6 (){
        
        System.out.println("\nApartado6");
        
        //Crear una variable m del tipo enumerado y asignarle el mes de marzo.
        Meses m = Meses.MARZO;
        System.out.println(m);
        
        /**
         * Asignar a la variable m, la cadena de texto "Marzo". Mostrar por pantalla 
         * el valor de la variable de tipo enumerado tras realizar la asignación.
        */
        m = Meses.valueOf("MARZO");
        System.out.println(m);
    }
}
