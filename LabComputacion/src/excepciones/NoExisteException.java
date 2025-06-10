package excepciones;

/**
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class NoExisteException extends Exception {

    /**
     * @param mensaje Descripción detallada del error
     */
    public NoExisteException(String mensaje) {
        super(mensaje);
    }
}