package EjercicioB;

import static java.lang.Math.*;


public class Complejo {

    private double real; 
    private double imag;
        
    //Métodos constructores.
    //Constructor que pone los valores a cero que no a null.
    public Complejo(){
       this.real = 0;
       this.imag = 0;
    }
    
    //Constructor para los valores (double parte_real, double parte_imaginaria.
    public Complejo(double real, double imag){
        this.real = real;
        this.imag = imag;
    }
    
    
   
    //Métodos getters.
    public double consulta_Real(){
        return real;
    }
    public double consulta_Imag(){
        return imag;
    }
   
    
    //Método set.
    public void cambia_Real(double real){
        this.real=real;
    }
    public void cambia_Imag(double imag){
        this.imag=imag;
    }
    
    
    @Override
    //Método que convierte el valor que devuelve en una cadena de texto.
    public String toString(){
       return  round(real) + " + " + round(imag) + "i ,si " + round(real) + " es la parte real y " + round(imag) + " la parte imaginaria.";
    }
    
    /*Método para sumar los complejos que recibe como argumento el Complejo b y a partir del cual
    *establece un nuevo real para la suma de su real (b.consulta_Real()) y su imaginario (b.consulta_Imag())
    *con los valores introducidos para el Complejo a this.real y this.imag.
    */
    public void Sumar(Complejo b){
       this.real = this.real + b.consulta_Real();
       this.imag = this.imag + b.consulta_Imag();
       
    }
   

    
   
    
    
}
