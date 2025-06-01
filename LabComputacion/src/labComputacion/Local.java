package labComputacion;

import java.util.ArrayList;
import java.time.*;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
/**
 *
 * @author Chavelys
 */
public class Local {
    protected String nombre;
    protected Duration tiempoUso;
    protected String labor;
    protected int cantPC;
    protected ArrayList<Computadora> computadoras;

    public Local(String nombre, Duration tiempoUso, String labor, int cantPC) {
        this.nombre = nombre;
        this.tiempoUso = tiempoUso;
        this.labor = labor;
        this.cantPC = cantPC;
        computadoras = new ArrayList<>();
    }

    public Local(String nombre, Duration tiempoUso, String labor, int cantPC, ArrayList<Computadora> computadoras) {
        this.nombre = nombre;
        this.tiempoUso = tiempoUso;
        this.labor = labor;
        this.cantPC = cantPC;
        this.computadoras = computadoras;
    }
    
    public String mostrarBitacora(){
        String bitacora = "";
        for (int i = 0; i < computadoras.size(); i++) {
            bitacora += (i+1)+computadoras.get(i).mostrarBitacora();
        }
        System.out.println(bitacora);
        return bitacora;
    }
    
    public int calcPCRota(){
        int countRota = 0;
        for (int i = 0; i < computadoras.size(); i++) {
            if(computadoras.get(i).getEstado().equalsIgnoreCase("Rota")){
                countRota++;
            }
        }
        return countRota;
    }
    
    public int calcPCOcupada(){
        int countOcupada = 0;
        for (int i = 0; i < computadoras.size(); i++) {
            if(computadoras.get(i).getEstado().equalsIgnoreCase("Ocupada")){
                countOcupada++;
            }
        }
        return countOcupada;
    }
    
    public int calcPCLibre(){
        int countLibre = 0;
        for (int i = 0; i < computadoras.size(); i++) {
            if(computadoras.get(i).getEstado().equalsIgnoreCase("Libre")){
                countLibre++;
            }
        }
        return countLibre;
    }
    
    public Duration calcTiempoUsoLocal(){
        ArrayList<AbstractMap.SimpleEntry<LocalTime, LocalTime>> times = new ArrayList<>();
        for (Computadora c: computadoras) {
            ArrayList<LocalTime>ini = c.getFechaInicio();
            ArrayList<LocalTime>fin = c.getFechaFin();
            
            for (int i = 0; i < fin.size(); i++) {
                LocalTime start = ini.get(i);
                LocalTime end = fin.get(i);
                times.add(new SimpleEntry(start, end));
            }
        }
        
        times.sort(new Comparator<SimpleEntry<LocalTime, LocalTime>>() {
            public int compare(SimpleEntry<LocalTime, LocalTime> o1, SimpleEntry<LocalTime, LocalTime> o2) {
                if(o1.getKey().compareTo(o2.getKey()) == 0){
                    return o1.getValue().compareTo(o2.getValue());
                }else{
                   return o1.getKey().compareTo(o2.getKey()); 
                }
            }
        });
        
        Duration solve = Duration.ZERO;
        
        if(times.size()>0){
            LocalTime init = times.get(0).getKey();
            LocalTime fint = times.get(0).getValue();
       
            for(int i=1;i<times.size();i++){
                if(fint.isBefore(times.get(i).getKey())){
                    solve = solve.plus(Duration.between(init, fint));
                    fint = times.get(i).getValue();
                    init = times.get(i).getKey();
                }else{
                    if(fint.isBefore(times.get(i).getValue())){
                        fint = times.get(i).getValue();
                    }
                }
            }
        }
        
        return solve;
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

    public Duration getTiempoUso() {
        return tiempoUso;
    }

    public void setTiempoUso(Duration tiempoUso) {
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
