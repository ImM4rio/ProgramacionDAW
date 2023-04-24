/**
 *
 * @author Mario
 */   
public class PROG02_Tarea6 {
    
    //Cuando conocemos todos los valores en tiempo de compilación -->enum.
    public enum Meses {
        ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE,
        OCTUBRE, NOVIEMBRE, DICIEMBRE;
        }
    
    public static void main(String[] args) {
        //Código.
        //Damos a m el valor dentro del enum de MARZO.
        Meses m = Meses.MARZO;
        System.out.println(m);
        //Damos a m (que llama al componente MARZO del enum el valor de la string "MARZO".
        m = Meses.valueOf("MARZO");
        System.out.println(m);
        
    }
}

