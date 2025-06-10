package excepciones;

/**
 * 
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class ExisteException extends Exception {

    /**
     * @param mensaje Descripción detallada del error
     */
    public ExisteException(String mensaje) {
        super(mensaje);
    }
}