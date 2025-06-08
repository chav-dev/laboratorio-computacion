package excepciones;

/**
 * Excepción personalizada que se lanza cuando se intenta registrar o crear una computadora
 * que ya existe en el sistema. Esta excepción ayuda a prevenir duplicados en el registro
 * de equipos informáticos.
 * 
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class PcExiste extends Exception {

    /**
     * Construye una nueva excepción con un mensaje detallado que especifica
     * la computadora que ya existe en el sistema.
     * 
     * @param mensaje Descripción detallada del error (ej: "La PC con ID 42 ya está registrada")
     */
    public PcExiste(String mensaje) {
        super(mensaje);
    }
}