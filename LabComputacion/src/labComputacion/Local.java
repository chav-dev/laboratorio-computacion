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
    protected int cantPC;
    protected ArrayList<Computadora> computadoras;
    protected Bitacora bitacoraLocal;

    public Local(String nombre, int tiempoUso, String labor, int cantPC, Bitacora bitacoraLocal) {
        this.nombre = nombre;
        this.tiempoUso = tiempoUso;
        this.labor = labor;
        this.cantPC = cantPC;
        this.computadoras = new ArrayList<>();;
        this.bitacoraLocal = bitacoraLocal;
    }

//    public String mostrarBitacora(){
//        String bitacora = "";
//        for (int i = 0; i < computadoras.size(); i++) {
//            bitacora += (i+1)+computadoras.get(i).mostrarBitacora();
//        }
//        System.out.println(bitacora);
//        return bitacora;
//    }
    public void addPC(Computadora c) throws PCExiste {
        for (int i = 0; i < computadoras.size(); i++) {
            if (computadoras.get(i).getNumero() == c.getNumero()) {
                throw new PCExiste("Ya existe.");
            }
        }
        computadoras.add(c);
    }

    public void deletePC(int num) throws PCNoExiste {
        boolean existe = false;
        for (int i = 0; i < computadoras.size(); i++) {
            if (computadoras.get(i).getNumero() == num) {
                computadoras.remove(i);
                existe = true;
                break;
            }
        }
        if (!existe) {
            throw new PCNoExiste("Esa computadora no existe.");
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
    
    public int calcPCRota() {
        return pcRotas().size();
    }

    public int calcPCOcupada() {
        int countOcupada = 0;
        for (int i = 0; i < computadoras.size(); i++) {
            if (computadoras.get(i).getEstado().equalsIgnoreCase("Ocupada")) {
                countOcupada++;
            }
        }
        return countOcupada;
    }

    public int calcPCLibre() {
        int countLibre = 0;
        for (int i = 0; i < computadoras.size(); i++) {
            if (computadoras.get(i).getEstado().equalsIgnoreCase("Libre")) {
                countLibre++;
            }
        }
        return countLibre;
    }

//    public Duration calcTiempoUsoLocal() {
//        ArrayList<AbstractMap.SimpleEntry<LocalTime, LocalTime>> times = new ArrayList<>();
//        for (Computadora c : computadoras) {
//            ArrayList<LocalTime> ini = c.getFechaInicio();
//            ArrayList<LocalTime> fin = c.getFechaFin();
//
//            for (int i = 0; i < fin.size(); i++) {
//                LocalTime start = ini.get(i);
//                LocalTime end = fin.get(i);
//                times.add(new SimpleEntry(start, end));
//            }
//        }
//
//        times.sort(new Comparator<SimpleEntry<LocalTime, LocalTime>>() {
//            public int compare(SimpleEntry<LocalTime, LocalTime> o1, SimpleEntry<LocalTime, LocalTime> o2) {
//                if (o1.getKey().compareTo(o2.getKey()) == 0) {
//                    return o1.getValue().compareTo(o2.getValue());
//                } else {
//                    return o1.getKey().compareTo(o2.getKey());
//                }
//            }
//        });
//
//        Duration solve = Duration.ZERO;
//
//        if (times.size() > 0) {
//            LocalTime init = times.get(0).getKey();
//            LocalTime fint = times.get(0).getValue();
//
//            for (int i = 1; i < times.size(); i++) {
//                if (fint.isBefore(times.get(i).getKey())) {
//                    solve = solve.plus(Duration.between(init, fint));
//                    fint = times.get(i).getValue();
//                    init = times.get(i).getKey();
//                } else {
//                    if (fint.isBefore(times.get(i).getValue())) {
//                        fint = times.get(i).getValue();
//                    }
//                }
//            }
//        }
//
//        return solve;
//    }

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

    public int getCantPC() {
        return cantPC;
    }

    public void setCantPC(int cantPC) {
        this.cantPC = cantPC;
    }
}
