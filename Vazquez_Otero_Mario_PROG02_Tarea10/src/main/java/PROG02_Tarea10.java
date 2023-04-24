/**
 *
 * @author Mario
 */

public class PROG02_Tarea10 {

    public static void main(String[] args)  {
        float x = 4.5f;
        float y = 3.0f;
        int i = 2;
        
        //Conversión explícita.
        int j = (int)(i * x);
        double dx = 2.0d;
        double dz = dx * y; //No es necesaria conversión.
        
        System.out.printf("------Conversiones entre enteros y coma flotante"
                + "\nProducto de int por float: j= i*x= %d"
                + "\nProducto de float por double: dz= dx * y = %.1f", j, dz);
        
        //Operaciones con byte
        byte bx;
            bx = 5;
        byte by;
            by = 2;
            
        //Conversión explícita ya que el valor de una operación entre bytes la devolverá en entero.
        byte bz;
            bz =(byte)(bx - by);
        
        System.out.printf("\n\n------Operaciones con byte------"
        + "\nbyte: %d - %d = %d", bx, by, bz);
      
        bx = -128;//Rango de byte 
        by = 1;
        bz = (byte)(bx - by);
        
        System.out.printf("\nbyte: %d - %d = %d", bx, by, bz);       
       
        /**La variable bz de tipo byte está anteriormente declarada y no podemos realizar
         * la conversión de tipos desde un byte a un int 
         * por lo que nombro una nueva variable de tipo int
         */
        int entero = (int)bx - by;
          
        System.out.printf("\n(int)(%d - %d)= %d", bx, by, entero);
        
        short sx = 5;
        short sy = 2;//Tengo la duda de si está mal redactado el enunciado o he hecho algo mal.
        
        /**Conversión explícita, tanto operaciones de byte o short tienen como resultado int
        *así que forzamos la conversión del resultado a short
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
        //Conversión explícita.
        int z = (char)(cx - cy);
           
        System.out.printf("\n\n------Operaciones con char------"
            + "\nchar: %c - %c = %d", cx, cy, z);
        
        //convertimos cx por conversión explícita para obtener el int.
        z = ((int)cx) - 1;
        
        System.out.printf("\n%c - %d = %d", cy, sy, z);
        cx = '\uFFFF';
        z = cx;
        
        System.out.printf("\n(int) = %d", z);
        
        //Conversión explícita del char a short porque la variable ya está declarada como short.
        sx = (short)cx;
               
        System.out.printf("\n(short)= %d", sx);
        
        sx = -32768;
        
        //Conversión explícita de short a char.
        cx = (char)sx;
        z = (int)sx;
               
        System.out.printf("\n%d short-char-int = %d", sx,z);
        
        sx = -1;
        cx = (char)sx;
        
        //Conversión explícita de char a int.
        z = (int)cx;
        
        System.out.printf("\n%d short-char.int = %d", sx, z);
    
        
        
        
            
        
        
        
        }
}
