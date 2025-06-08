package labComputacion;

/**
 * Representa un laboratorio de proyectos especializado, que hereda las características
 * de un laboratorio de computación genérico (LocalLab).
 * Está diseñado específicamente para actividades de desarrollo de proyectos,
 * investigación o trabajos prácticos avanzados.
 * 
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class LabProy extends LocalLab {
    /**
     * Construye un nuevo laboratorio de proyectos con la configuración especificada.
     * 
     * @param nombre Nombre identificatorio del laboratorio (ej: "LabProy-A")
     * @param tiempoUso Tiempo máximo de uso continuo permitido (en minutos/horas)
     * @param labor Tipo principal de actividades realizadas (ej: "Desarrollo de Software")
     * @param cantPC Cantidad de computadoras disponibles en el laboratorio
     * @param bitacoraLocal Sistema de registro asociado para monitorear actividades
     */
    public LabProy(String nombre, int tiempoUso, String labor, int cantPC, Bitacora bitacoraLocal) {
        super(nombre, tiempoUso, labor, cantPC, bitacoraLocal);
    }
}