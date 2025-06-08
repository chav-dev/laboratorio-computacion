package labComputacion;

import java.util.ArrayList;

/**
 * Clase que representa una facultad, gestionando locales y personas.
 * Proporciona funcionalidades para analizar el uso de recursos computacionales.
 * 
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class Facultad {

    private ArrayList<Local> locales;   
    private ArrayList<Persona> personas;

    /**
     * Constructor por defecto que inicializa las listas vacías.
     */
    public Facultad() {
        this.locales = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    /**
     * Agrega una persona a la lista de la facultad.
     * 
     * @param p Objeto Persona a agregar
     */
    public void addPersona(Persona p) {
        personas.add(p);
    }

    /**
     * Agrega un local a la lista de la facultad.
     * 
     * @param l Objeto Local a agregar
     */
    public void addlocal(Local l) {
        locales.add(l);
    }

    /**
     * Encuentra el local con el mejor porcentaje de aprovechamiento.
     * 
     * @return Nombre del local con mejor porcentaje
     */
    public String mejorPorc() {
        double mejorPorc = 0.0;
        String nombre = "";

        for (int i = 0; i < locales.size(); i++) {
            double pa = locales.get(i).getBitacoraLocal().calcPorcAprov(locales.get(i).getTiempoUso());
            if (pa > mejorPorc) {
                mejorPorc = pa;
                nombre = locales.get(i).getNombre();
            }
        }
        return nombre;
    }

    /**
     * Encuentra el local con el peor porcentaje de aprovechamiento.
     * 
     * @return Nombre del local con peor porcentaje
     */
    public String peorPorc() {
        double peorPorc = 100.0;
        String nombre = "";

        for (int i = 0; i < locales.size(); i++) {
            double porcAprov = locales.get(i).getBitacoraLocal().calcPorcAprov(locales.get(i).getTiempoUso());
            if (porcAprov < peorPorc) {
                peorPorc = porcAprov;
                nombre = locales.get(i).getNombre();
            }
        }
        return nombre;
    }

    /**
     * Busca información detallada de una persona en todos los locales.
     * 
     * @param nombre Nombre de la persona a buscar (no sensible a mayúsculas)
     * @return String con información de locales, tiempo y computadoras usadas
     */
    public String buscarInfoPersona(String nombre) {
        String info = "";
        for (int i = 0; i < locales.size(); i++) {
            ArrayList<Persona> personas = locales.get(i).getBitacoraLocal().getPersonas();
            for (int j = 0; j < personas.size(); j++) {
                if (personas.get(j).getNombre().equalsIgnoreCase(nombre)) {
                    // Agrega información del local y tiempo total de uso
                    info += locales.get(i).toString() + " " + 
                            locales.get(i).getBitacoraLocal().calcTiempoPersona(nombre) + 
                            " \nComputadoras: \n";
                    
                    // Agrega información de computadoras específicas usadas
                    ArrayList<Computadora> computadoras = locales.get(i).getComputadoras();
                    for (int k = 0; k < computadoras.size(); k++) {
                        info += computadoras.get(k).toString() + " " + 
                                computadoras.get(k).getBitacoraPc().calcTiempoPersona(nombre) + "\n";
                    }
                }
            }
        }
        return info;
    }

    /**
     * Encuentra la persona con mayor tiempo acumulado en todos los locales.
     * 
     * @return String con nombre de la persona, tiempo total y locales visitados
     */
    public String buscarPersona() {
        String persona = "";
        int mejorTiempo = 0;
        String finalLocal = "";
        
        for (int i = 0; i < personas.size(); i++) {
            int tiempo = 0;
            String local = "";
            
            for (int j = 0; j < locales.size(); j++) {
                int tiempoTrab = (int) locales.get(j).getBitacoraLocal().calcTiempoPersona(personas.get(i).getNombre());
                tiempo += tiempoTrab;    
                
                if(tiempoTrab > 0){
                    local += locales.get(j).getNombre() + " ";
                }
            }
            
            if (tiempo > mejorTiempo) {
                mejorTiempo = tiempo;
                persona = personas.get(i).getNombre();
                finalLocal = local;
            }
        }
        return "Nombre de la persona: " + persona + 
               " Tiempo: " + mejorTiempo + 
               " Locales: " + finalLocal + "\n";
    }

    /**
     * Obtiene la lista completa de locales.
     * 
     * @return ArrayList de objetos Local
     */
    public ArrayList<Local> getLocales() {
        return locales;
    }

    /**
     * Reemplaza la lista actual de locales.
     * 
     * @param locales Nueva lista de locales
     */
    public void setLocales(ArrayList<Local> locales) {
        this.locales = locales;
    }

    /**
     * Obtiene la lista completa de personas registradas.
     * 
     * @return ArrayList de objetos Persona
     */
    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    /**
     * Reemplaza la lista actual de personas.
     * 
     * @param personas Nueva lista de personas
     */
    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
}