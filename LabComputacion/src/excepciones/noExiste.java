package excepciones;

/**
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class noExiste extends Exception {

    /**
     * @param mensaje Descripción detallada del error
     */
    public noExiste(String mensaje) {
        super(mensaje);
    }
}