package clases;

/**
 * Clase que representa un Local de Colectivo de Investigación.
 * Hereda de la clase Local y representa un espacio específico para actividades de investigación colectiva con equipos informáticos.
 * 
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class LocalColectInvest extends Local {
    
    /**
     * Constructor para crear un Local de Colectivo de Investigación.
     * 
     * @param nombre Nombre identificativo del local
     * @param tiempoUso Tiempo de uso estimado del local (en horas)
     * @param labor Tipo de labor que se realiza en el local
     * @param cantPC Cantidad de computadoras disponibles en el local
     * @param bitacoraLocal Bitácora asociada al local para registro de actividades
     */
    public LocalColectInvest(String nombre, int tiempoUso, String labor, int cantPC, Bitacora bitacoraLocal) {
        super(nombre, tiempoUso, labor, cantPC, bitacoraLocal);
    }

    public LocalColectInvest(String nombre, int tiempoUso, String labor, int cantPC) {
        super(nombre, tiempoUso, labor, cantPC);
    }
    
    
}