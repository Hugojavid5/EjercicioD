package Model;

import java.util.Objects;

/**
 * La clase Persona representa una persona con nombre, apellidos y edad.
 * Proporciona métodos para acceder y modificar estos atributos.
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;

    /**
     * Constructor de la clase Persona.
     * @param nom      El nombre de la persona.
     * @param apellidos Los apellidos de la persona.
     * @param edad     La edad de la persona.
     */
    public Persona(String nom, String apellidos, int edad) {
        this.nombre = nom;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    /**
     * Obtiene el nombre de la persona.
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos de la persona.
     * @return Los apellidos de la persona.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos de la persona.
     * @param apellidos Los nuevos apellidos de la persona.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene la edad de la persona.
     * @return La edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad de la persona.
     * @param edad La nueva edad de la persona.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Compara este objeto Persona con otro para verificar si son iguales.
     * Dos objetos Persona se consideran iguales si tienen el mismo contenido de los atributos.
     * @param o El objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return edad == persona.edad && Objects.equals(nombre, persona.nombre) && Objects.equals(apellidos, persona.apellidos);
    }

    /**
     * Devuelve un código hash basado en los atributos nombre, apellidos y edad.
     * @return El código hash para este objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash( apellidos, edad);
    }
}
