package labComputacion;
/**
 *
 * @author Chavelys
 */
public class EstudianteProy extends Estudiante {
    private String nombreProy;

    public EstudianteProy(String nombreProy, int annoDoc, String nombre, int solapin) {
        super(annoDoc, nombre, solapin);
        this.nombreProy = nombreProy;
    }   
}
