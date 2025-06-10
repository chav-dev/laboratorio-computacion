package clases;

import excepciones.*;
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
    public void addPersona(Persona p) throws ExisteException {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getNombre().equalsIgnoreCase(p.getNombre())) {
                throw new ExisteException(p.getNombre() + " ya existe");
            }
        }
        personas.add(p);
    }
    
    /**
     * Elimina una persona de la lista por su nombre.
     * 
     * @param nombre Nombre de la persona a eliminar
     * @throws NoExisteException Si no existe una persona con ese nombre
     */
    public void deletePersona(String nombre) throws NoExisteException {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                personas.remove(i);
                return; // Sale del método inmediatamente después de eliminar
            }
        }
        // Solo llega aquí si no encontró ninguna coincidencia
        throw new NoExisteException(nombre + " no existe");
    }

    /**
     * Agrega un local a la lista de la facultad.
     *
     * @param l Objeto Local a agregar
     */
    public void addLocal(Local l) throws ExisteException {
        for (int i = 0; i < locales.size(); i++) {
            if (locales.get(i).getNombre().equalsIgnoreCase(l.getNombre())) {
                throw new ExisteException("El local " + l.getNombre() + " ya existe");
            }
        }
        locales.add(l);
    }

    /**
     * Elimina un local de la lista por su nombre.
     * 
     * @param nombre Nombre del local a eliminar (no distingue
     *               mayúsculas/minúsculas)
     * @throws NoExisteException Si no existe un local con el nombre especificado
     */
    public void deleteLocal(String nombre) throws NoExisteException {
        for (int i = 0; i < locales.size(); i++) {
            if (locales.get(i).getNombre().equalsIgnoreCase(nombre)) {
                locales.remove(i);
                break;
            } else {
                throw new NoExisteException("El local " + nombre + " no existe");
            }
        }
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
     * Buscar en que local / computadoras trabajó una persona y de tiempo de trabajo
     *
     * @param nombre Nombre de la persona a buscar
     * @return String con información de locales, tiempo y computadoras usadas
     */
    public String buscarInfoPersona(String nombre) {
        StringBuilder infoBuilder = new StringBuilder();
        boolean personaEncontrada = false;

        for (int i = 0; i < locales.size(); i++) {
            Local local = locales.get(i);
            Bitacora bitacoraLocal = local.getBitacoraLocal();
            double tiempoEnLocal = bitacoraLocal.calcTiempoPersona(nombre);

            //Verificar si la persona tiene registros en el local
            if (tiempoEnLocal > 0) {
                personaEncontrada = true;

                //Agregar información del local
                infoBuilder.append("Local: ").append(local.getNombre())
                           .append("\nTiempo total: ")
                           .append(String.format("%.2f horas", tiempoEnLocal))
                           .append("\nComputadoras usadas:\n");

                //Buscar computadoras específicas usadas por la persona
                ArrayList<Computadora> computadoras = local.getComputadoras();
                boolean computadorasEncontradas = false;

                for (int j = 0; j < computadoras.size(); j++) {
                    Computadora comp = computadoras.get(j);
                    double tiempoEnPC = comp.getBitacoraPc().calcTiempoPersona(nombre);

                    //Mostrar solo computadoras con tiempo de uso > 0
                    if (tiempoEnPC > 0) {
                        computadorasEncontradas = true;
                        infoBuilder.append(" - ").append(String.valueOf(comp.getNumero()))
                                   .append(": ")
                                   .append(String.format("%.2f horas", tiempoEnPC))
                                   .append("\n");
                    }
                }

                //Manejar caso sin computadoras específicas
                if (!computadorasEncontradas) {
                    infoBuilder.append(" (No se registraron computadoras específicas)\n");
                }

                infoBuilder.append("\n");
            }
        }

        //Manejar persona no encontrada
        if (!personaEncontrada) {
            infoBuilder.append("La persona '").append(nombre).append("' no fue encontrada en ningún local.");
        }

        return infoBuilder.toString();
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

                if (tiempoTrab > 0) {
                    local += locales.get(j).getNombre() + " ";
                }
            }

            if (tiempo > mejorTiempo) {
                mejorTiempo = tiempo;
                persona = personas.get(i).getNombre();
                finalLocal = local;
            }
        }
        return "Nombre de la persona: " + persona + " Tiempo: " + mejorTiempo + " Locales: " + finalLocal + "\n";
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
