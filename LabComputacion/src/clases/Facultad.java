package clases;

import excepciones.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Clase que representa una facultad, gestionando locales y personas.
 * Proporciona funcionalidades para analizar el uso de recursos computacionales.
 *
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class Facultad implements Serializable {

    private ArrayList<Local> locales;

    /**
     * Constructor por defecto que inicializa la lista vacía.
     */
    public Facultad() {
        this.locales = new ArrayList<>();
    }

    public Facultad(ArrayList<Local> locales) {
        this.locales = locales;
    }
    
    

    /**
     * Agrega un nuevo local a la lista, asegurando que no se duplique.
     *
     * @param local El objeto Local que se desea agregar.
     * @throws ExisteException Si el local ya existe en la lista.
     */
    public void addLocal(Local local) throws ExisteException {
        for (int i = 0; i < locales.size(); i++) {
            if (locales.get(i).getNombre().equalsIgnoreCase(local.getNombre())) {
                throw new ExisteException("El local " + local.getNombre() + " ya existe");
            }
        }
        locales.add(local);
    }

    /**
     * Elimina un local de la lista por su nombre.
     *
     * @param nombre Nombre del local a eliminar
     * @throws NoExisteException Si no existe un local con el nombre
     * especificado
     */
    public void deleteLocal(String nombre) throws NoExisteException {
        boolean enc = false;
        for (int i = 0; i < locales.size(); i++) {
            if (locales.get(i).getNombre().equalsIgnoreCase(nombre)) {
                locales.remove(i);
                enc = true;
            }
        }
        if (!enc) {
            throw new NoExisteException("El local " + nombre + " no existe");
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
     * Buscar en que local / computadoras trabajó una persona y el tiempo de
     * trabajo
     *
     * @param nombre Nombre de la persona a buscar
     * @return String con información de locales, tiempo y computadoras usadas
     */
    public String buscarInfoPersona(String nombre) {
        StringBuilder info = new StringBuilder();
        boolean enc = false;

        for (int i = 0; i < locales.size(); i++) {
            double tiempoEnLocal = locales.get(i).getBitacoraLocal().calcTiempoPersona(nombre);

            //Verificar si la persona tiene registros en el local
            if (tiempoEnLocal > 0) {
                enc = true;

                //Agregar información del local
                info.append("Local: ").append(locales.get(i).getNombre())
                        .append("\nTiempo total: ")
                        .append(String.format("%.2f horas", tiempoEnLocal))
                        .append("\nComputadoras usadas:\n");

                //Buscar computadoras específicas usadas por la persona
                ArrayList<Computadora> computadoras = locales.get(i).getComputadoras();
                boolean computadorasEncontradas = false;

                for (int j = 0; j < computadoras.size(); j++) {
                    double tiempoEnPC = computadoras.get(j).getBitacoraPc().calcTiempoPersona(nombre);

                    //Mostrar solo computadoras con tiempo de uso > 0
                    if (tiempoEnPC > 0) {
                        computadorasEncontradas = true;
                        info.append(" - ").append(String.valueOf(computadoras.get(j).getNumero()))
                                .append(": ")
                                .append(String.format("%.2f horas", tiempoEnPC))
                                .append("\n");
                    }
                }

                //Manejar caso sin computadoras específicas
                if (!computadorasEncontradas) {
                    info.append(" (No se registraron computadoras específicas)\n");
                }

                info.append("\n");
            }
        }

        //Manejar persona no encontrada
        if (!enc) {
            info.append("La persona '").append(nombre).append("' no fue encontrada en ningún local.");
        }

        return info.toString();
    }

    public String buscarPersona() {
        String persona = "";
        int mejorTiempo = 0;
        String finalLocal = "";

        for (int i = 0; i < locales.size(); i++) {
            Bitacora bitacora = locales.get(i).getBitacoraLocal();

            for (int j = 0; j < bitacora.getPersonas().size(); j++) {
                String nombrePersona = bitacora.getPersonas().get(j).getNombre();
                int tiempoTotal = 0;
                StringBuilder localesVisitados = new StringBuilder();

                // Calcular tiempo total y locales visitados para esta persona
                for (int k = 0; k < locales.size(); k++) {
                    Local local = locales.get(k);
                    Bitacora bit = local.getBitacoraLocal();
                    int tiempo = (int) bit.calcTiempoPersona(nombrePersona);

                    if (tiempo > 0) {
                        tiempoTotal += tiempo;
                        localesVisitados.append(local.getNombre()).append(" ");
                    }
                }

                // Comparar con el mejor tiempo actual
                if (tiempoTotal > mejorTiempo) {
                    mejorTiempo = tiempoTotal;
                    persona = nombrePersona;
                    finalLocal = localesVisitados.toString();
                }
            }
        }

        return "Nombre de la persona: " + persona + " Tiempo: " + mejorTiempo + " Locales: " + finalLocal + "\n";
    }

    public void guardarFacultad(String ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(locales);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void cargarFacultad(String ruta) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            locales = (ArrayList<Local>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }
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
}
