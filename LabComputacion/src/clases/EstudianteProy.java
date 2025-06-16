package clases;

/**
 * Representa un estudiante asociado a un proyecto específico, heredando las características básicas de un Estudiante.
 * 
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class EstudianteProy extends Estudiante {
    private String nombreProy;

    /**
     * Construye un nuevo estudiante de proyecto con la información especificada.
     * 
     * @param nombreProy Nombre del proyecto de investigación o desarrollo
     * @param annoDoc Año de estudio del estudiante
     * @param nombre Nombre completo del estudiante
     * @param solapin Número de identificación institucional
     */
    public EstudianteProy(String nombreProy, int annoDoc, String nombre, int solapin) {
        super(annoDoc, nombre, solapin);
        this.nombreProy = nombreProy;
    }

    public String getNombreProy() {
        return nombreProy;
    }

    public void setNombreProy(String nombreProy) {
        this.nombreProy = nombreProy;
    }
    
    
}