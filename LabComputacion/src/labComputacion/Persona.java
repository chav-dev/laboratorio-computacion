package labComputacion;

/**
 *
 * @author Chavelys
 */
public abstract class Persona {
    protected String nombre;
    protected int solapin;

    public Persona(String nombre, int solapin) {
        this.nombre = nombre;
        this.solapin = solapin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSolapin() {
        return solapin;
    }

    public void setSolapin(int solapin) {
        this.solapin = solapin;
    }
}
