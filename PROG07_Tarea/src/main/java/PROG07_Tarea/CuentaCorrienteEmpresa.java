package PROG07_Tarea;

import java.util.Arrays;

/**
 *
 * @author Mario
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente implements Imprimible{
    
    //Variables unicas de este tipo de cuenta.
    private double maxDescubierto;
    private double tipoInteres;
    private double comision;
    
        /**Metodo constructor para CuentaCorrienteEmpresa
         * 
         * @param titular
         * @param IBAN
         * @param saldo
         * @param listaEntidades 
         * @param maxDescubierto 
         * @param tipoInteres 
         * @param comision 
         */
        public CuentaCorrienteEmpresa (Persona titular, String IBAN, double saldo, String[] listaEntidades, double maxDescubierto, double tipoInteres, double comision) throws IllegalArgumentException {
            
            super(titular, IBAN, saldo, listaEntidades);
            
            if(maxDescubierto < 0) {
                throw new IllegalArgumentException ("El valor debe de ser un numero positivo.");
            }
            this.maxDescubierto = maxDescubierto;
            
            if(tipoInteres < 0) {
                throw new IllegalArgumentException ("El valor debe de ser un numero positivo.");
            }
            this.tipoInteres = tipoInteres;
            
            if(comision < 0) {
                throw new IllegalArgumentException ("El valor debe de ser un numero positivo.");
            }
            this.comision = comision;
        }
    
    
    
    //Metodos getter y setter.

    public double getMaxDescubierto() {
        return maxDescubierto;
    }

    public void setMaxDescubierto(double maxDescubierto) {
        this.maxDescubierto = maxDescubierto;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
        


    @Override
    public String devolverInfoString() {
        return "\nLa cuenta con IBAN " + this.getIBAN() + " pertenece a " + this.getTitular().getNombre() + " " + this.getTitular().getApellido() + "(" 
                + this.getTitular().getDNI() + ")" + " con saldo " + this.getSaldo() + " con la comision " 
                + this.comision + "% con el tipo de interes " + this.tipoInteres + "% y un maximo descubierto de " + this.maxDescubierto + "% con las entidades autorizadas: " + 
                Arrays.toString(this.getListaEntidades());

    }
}
