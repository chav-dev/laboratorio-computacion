package clases;

/**
 * Representa un laboratorio docente especializado, heredando las características de un laboratorio de computación genérico (LocalLab).
 * Diseñado específicamente para actividades académicas, docencia y prácticas estudiantiles.
 * 
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class LabDoc extends LocalLab {
    
    /**
     * Construye un nuevo laboratorio docente con la configuración especificada.
     * 
     * @param nombre Nombre identificatorio del laboratorio
     * @param tiempoUso Tiempo máximo de sesión continua permitida 
     * @param labor Tipo principal de actividades académicas
     * @param cantPC Cantidad de computadoras disponibles para estudiantes
     * @param bitacoraLocal Sistema de registro asociado para seguimiento académico
     */
    public LabDoc(String nombre, int tiempoUso, String labor, int cantPC, Bitacora bitacoraLocal) {
        super(nombre, tiempoUso, labor, cantPC, bitacoraLocal);
    }
}