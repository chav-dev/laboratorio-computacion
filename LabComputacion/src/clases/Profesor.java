package clases;

/**
 * Representa un profesor que hereda de la clase Persona.
 * Además de los atributos básicos de una persona, incluye información sobre la asignatura que imparte.
 * 
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class Profesor extends Persona{
    private String asignatura; 
    
    /**
     * Constructor para crear una instancia de Profesor.
     * 
     * @param asignatura Nombre de la asignatura que imparte el profesor
     * @param nombre Nombre completo del profesor
     * @param solapin Número de identificación institucional (solapín)
     */
    public Profesor(String asignatura, String nombre, int solapin) {
        super(nombre, solapin);
        this.asignatura = asignatura;
    }

    /**
     * Obtiene la asignatura que imparte el profesor.
     * 
     * @return Nombre de la asignatura actual
     */
    public String getAsignatura() {
        return asignatura;
    }

    /**
     * Establece/actualiza la asignatura que imparte el profesor.
     * 
     * @param asignatura Nuevo nombre de asignatura a asignar
     */
    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
}