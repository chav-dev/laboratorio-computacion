package excepciones;

/**
 * Excepción lanzada cuando no hay una computadora (PC) disponible para realizar una operación.
 * 
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class PCNoDisponibleException extends Exception{

    /**
     * Construye una nueva excepción con un mensaje de error específico.
     * 
     * @param m El mensaje que describe el motivo de la excepción. 
     */
    public PCNoDisponibleException(String m) {
        super(m);
    }
}
