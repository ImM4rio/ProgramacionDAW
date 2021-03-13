package PROG08_Tarea;

/**
 *
 * @author Mario
 */

public class CuentaAhorro extends CuentaBancaria implements Imprimible{
    
    //Añadimos la variable de tipoInteres para esta cuenta.
    private double tipoInteres;
    
    /**Metodo constructor para la cuenta de ahorro.
     * 
     * @param titular
     * @param IBAN
     * @param saldo
     * @param tipoInteres 
     */
    
    public CuentaAhorro (Persona titular, String IBAN, double saldo, double tipoInteres) {
        
        super(titular, IBAN, saldo);  //Llamada al metodo constructor de la superclase.
        this.tipoInteres = tipoInteres;
    }

    
    //Metodos getter y setter.
    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }
      
    
    /**Metodo de la interface sobreescrito para cada clase que lo implemente y que devuelve
     * cadena de texto con la informacion de la cuenta.
     * 
     * @return 
     */
    @Override
    public String devolverInfoString() {
        return "\nLa cuenta con IBAN " + this.getIBAN() + " pertenece a " + this.getTitular().getNombre() + " " + this.getTitular().getApellido() + "(" 
                + this.getTitular().getDNI() + ")" + " con saldo " + this.getSaldo() + " con el interes al " + this.tipoInteres + "%.";
    }    
}
    
    
