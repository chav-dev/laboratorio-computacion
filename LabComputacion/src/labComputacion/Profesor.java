package labComputacion;

/**
 *
 * @author Chavelys
 */
public class Profesor extends Persona{
    private String asignatura;

    public Profesor(String asignatura, String nombre, int solapin) {
        super(nombre, solapin);
        this.asignatura = asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
}
