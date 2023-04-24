package EjercicioA;

public class testPersona  {
    public static void main(String[] args) {
        
        //Como es un método no estático debemos instanciar un objeto--> Persona nueva = new Persona();
        Persona pers1 = new Persona();
        
        System.out.println("El valor por defecto que otorga el método constructor a la clase Persona hace que "
                + "el objeto pers1 se llame: " + pers1.getNombre() + " mida " + pers1.getAltura() + " y tenga " + pers1.getEdad()
         + " años.");
        
        //Ahora crearemos un nuevo objeto "pers2" asociado al nuevo constructor.
        Persona pers2 = new Persona("Mario", 29, 1.74f);
        
        System.out.println("El valor que hemos asignado al instanciar una clase con el nuevo método constructor es "
                + "una persona que se llama " + pers2.getNombre()+ " que tiene " + pers2.getEdad() + " años "
                        + "y que mide " + pers2.getAltura() + " cm.");
        
    }
}