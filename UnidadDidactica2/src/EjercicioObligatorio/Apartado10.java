package EjercicioObligatorio;

/**
 *
 * @author ponAquiTuNombre
 */

public class Apartado10 {
    
    public static void apartado10() {
        
        System.out.println("\nApartado10");
        
        //Instanciamos el tipo de dato float de la siguiente manera.
        float x = 4.5f;
        float y = 3.0f;
        
        int i = 2;
        
        /**
         * Conversion explicita
         * Si queremos asignar un valor de tipo de dato mas grande a un tipo de dato mas pequenho, 
         * realizamos un CASTEO/CASTING o lo que se conoce como conversion de tipo explicita.
         * 
         * double -> float -> long -> int -> short -> byte  
         * 
         * Al escribir int entre parentesis se fuerza a cambiar el dato de tipo float resultante de (i * x) a int.
         * Hay que tener cuidado al realizar esta conversion ya que se puede aplicar a tipos no compatibles, 
         * lo que puede derivar en perdidas de informacion e incluso errores en ejecucion.
         * 
         * float x = 5.7F;
         * int y = (int) x;
         * 
         * Se realizara la conversion, pero se perdera la parte decimal del numero con punto flotante al guardarlo en y. 
         * Solo se guardara 5 en y. Aunque parezca ilogico, habra ocasiones en las que esta perdida de precision nos pueden 
         * resultar util.
         */
        
        int j = (int)(i * x);
        double dx = 2.0d;
        double dz = dx * y; //Se realiza una conversion implicita, no es necesario que el programador haga nada.
        
        System.out.printf("------Conversiones entre enteros y coma flotante"
                + "\nProducto de int por float: j= i*x= %d"
                + "\nProducto de float por double: dz= dx * y = %.1f", j, dz);
        
        //Operaciones con byte
        byte bx;
            bx = 5;
        byte by;
            by = 2;
            
        //Conversion expli­cita ya que el valor de una operacion entre bytes devolvera un entero.
        byte bz;
            bz =(byte)(bx - by);
        
        System.out.printf("\n\n------Operaciones con byte------"
        + "\nbyte: %d - %d = %d", bx, by, bz);
      
        bx = -128;//Rango de byte 
        by = 1;
        bz = (byte)(bx - by);
        
        System.out.printf("\nbyte: %d - %d = %d", bx, by, bz);       
       
        /**
         * La variable bz de tipo byte esta anteriormente declarada y no podemos realizar
         * la conversion de tipos desde un byte a un int 
         * por lo que nombro una nueva variable de tipo int
         */
        int entero = (int)bx - by;
          
        System.out.printf("\n(int)(%d - %d)= %d", bx, by, entero);
        
        short sx = 5;
        short sy = 2;//Tengo la duda de si esta mal redactado el enunciado.
        
        /**
         * Conversion expli­cita, tanto operaciones de byte o short tienen como resultado int
         * asi­ que forzamos la conversion del resultado a short
         */
        
        short sz = (short)(sx - sy);
        
        System.out.print("\n\n------Operaciones con short------");
        System.out.printf("\nshort: %d - %d = %d", sx, sy, sz); 
        
        sx = 32767;
        sy = 1;
        
        sz = (short)(sx + sy);
        
        System.out.printf("\nshort %d + %d = %d", sx, sy, sz);
          
        char cx = '\u000F';
        char cy = '\u0001';
        //Conversion explicita.
        int z = (char)(cx - cy);
           
        System.out.printf("\n\n------Operaciones con char------"
            + "\nchar: %c - %c = %d", cx, cy, z);
        
        //Convertimos cx por conversion expli­cita para obtener el int.
        z = ((int)cx) - 1;
        
        System.out.printf("\n%c - %d = %d", cy, sy, z);
        cx = '\uFFFF';
        z = cx;
        
        System.out.printf("\n(int) = %d", z);
        
        //Conversion expli­cita del char a short porque la variable ya esta declarada como short.
        sx = (short)cx;
               
        System.out.printf("\n(short)= %d", sx);
        
        sx = -32768;
        
        //Conversion explÃ­cita de short a char.
        cx = (char)sx;
        z = (int)sx;
               
        System.out.printf("\n%d short-char-int = %d", sx,z);
        
        sx = -1;
        cx = (char)sx;
        
        //Conversion expli­cita de char a int.
        z = (int)cx;
        
        System.out.printf("\n%d short-char.int = %d", sx, z);
    }
        
}
