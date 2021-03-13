package PROG08_Tarea;

/**
 *
 * @author Mario
 */
public abstract class CuentaCorriente extends CuentaBancaria{
    
    //Array para la lista de entidades.
    private String[] listaEntidades = new String[10];
        
    /**Metodo constructor para objetos de la clase CuentaCorriente
     * 
     * @param titular
     * @param IBAN
     * @param saldo
     * @param listaEntidades 
     */
        public CuentaCorriente(Persona titular, String IBAN, double saldo, String[] listaEntidades) {
            super(titular, IBAN, saldo);
            this.listaEntidades = listaEntidades;
        }
        

    
    //Metodos getter y setter

    public String[] getListaEntidades() {
        return listaEntidades;
    }

    public void setListaEntidades(String[] listaEntidades) {                
        this.listaEntidades = listaEntidades;            
    }
    
   
}
