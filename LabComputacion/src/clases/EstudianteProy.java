package clases;

/**
 * Representa un estudiante asociado a un proyecto específico, heredando las
 * características básicas de un Estudiante.
 *
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class EstudianteProy extends Estudiante {

    private String nombreProy;

    /**
     * Construye un nuevo estudiante de proyecto con la información
     * especificada.
     *
     * @param nombreProy Nombre del proyecto de investigación o desarrollo
     * @param annoDoc Año de estudio del estudiante (heredado)
     * @param nombre Nombre completo del estudiante (heredado)
     * @param solapin Número de identificación institucional (heredado)
     */
    public EstudianteProy(String nombreProy, int annoDoc, String nombre, int solapin) {
        super(annoDoc, nombre, solapin);
        this.nombreProy = nombreProy;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + "Nombre Proyecto " + nombreProy + '}';
    }

    /**
     * Obtiene el nombre del proyecto asociado al estudiante.
     *
     * @return Nombre actual del proyecto
     */
    public String getNombreProy() {
        return nombreProy;
    }

    /**
     * Establece un nuevo nombre de proyecto para el estudiante.
     *
     * @param nombreProy Nuevo nombre de proyecto a asignar
     */
    public void setNombreProy(String nombreProy) {
        this.nombreProy = nombreProy;
    }
}
