package labComputacion;

import java.util.ArrayList;

/**
 *
 * @author Chavelys
 */
public class Facultad {

    private ArrayList<Local> locales;

    public Facultad(ArrayList<Local> locales) {
        this.locales = locales;
    }

    public String mejorPorc(Bitacora bitacora) {
        double mejorPorc = bitacora.calcPorcAprov(0);
        String nombre = "";

        for (int i = 1; i < locales.size(); i++) {
            if (bitacora.calcPorcAprov(i) < mejorPorc) {
                mejorPorc = bitacora.calcPorcAprov(i);
                nombre = locales.get(i).getNombre();
            }
        }
        return nombre;
    }

    public String peorPorc(Bitacora bitacora) {
        double peorPorc = bitacora.calcPorcAprov(0);
        String nombre = "";

        for (int i = 1; i < locales.size(); i++) {
            if (bitacora.calcPorcAprov(i) > peorPorc) {
                peorPorc = bitacora.calcPorcAprov(i);
                nombre = locales.get(i).getNombre();
            }
        }
        return nombre;
    }

    public String buscarPersona(String nombre) {
        String info = "";
        for (int i = 0; i < locales.size(); i++) {
            ArrayList<Persona> personas = locales.get(i).getBitacoraLocal().getPersonas();
            for (int j = 0; j < personas.size(); j++) {
                if (personas.get(j).getNombre().equalsIgnoreCase(nombre)) {
                    info += locales.get(i).toString()+" "+locales.get(i).getBitacoraLocal().calcTiempoPersona(nombre)+" \nComputadoras: \n";
                    ArrayList<Computadora> computadoras = locales.get(i).getComputadoras();
                    for (int k = 0; k < computadoras.size(); k++) {
                        info += computadoras.get(k).toString()+" "+computadoras.get(k).getBitacoraPc().calcTiempoPersona(nombre)+"\n";
                    }
                }
            }
        }
        return info;
    }
}
