package labComputacion;

import java.util.ArrayList;

/**
 *
 * @author Chavelys
 */
public class Facultad {

    private ArrayList<Local> locales;
    private ArrayList<Persona> personas;

    public Facultad() {
        this.locales = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    public void addPersona(Persona p) {
        personas.add(p);
    }

    public void addlocal(Local l) {
        locales.add(l);
    }

    public String mejorPorc() {
        double mejorPorc = 0.0;
        String nombre = "";

        for (int i = 1; i < locales.size(); i++) {
            double pa = locales.get(i).getBitacoraLocal().calcPorcAprov(locales.get(i).getTiempoUso());
            if (pa > mejorPorc) {
                mejorPorc = pa;
                nombre = locales.get(i).getNombre();
            }
        }
        return nombre;
    }

    public String peorPorc() {
        double peorPorc = 100.0;
        String nombre = "";

        for (int i = 1; i < locales.size(); i++) {
            double porcAprov = locales.get(i).getBitacoraLocal().calcPorcAprov(locales.get(i).getTiempoUso());
            if (porcAprov < peorPorc) {
                peorPorc = porcAprov;
                nombre = locales.get(i).getNombre();
            }
        }
        return nombre;
    }

    public String buscarInfoPersona(String nombre) {
        String info = "";
        for (int i = 0; i < locales.size(); i++) {
            ArrayList<Persona> personas = locales.get(i).getBitacoraLocal().getPersonas();
            for (int j = 0; j < personas.size(); j++) {
                if (personas.get(j).getNombre().equalsIgnoreCase(nombre)) {
                    info += locales.get(i).toString() + " " + locales.get(i).getBitacoraLocal().calcTiempoPersona(nombre) + " \nComputadoras: \n";
                    ArrayList<Computadora> computadoras = locales.get(i).getComputadoras();
                    for (int k = 0; k < computadoras.size(); k++) {
                        info += computadoras.get(k).toString() + " " + computadoras.get(k).getBitacoraPc().calcTiempoPersona(nombre) + "\n";
                    }
                }
            }
        }
        return info;
    }

    public String buscarPersona() {
        String persona = "";
        int mejorTiempo = 0;
        String finalLocal = "";
        for (int i = 0; i < personas.size(); i++) {
            int tiempo = 0;
            String local = "";
            for (int j = 0; j < locales.size(); j++) {
                int tiempoTrab = (int)locales.get(j).getBitacoraLocal().calcTiempoPersona(personas.get(i).getNombre());
                tiempo += tiempoTrab;    
                if(tiempoTrab > 0){
                    local += locales.get(i).getNombre()+" ";
                }
            }
            if (tiempo > mejorTiempo) {
                mejorTiempo = tiempo;
                persona = personas.get(i).getNombre();
                finalLocal = local;
            }
        }
        return "Nombre de la persona: " + persona + " Tiempo: " + mejorTiempo+" Local: "+finalLocal+ "\n";
    }
}
