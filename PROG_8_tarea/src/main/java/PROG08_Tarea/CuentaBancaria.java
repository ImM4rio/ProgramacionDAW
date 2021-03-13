package PROG08_Tarea;

/**
 *
 * @author Mario
 */
//Superclase abstracta (no va a instanciarse ningun objeto y que implementa la interfaz.
public abstract class CuentaBancaria implements Imprimible{
    
    //Atributos generales de la clase cuentaBancaria.
    private String IBAN;
    private double saldo;
    private Persona titular;
    
    /**Metodo constructor de CuentaBancaria que recibe
     * 
     * @param titular
     * @param IBAN
     * @param saldo
     * @throws IllegalArgumentException 
     */
    public CuentaBancaria (Persona titular, String IBAN, double saldo) throws IllegalArgumentException {
        
        if(!comprobarNombre(titular)) {
            throw new IllegalArgumentException("Error al introducir el nombre y los apellidos del titular.");
        }
        this.titular = titular;
        
        //Condicional que comprueba la correcta entrada del IBAN.
        if(!comprobarIBAN(IBAN)) {
            throw new IllegalArgumentException ("Error al introducir el IBAN, por favor, inténtelo de nuevo.");
        }
        this.IBAN = IBAN;
         
        this.saldo = saldo;
        
    }

    
    /**Metodo para la comprobacion del IBAN en funcion a una expresion REGEX
     * 
     * @param IBAN
     * @return 
     */
    public boolean comprobarIBAN (String IBAN) {
        return IBAN.toUpperCase().matches("^[ES]{2}[0-9]{22}$");
    }
    
    /**Metodo para la compprbacion del nombre y apellido
     * 
     * @param titular
     * @return 
     */
    public boolean comprobarNombre (Persona titular) {
        return (titular.getNombre() + titular.getApellido()).matches("[A-Za-z\\s]{1,40}");
    }
    
    

    //Metodos getter y setter.
    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN.toUpperCase();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }


}

