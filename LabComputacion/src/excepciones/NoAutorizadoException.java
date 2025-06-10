package excepciones;

/**
 * Excepción lanzada cuando se intenta realizar una operación sin la autorización necesaria.
 * Esta excepción extiende de la clase Exception, lo que la convierte en una excepción comprobada.
 * 
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class NoAutorizadoException extends Exception{

    /**
     * Construye una nueva excepción de autorización con el mensaje de detalle especificado.
     * 
     * @param m el mensaje de detalle que describe la razón de la excepción.
     *          El mensaje se almacena para posterior recuperación a través del método getMessage().
     */
    public NoAutorizadoException(String m) {
        super(m);
    }
}
