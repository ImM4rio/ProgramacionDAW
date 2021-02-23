package Banco;

/**
 *
 * @author Mario
 */
public final class CuentaBancaria {
    private String titular;
    private double saldo;
    private String entidad;
    private String oficina;
    private String numCuenta;
    private String digitosControl;
    private String CCC;
    public static final int maxCaracteres = 50;
    public static final int minCaracteres = 10;
    
    /**Método constructor para todos los parámetros
     * 
     * @param titular
     * @param entidad
     * @param oficina
     * @param digitosControl
     * @param numCuenta
     * @throws Exception 
     */
    
    public CuentaBancaria (String titular, String entidad, String oficina, String digitosControl, String numCuenta)
            throws Exception { //Lanzamos las excepciones.
        if (titular.length() < minCaracteres || titular.length() > maxCaracteres)
            throw new IllegalArgumentException("Nombre de titular no válido.");
            //Si la longitud de la cadena titular no es adecuada salta una excepción.
            
        if (!entidad.equals(String.valueOf(Integer.parseInt(entidad))))
            throw new IllegalArgumentException("Nº de oficina no válido.");
            //Si comparamos el String con su valor numérico tiene que ser el mismo, es decir, todos los dígitos serán números.
            
        if (!oficina.equals(String.valueOf(Integer.parseInt(oficina))))
            throw new IllegalArgumentException("Nº de ofinica incorrecto.");
            //Igual que en el caso anterior.
        
        if (!digitosControl.equals(String.valueOf(Integer.parseInt(digitosControl))))
            throw new IllegalArgumentException("Problema con los dígitos de control.");
            //Igual que en el caso anterior.
        
        if (!numCuenta.equals(String.valueOf(Integer.parseInt(numCuenta))))
            throw new IllegalArgumentException("Número de cuenta no válido.");
            //Igual que en el caso anterior.
        
        this.titular = titular;
        this.entidad = entidad;
        this.oficina = oficina;
        this.digitosControl = digitosControl;
        this.numCuenta = numCuenta;
        this.saldo = 0;
    
    }
    
    /**Método para introducción de titular y Código de cuenta cliente.
     * 
     * @param titular
     * @param CCC 
     */
    
    public CuentaBancaria (String titular, String CCC) {
       if (!comprobarCCC(CCC))
           throw new IllegalArgumentException("Número de cuenta no válido.");
            
    }
    
    
    /**Método para realizar ingresos
     * 
     * @param cantidad 
     */
    public void ingresar(double cantidad) {
        
        if (cantidad >= 0)
            saldo += cantidad;
        
        else
            throw new IllegalArgumentException ("No es posible realizar la operación.");
          
    }
    
    /**Método para retirar ingresos.
     * 
     * @param cantidad 
     */
    
    public void retirar (double cantidad) {
        
            if (cantidad <= saldo)
                saldo -= cantidad;
                
                else 
                    throw new IllegalArgumentException ("No hay saldo disponible.");
    
    }
    
    /**Método para comprobar la validez del CCC tanto por longitud eliminando los guiones o demás caracteres que separen los complejos numéricos como por valor sumatorio total
     * 
     * @param CCC
     * @return 
     */
    public static boolean comprobarCCC(String CCC){
        boolean correcto = false;
        int valor;
        CCC = CCC.trim();
        
        if(CCC.length() == 20) {
            correcto = true;
            for (int i=0;i<CCC.length();i++){
                valor = CCC.charAt(i) - 48;
                if(valor < 0 || valor >10)
                    correcto = false;
            }
        }
        if (correcto){
            return true;
        }else{
            return false;
        }
    }
    
    /**Método para la comprobación de los dígitos de control basándose en los ejemplos expuestos en la wikipedia para los distintos lenguajes.
     * 
     * @param entidad
     * @param oficina
     * @param numCuenta
     * @return 
     */
    
    public static String obtenerDC(String entidad, String oficina, String numCuenta){
        int[] operadores = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6}; //Hago una lista con los operadores que necesitaré más adelante.
        String eo = "00" + entidad + oficina; //entidad y oficina con valores a 00.
        
        String DC; //Declaro la variable DC para los dígitos.
        int digito1 = 0, digito2 = 0; //Declaramos e iniciamos las dos variables de los dígitos de control.
        
        for(int x=0; x<operadores.length;x++){
            digito1 = digito1 + operadores[x]*(eo.charAt(x) - 48);
            digito2 = digito2 + operadores[x]*(eo.charAt(x) - 48);
        }
        digito1 = 11 - (digito1 % 11);
        digito2 = 11 - (digito2 %11);
        
        if (digito1 == 11){
            digito1 = 0;
        }else if(digito1 == 10){
            digito1 = 1;
        }
        
        if (digito2 == 11){
            digito2 = 0;
        }else if(digito2 == 10){
            digito2 = 1;
        }
        DC = String.valueOf(digito1) + String.valueOf(digito2);
        return DC;
                
    }
    
    //Guetters y Setters con las restricciones necesarias.
    
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if (titular.length() > minCaracteres || titular.length() < maxCaracteres) //Comprobamos la logitud de titular.
            this.titular = titular;
        
        else
            throw new IllegalArgumentException ("Nombre no válido.");
    }

    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getDigitosControl() {
        return digitosControl;
    }

    public void setDigitosControl(String digitosControl) {
        this.digitosControl = digitosControl;
    }

    public String getCCC() {
        return CCC;
    }

    public void setCCC(String CCC) {
        this.CCC = CCC;
    }
    
    
    
    /**
     *Método que tras la consulta devuelve el siguiente String.
     * 
     * @return titular + "cuenta corriente:" + numCuenta + "saldo:" + saldo.
     */
    
    public String toString() {
        return titular + "Cuenta corriente: " + numCuenta + " Saldo: " + saldo;
    }
    
    
}
