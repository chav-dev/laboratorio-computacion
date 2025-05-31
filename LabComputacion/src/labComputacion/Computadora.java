package labComputacion;

/**
 *
 * @author Chavelys
 */
public class Computadora {
    private String estado;
    private int numero;

    public Computadora(String estado, int numero) {
        this.estado = estado;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Computadora{" + "estado=" + estado + ", numero=" + numero + '}';
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
}
