package labComputacion;

/**
 *
 * @author Chavelys
 */
public abstract class LocalLab extends Local {
    public LocalLab(String nombre, int tiempoUso, String labor, int cantPC, Bitacora bitacoraLocal) {
        super(nombre, tiempoUso, labor, cantPC, bitacoraLocal);
    }
}
