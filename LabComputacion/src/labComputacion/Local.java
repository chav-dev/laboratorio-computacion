package labComputacion;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Chavelys
 */
public class Local {
    protected String nombre;
    protected Date tiempoUso;
    protected String labor;
    protected int cantPC;
    protected ArrayList<Computadora> computadoras;

    public Local(String nombre, Date tiempoUso, String labor, int cantPC) {
        this.nombre = nombre;
        this.tiempoUso = tiempoUso;
        this.labor = labor;
        this.cantPC = cantPC;
        computadoras = new ArrayList<>();
    }

    public Local(String nombre, Date tiempoUso, String labor, int cantPC, ArrayList<Computadora> computadoras) {
        this.nombre = nombre;
        this.tiempoUso = tiempoUso;
        this.labor = labor;
        this.cantPC = cantPC;
        this.computadoras = computadoras;
    }
    
    public Date calcTiempoUso(){
        for (int i = 0; i < computadoras.size(); i++) {
            computadoras.get(i)
        }
    }

    @Override
    public String toString() {
        return "Local{" + "nombre=" + nombre + ", tiempoUso=" + tiempoUso + ", labor=" + labor + ", cantPC=" + cantPC + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getTiempoUso() {
        return tiempoUso;
    }

    public void setTiempoUso(Date tiempoUso) {
        this.tiempoUso = tiempoUso;
    }

    public String getLabor() {
        return labor;
    }

    public void setLabor(String labor) {
        this.labor = labor;
    }

    public int getCantPC() {
        return cantPC;
    }

    public void setCantPC(int cantPC) {
        this.cantPC = cantPC;
    }
    
    
}
