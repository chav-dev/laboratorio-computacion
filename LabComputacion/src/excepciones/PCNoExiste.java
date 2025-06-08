package excepciones;

/**
 * Excepción personalizada que se lanza cuando se intenta acceder a una computadora
 * que no existe en el sistema o no está registrada. Esta excepción proporciona
 * mensajes personalizados para facilitar la identificación del error.
 * 
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class PcNoExiste extends Exception {

    /**
     * Construye una nueva excepción con un mensaje detallado que describe
     * el problema específico de la computadora inexistente.
     * 
     * @param mensaje Descripción detallada del error (ej: "La PC con ID 25 no existe")
     */
    public PcNoExiste(String mensaje) {
        super(mensaje);
    }
}