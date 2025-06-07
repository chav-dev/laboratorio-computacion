package labComputacion;

import java.util.ArrayList;
import excepciones.*;

/**
 *
 * @author Chavelys
 */
public abstract class Local {
    protected String nombre;
    protected int tiempoUso;
    protected String labor;
    protected int cantPc;
    protected ArrayList<Computadora> computadoras;
    protected Bitacora bitacoraLocal;

    public Local(String nombre, int tiempoUso, String labor, int cantPc, Bitacora bitacoraLocal) {
        this.nombre = nombre;
        this.tiempoUso = tiempoUso;
        this.labor = labor;
        this.cantPc = cantPc;
        this.computadoras = new ArrayList<>();
        this.bitacoraLocal = bitacoraLocal;
    }

    public void addPC(Computadora c) throws PcExiste {
        for (int i = 0; i < computadoras.size(); i++) {
            if (computadoras.get(i).getNumero() == c.getNumero()) {
                throw new PcExiste("Ya existe.");
            }
        }
        computadoras.add(c);
    }

    public void deletePC(int num) throws PcNoExiste {
        boolean existe = false;
        for (int i = 0; i < computadoras.size(); i++) {
            if (computadoras.get(i).getNumero() == num) {
                computadoras.remove(i);
                existe = true;
                break;
            }
        }
        if (!existe) {
            throw new PcNoExiste("Esa computadora no existe.");
        }
    }

    public ArrayList<Computadora> pcRotas(){
        ArrayList<Computadora> pcRotas = new ArrayList<>();
        for (int i = 0; i < computadoras.size(); i++) {
            if(computadoras.get(i).getEstado().equals("Rota")){
                pcRotas.add(computadoras.get(i));
            }
        }
        return pcRotas;
    }
    
    public int cantPcRota() {
        return pcRotas().size();
    }

    public int cantPcOcupada() {
        int countOcupada = 0;
        for (int i = 0; i < computadoras.size(); i++) {
            if (computadoras.get(i).getEstado().equalsIgnoreCase("Ocupada")) {
                countOcupada++;
            }
        }
        return countOcupada;
    }

    public int cantPcLibre() {
        int countLibre = 0;
        for (int i = 0; i < computadoras.size(); i++) {
            if (computadoras.get(i).getEstado().equalsIgnoreCase("Libre")) {
                countLibre++;
            }
        }
        return countLibre;
    } 
    
    public String buscarpersona(String nombre){
        int nroPc = 0;
        String tipoLocal = "";
        double tiempo = 0;
        String name= "";
        
        for(int i = 0; i < computadoras.size(); i++){
            Bitacora bitacora = computadoras.get(i).getBitacoraPc();
            for(int j = 0; j < bitacora.getPersonas().size(); j++){
                if(bitacora.getPersonas().get(i).getNombre().equals(nombre)){
                    name = bitacora.getPersonas().get(i).getNombre();
                    nroPc = computadoras.get(i).getNumero();
                    tipoLocal = "" + computadoras.get(i).getTipoLocal();
                    tiempo = bitacora.calcTiempoUso();
                }
            }
        }
        return "Nombre: " +name+ ", Local: " +tipoLocal+ ", nroPc: " +nroPc+ ", Tiempo: " +tiempo;
    }

    @Override
    public String toString() {
        return "Local{" + "nombre=" + nombre + ", tiempoUso=" + tiempoUso + ", labor=" + labor + ", cantPC=" + cantPc + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoUso() {
        return tiempoUso;
    }

    public void setTiempoUso(int tiempoUso) {
        this.tiempoUso = tiempoUso;
    }

    public String getLabor() {
        return labor;
    }

    public void setLabor(String labor) {
        this.labor = labor;
    }

    public int getCantPc() {
        return cantPc;
    }

    public void setCantPC(int cantPc) {
        this.cantPc = cantPc;
    }
}
