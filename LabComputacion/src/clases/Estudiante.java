package clases;

/**
 * Representa a un estudiante en el sistema, heredando las propiedades básicas de una Persona. 
 * 
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class Estudiante extends Persona {
    protected int annoDoc;

    /**
     * Construye una nueva instancia de Estudiante con la información especificada.
     * 
     * @param annoDoc Año académico actual del estudiante
     * @param nombre Nombre completo del estudiante
     * @param solapin Número de identificación institucional
     */
    public Estudiante(int annoDoc, String nombre, int solapin) {
        super(nombre, solapin);
        this.annoDoc = annoDoc;
    }

    /**
     * Representación en cadena del estudiante con formato legible.
     *
     * @return Cadena con la información básica del estudiante
     */
    @Override
    public String toString() {
        return super.toString() + ", " + "Año Docente " + annoDoc;
    }

    /**
     * Obtiene el año académico actual del estudiante.
     * 
     * @return Número representando el año de estudio
     */
    public int getAnnoDoc() {
        return annoDoc;
    }

    /**
     * Establece o actualiza el año académico del estudiante.
     * 
     * @param annoDoc Nuevo año académico a asignar
     */
    public void setAnnoDoc(int annoDoc) {
        this.annoDoc = annoDoc;
    }
}