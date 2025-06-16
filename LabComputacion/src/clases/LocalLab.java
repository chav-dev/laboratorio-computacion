package clases;

/**
 * Representa un laboratorio de computación como tipo especializado de local.
 * Esta clase abstracta hereda las características básicas de un local y define funcionalidades específicas para laboratorios de computación.
 * 
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public abstract class LocalLab extends Local {
    /**
     * Construye una nueva instancia de laboratorio de computación.
     * 
     * @param nombre Nombre identificatorio del laboratorio
     * @param tiempoUso Tiempo máximo de uso permitido (en horas/minutos)
     * @param labor Tipo de actividad principal que se realiza en el laboratorio
     * @param cantPC Cantidad de computadoras disponibles en el laboratorio
     * @param bitacoraLocal Bitácora asociada para registrar actividades del laboratorio
     */
    public LocalLab(String nombre, int tiempoUso, String labor, int cantPC, Bitacora bitacoraLocal) {
        super(nombre, tiempoUso, labor, cantPC, bitacoraLocal);
    }
    
    public LocalLab(String nombre, int tiempoUso, String labor, int cantPC) {
        super(nombre, tiempoUso, labor, cantPC);
    }
}