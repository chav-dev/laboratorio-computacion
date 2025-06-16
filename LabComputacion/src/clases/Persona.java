package clases;

import java.io.Serializable;

/**
 * Clase abstracta que representa a una persona en el sistema.
 * Contiene información básica común a todas las personas como nombre y número de solapín.
 * Esta clase está diseñada para ser extendida por clases más específicas (Profesor y Estudiante).
 * 
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public abstract class Persona implements Serializable{
    protected String nombre;
    protected int solapin;

    /**
     * Constructor para inicializar una instancia de Persona.
     * 
     * @param nombre Nombre completo de la persona
     * @param solapin Número de identificación institucional
     */
    public Persona(String nombre, int solapin) {
        this.nombre = nombre;
        this.solapin = solapin;
    }

    @Override
    public String toString() {
        return "Persona: " + "Nombre " + nombre + ", Solapin " + solapin;
    }

    /**
     * Obtiene el nombre de la persona.
     * 
     * @return Nombre actual de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece o actualiza el nombre de la persona.
     * 
     * @param nombre Nuevo nombre a asignar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de solapín de la persona.
     * 
     * @return Número de identificación institucional actual
     */
    public int getSolapin() {
        return solapin;
    }

    /**
     * Establece o actualiza el número de solapín de la persona.
     * 
     * @param solapin Nuevo número de identificación institucional
     */
    public void setSolapin(int solapin) {
        this.solapin = solapin;
    }
}