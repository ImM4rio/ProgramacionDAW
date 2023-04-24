package PROG07_Tarea;

import java.util.Arrays;

/**
 *
 * @author Mario
 */
public class CuentaCorrientePersonal extends CuentaCorriente implements Imprimible{
        
        //Variable para este tipo de cuenta.
        private double comisionesMant;
        
        /**Metodo constructor para CuentaCorrientePersonal
         * 
         * @param titular
         * @param IBAN
         * @param saldo
         * @param listaEntidades
         * @param comisionesMant 
         */
        public CuentaCorrientePersonal (Persona titular, String IBAN, double saldo, String[] listaEntidades, double comisionesMant) throws IllegalArgumentException {
            super(titular, IBAN, saldo, listaEntidades);
            
            if(comisionesMant < 0) {
                throw new IllegalArgumentException ("El valor de las comisiones tiene que ser un valor igual o mayor que cero.");
            }
            this.comisionesMant = comisionesMant;
        }
    

    //Metodos getter y setter.

    public double getComisionesMant() {
        return comisionesMant;
    }

    public void setComisionesMant(double comisionesMant) {
        this.comisionesMant = comisionesMant;
    }
    
    

    @Override
    public String devolverInfoString() {
        return "\nLa cuenta con IBAN " + this.getIBAN() + " pertenece a " + this.getTitular().getNombre() + " " + this.getTitular().getApellido() + "(" + this.getTitular().getDNI() +
                ")" + " con saldo " + this.getSaldo() + " con la comision de mantenimiento " + this.comisionesMant + "% con las entidades autorizadas: " + Arrays.toString(this.getListaEntidades());

    }
}
