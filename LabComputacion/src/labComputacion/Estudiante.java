package labComputacion;
/**
 *
 * @author Chavelys
 */
public class Estudiante extends Persona {
    protected int annoDoc;

    public Estudiante(int annoDoc, String nombre, int solapin) {
        super(nombre, solapin);
        this.annoDoc = annoDoc;
    }

    public int getAnnoDoc() {
        return annoDoc;
    }

    public void setAnnoDoc(int annoDoc) {
        this.annoDoc = annoDoc;
    }
}
