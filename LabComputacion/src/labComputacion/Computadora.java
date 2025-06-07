package labComputacion;

import java.util.ArrayList;

/**
 *
 * @author Chavelys
 */
public class Computadora {
    private String estado;
    private int numero;
    private Bitacora bitacoraPc;
    private Local tipoLocal;

    public Computadora(String estado, int numero, Local tipoLocal, Bitacora bitacoraPc) {
        this.estado = estado;
        this.numero = numero;
        this.tipoLocal = tipoLocal;
        this.bitacoraPc = bitacoraPc;
    }
    
    @Override
    public String toString() {
        return "Computadora{" + "estado=" + estado + ", numero=" + numero + ", tipoLocal=" + tipoLocal + '}';
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Bitacora getBitacoraPc () {
        return bitacoraPc;
    }

    public void setBitacoraPc(Bitacora bitacoraPc) {
        this.bitacoraPc = bitacoraPc;
    }

    public Local getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(Local tipoLocal) {
        this.tipoLocal = tipoLocal;
    }
}
