package PROG07_Tarea;


/**
 *
 * @author Mario
 */
public class Banco {
    
    //Variables para Banco.
    private CuentaBancaria cuenta[];
    private int posicion = 0;
    
    //Metodo constructor para Banco
    public Banco () {
        this.cuenta = new CuentaBancaria[100];
        this.posicion = 0;
    }

    /**Metodo que recibe como parametro la cadena que conforma el IBAN y comprueba si este ya existe en algun objeto del array
     * 
     * @param IBAN
     * @return 
     */
    public String informacionCuenta(String IBAN) {
        for(int i = 0; i < posicion; i++)
            if(cuenta[i].getIBAN().toUpperCase().matches(IBAN)) 
                return cuenta[i].devolverInfoString();
        return null;
    }
    
    /**Metodo para devolver el objeto que buscamos por IBAN
     * 
     * @param IBAN
     * @return cuenta[]
     */
    public CuentaBancaria traerCuenta (String IBAN) {
        for(int i = 0;i < posicion; i++)
            if(cuenta[i].getIBAN().matches(IBAN)) 
                return cuenta[i];
                
        return null;
    }
    
    /**Metodo para buscar la cuenta segun su IBAN
     * 
     * @param IBAN
     * @return 
     */
    public boolean buscarCuenta (String IBAN) {
        for(int i = 0; i < posicion; i++)
            if(cuenta[i].getIBAN().toUpperCase().matches(IBAN))
                return true;
        return false;
    }
    
    
    /**Metodo que introduce en el array de objetos de CuentaBancaria una nueva cuenta del tipo que queramos gracias al polimorfismo.
     * 
     * @param nuevaCuenta
     * @return 
     */
    public boolean abrirCuenta (CuentaBancaria nuevaCuenta) {
       
       //Comprobamos si ese IBAN existe ya para otro objeto del array.
       if(informacionCuenta(nuevaCuenta.getIBAN()) == null && posicion < 100) { 
            cuenta[posicion] = nuevaCuenta;
            posicion ++;
          
            return true;          
       }
       return false;
    }
    
    /**Metodo que devuelve un Array de strings con la informacion de las cuentas.
     * 
     * @return el array con todas las cuentas.
     */
    public String[] listarCuentas () {
        String[] listar = new String[posicion];
        int puesto;
            for(puesto = 0; puesto < posicion; puesto++)
                if(cuenta[puesto].getIBAN() != null)
                    listar[puesto] = "\n" + (puesto + 1) + " IBAN: " + cuenta[puesto].getIBAN() + " correspondiente a " + cuenta[puesto].getTitular().getNombre() + " " + cuenta[puesto].getTitular().getApellido() + " con saldo disponible: " + cuenta[puesto].getSaldo() + "€ \n";
                    //listar[puesto] = cuenta[puesto].devolverInfoString();
 
        
                    return listar;
                   
    }

    
    /**Metodo para aumentar el saldo de la cuenta con el mismo IBAN
     * 
     * @param IBAN
     * @param cantidad
     * @return 
     * @throws 
     */
    public boolean ingresoCuenta (String IBAN, double cantidad) throws IllegalArgumentException {
       
        if(buscarCuenta(IBAN.toUpperCase()) && cantidad > 0) {
            traerCuenta(IBAN).setSaldo(traerCuenta(IBAN).getSaldo() + cantidad);
                    
                        return true;
        }else{
            throw new IllegalArgumentException("El IBAN o la cantidad introducida no son validos, asegurese de que introduce un IBAN valido y una cantidad positiva");
        }
        
    
    }
    
    /**Metodo para retirar saldo de la cuenta con el mismo IBAN
     * 
     * @param IBAN
     * @param cantidad
     * @return 
     * @throws 
     */
    public boolean retiradaCuenta (String IBAN, double cantidad) throws IllegalArgumentException {
        
        if(buscarCuenta(IBAN.toUpperCase()) && cantidad > 0) {
            traerCuenta(IBAN).setSaldo(traerCuenta(IBAN).getSaldo() - cantidad);
                    
                        return true;
        }else{
            throw new IllegalArgumentException("El IBAN o la cantidad introducida no son validos, asegurese de introducir un IBAN valido y un valor mayor o igual que cero");
        }
    
    }
    

            
    //Metodos getter y setter.
    public CuentaBancaria[] getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBancaria[] cuenta) {
        this.cuenta = cuenta;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
  
}
