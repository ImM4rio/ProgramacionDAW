package EjercicioA;

public class Persona {

    //Atributos de clase.
    private String nombre;
    private int edad;
    private float altura;

    public Persona() {//define características comunes a la clase--> public nombre_clase(){código};
        nombre = "Luisa Pérez";
        edad = 22;
        altura = 1.70f;
    }

    public Persona(String nombre, int edad, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    
    
    //Getters o captadores --> public dato_a_devolver nombre_método(){código};
    String getNombre() {
        return nombre;
    }

    int getEdad() {
        return edad;
    }

    float getAltura() {
        return altura;
    }

    
    //Setters o definidores --> public void nombre_metodo(){código};
    void setNombre(String nom) {
        this.nombre = nom;
    }

    void setEdad(int edad) {
        this.edad = edad;
    }

    void setAltura(float altura) {
        this.altura = altura;
    }


}
