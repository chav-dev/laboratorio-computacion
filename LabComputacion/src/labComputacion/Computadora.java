package labComputacion;

/**
 * Representa una computadora física en el sistema de gestión de laboratorios.
 * Mantiene información sobre su estado, número de identificación
 * y su bitácora asociada para registrar actividades.
 *
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class Computadora {
    private String estado; //Ocupada, Libre o Rota
    private int numero;
    private Bitacora bitacoraPc;
    
    /**
     * Construye una nueva instancia de Computadora con la configuración
     * especificada.
     *
     * @param estado Estado inicial de la computadora
     * @param numero Número identificatorio único dentro del local
     * @param bitacoraPc Bitácora asociada para registro de actividades
     */
    public Computadora(String estado, int numero, Local l1, Bitacora bitacoraPc) {
        this.estado = estado;
        this.numero = numero;
        this.bitacoraPc = bitacoraPc;
    }

    /**
     * Representación en cadena de la computadora con formato legible.
     *
     * @return Cadena con la información básica de la computadora
     */
    @Override
    public String toString() {
        return "Computadora{" + "estado=" + estado + ", numero=" + numero + '}';
    }

    // Métodos de acceso (getters y setters)
    /**
     * Obtiene el estado actual de la computadora.
     *
     * @return Estado actual (ej: "Ocupada", "Libre" o "Rota")
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece o actualiza el estado de la computadora.
     *
     * @param estado Nuevo estado a asignar
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el número identificatorio de la computadora.
     *
     * @return Número único dentro del local
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece o actualiza el número identificatorio de la computadora.
     *
     * @param numero Nuevo número a asignar (debe ser único en su local)
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtiene la bitácora asociada a esta computadora.
     *
     * @return Instancia de Bitacora con los registros de actividad
     */
    public Bitacora getBitacoraPc() {
        return bitacoraPc;
    }

    /**
     * Establece o actualiza la bitácora asociada a esta computadora.
     *
     * @param bitacoraPc Nueva bitácora a asignar
     */
    public void setBitacoraPc(Bitacora bitacoraPc) {
        this.bitacoraPc = bitacoraPc;
    }
}
