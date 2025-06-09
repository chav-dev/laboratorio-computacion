package labComputacion;

/**
 * Representa a un estudiante en el sistema, heredando las propiedades básicas
 * de una Persona. Esta clase añade información específica sobre el año académico
 * en que se encuentra el estudiante.
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
     * @param annoDoc Año académico actual del estudiante (debe ser un valor positivo)
     * @param nombre Nombre completo del estudiante
     * @param solapin Número de identificación institucional
     */
    public Estudiante(int annoDoc, String nombre, int solapin) {
        super(nombre, solapin);
        this.annoDoc = annoDoc;
    }

    /**
     * Obtiene el año académico actual del estudiante.
     * 
     * @return Número representando el año de estudio (ej: 1, 2, 3)
     */
    public int getAnnoDoc() {
        return annoDoc;
    }

    /**
     * Establece o actualiza el año académico del estudiante.
     * 
     * @param annoDoc Nuevo año académico a asignar (debe ser un valor positivo)
     */
    public void setAnnoDoc(int annoDoc) {
        this.annoDoc = annoDoc;
    }
}