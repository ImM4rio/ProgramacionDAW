package PROG08_Tarea;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.io.*;

/**
 *
 * @author Mario
 */
public class Banco {
    
    //Variables para Banco.
    private HashSet <CuentaBancaria> cuenta;    //Creamos el HashSet cuenta con objetos de CuentaBancaria, escogemos esta estructura ya que no admite duplicados y el orden no es un factor importante. 
    
    
    //Metodo constructor para Banco
    public Banco () {
        this.cuenta = new HashSet();
        
    }

    /**Metodo que recibe como parametro la cadena que conforma el IBAN y comprueba si este ya existe en algun objeto del array
     * 
     * @param IBAN
     * @return String con la informacion de la cuenta
     */
    public String informacionCuenta(String IBAN) {
        Iterator<CuentaBancaria> i = cuenta.iterator();
        //Creamos el iterador "i" que recorrera objetos del tipo CuentaBancaria en el HashSet de cuenta.
        
            while(i.hasNext()){ //mientras que el iterador tenga algo despues.
                CuentaBancaria cuentaTemp = i.next();   //Creamos un contenedor para el objeto devuelto por el iterador en la siguiente posicion a la actual.
                
                    if(cuentaTemp.getIBAN().toUpperCase().matches(IBAN))
                        return cuentaTemp.devolverInfoString();                       
            }    
            
        return null;
    }
           
    
    /**Metodo para devolver el objeto que buscamos por IBAN
     * 
     * @param IBAN
     * @return objeto de tipo CuentaBancaria.
     */
    public CuentaBancaria traerCuenta (String IBAN) {
        Iterator <CuentaBancaria> i = cuenta.iterator();
        
        while(i.hasNext()){
            CuentaBancaria cuentaTemp = i.next();
                if(cuentaTemp.getIBAN().toUpperCase().matches(IBAN))
                    return cuentaTemp;
        }
        
        return null;
        
    }
    
    /**Metodo para buscar la cuenta segun su IBAN
     * 
     * @param IBAN
     * @return boolean si existe o no el objeto.
     */
    public boolean buscarCuenta (String IBAN) {
        Iterator <CuentaBancaria> i = cuenta.iterator();
        
        while(i.hasNext()){
            CuentaBancaria cuentaTemp = i.next();
                if(cuentaTemp.getIBAN().toUpperCase().matches(IBAN))
                    return true;
        }
        
        return false;
        
    }
    
    
    /**Metodo que introduce en el array de objetos de CuentaBancaria una nueva cuenta del tipo que queramos gracias al polimorfismo.
     * 
     * @param nuevaCuenta
     * @return 
     */
    public boolean abrirCuenta (CuentaBancaria nuevaCuenta) {
       
       //Comprobamos si ese IBAN existe ya para otro objeto del array.
       if(informacionCuenta(nuevaCuenta.getIBAN()) == null) { 
            cuenta.add(nuevaCuenta);      
            return true;          
       }
       
       return false;
    }
    
    /**Metodo que devuelve un ArrayList de strings con la informacion de las cuentas.
     * 
     * @return el array con todas las cuentas.
     */
    public ArrayList listarCuentas () {
        //Creamos ArrayList para tener el método add()
        ArrayList <String> listar = new ArrayList();
        
        //Para cada elemento de cuenta introducimos en el ArrayList listar el String devuelto por el metodo devolverInfoString()
        cuenta.forEach(c -> listar.add(c.devolverInfoString()));  
        
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
    
    /**Metodo que elimina el objeto del HashSet que se trae mediante el metodo traerCuenta.
     * 
     * @param IBAN
     * @return 
     */
    public boolean eliminarCuentaBancaria (String IBAN) throws IOException {
        return cuenta.remove(this.traerCuenta(IBAN));
    }
    
    
    /**
     * Metodo para crear y sobreescribir el fichero con la informacion del programa
     * 
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws FileNotFoundException 
     */
    public void escribirFichero() throws ClassNotFoundException, IOException, FileNotFoundException{
        //Declaramos los objetos de clase que vamos a usar.
        FileWriter fichero = null;
        PrintWriter pw = null;
        File datos = null;
        try{
            //Iniciamos la variable de File en un nuevo objeto que creara el archivo en el escritorio windows del ordenador donde se ejecute.
            datos = new File(System.getenv("SYSTEMDRIVE") + System.getenv("HOMEPATH") + "\\Desktop\\datoscuentasbancarias.txt");
            //Iniciamos la variable de FileWriter en un nuevo objeto que genera el stream con el fichero anterior.
            fichero = new FileWriter(System.getenv("SYSTEMDRIVE") + System.getenv("HOMEPATH") + "\\Desktop\\datoscuentasbancarias.txt");
            //Iniciamos la variable de PrintWriter en un nuevo objeto que escribira sobre la ruta especificada para el FileWriter.
            pw = new PrintWriter(fichero);
            //Instanciamos y declaramos una nueva variable para conocer el numero de cuentas.
            int n = 1;
                //Para cada objeto de cuentabancaria dentro del HashSet cuenta...
                for (CuentaBancaria c : cuenta){
                    //En el caso de que sea una instancia de CuentaBancaria.
                    if(c instanceof CuentaBancaria)
                        //Utilizamos el PrintWriter para escribir lo siguiente en el fichero.
                        pw.println(n + "º " + c.getTitular().getNombre() + " " + c.getIBAN());
                        n++;
                }
                    
            
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }finally{
            try{
                //Si el fichero es diferente a null, es decir, si se creo correctamente y se pudo abrir el stream de datos.
                if(fichero != null)
                    /**
                     * Si quisieramos anadir la linea al final del fichero con la info de la cantidad de cuentasbancarias que hay
                     * anadiriamos en esta parte la linea a continuacion.
                     * 
                     * pw.println("Hay un total de " + cuenta.size() + " cuentas en el fichero.");
                     * */
                    //Cerramos el stream
                    fichero.close();
                
            }catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
    
    /**
     * Metodo para leer el fichero externo al programa.
     * 
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws FileNotFoundException 
     */
    public void leerFichero () throws ClassNotFoundException, IOException, FileNotFoundException {
        //Declaramos los objetos de clase que vamos a utilizar.
        FileReader fr = null;
        BufferedReader br = null;
        
        try{
            //Iniciamos el objeto que va a leer con el FileReader en la ruta indicada.
            fr = new FileReader(System.getenv("SYSTEMDRIVE") + System.getenv("HOMEPATH") + "\\Desktop\\datoscuentasbancarias.txt");
            //Iniciamos el BufferedReader para disponer del metodo usado a continuacion.
            br = new BufferedReader(fr);
            
            String contenido;
            //Mientras que el contenido de la linea leida sea diferente a null.
            while((contenido = br.readLine()) != null)
                //Imprimimos por pantalla el contenido.
                System.out.println(contenido);
                System.out.println("------------------------------");
            
            //Cuando el contenido sea igual a null, es decir no haya mas lineas, imprimiremos lo siguente.    
            if(contenido == null)
                System.out.println("Hay un total de " + cuenta.size() + " cuentas en el fichero.");
            
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally {
            if(fr != null)
                fr.close();
        }
        
    }
            
    //Metodos getter y setter.

    public HashSet<CuentaBancaria> getCuenta() {
        return cuenta;
    }

    public void setCuenta(HashSet<CuentaBancaria> cuenta) {
        this.cuenta = cuenta;
    }
    
  
}
