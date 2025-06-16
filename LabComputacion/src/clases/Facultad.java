package clases;

import excepciones.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
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

    public void guardarPersonas(String ruta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            System.out.println("Personas: ");
            // Corregido: usa < en lugar de <= para evitar índice fuera de límites
            for (int i = 0; i < personas.size(); i++) {
                pw.println(personas.get(i).toString());
            }
            // Eliminado pw.close() redundante (try-with-resources lo cierra automáticamente)
            System.out.println("Datos guardados correctamente en: " + ruta);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void cargarPersonas(String archivo) throws IOException {
        personas.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int lineaNum = 0;

            while ((linea = br.readLine()) != null) {
                lineaNum++;
                linea = linea.trim();

                String[] partes = linea.split(";");

                switch (partes[0]) {
                    case "Profesor" -> {
                        if (partes.length >= 4) {
                            String asig = partes[1];
                            String nombre = partes[2];
                            int solapin = Integer.parseInt(partes[3]);
                            Profesor p = new Profesor(asig, nombre, solapin);
                        }
                        break;
                    }
                    case "Estudiante" -> {
                        if (partes.length >= 4) {
                            int annoDoc = Integer.parseInt(partes[1]);
                            String nombre = partes[2];
                            int solapin = Integer.parseInt(partes[3]);
                            Estudiante e = new Estudiante(annoDoc, nombre, solapin);
                        }
                        break;
                    }
                    case "Estudiante de proyecto" -> {
                        if (partes.length >= 5) {
                            String nombreProy = partes[1];
                            int annoDoc = Integer.parseInt(partes[2]);
                            String nombre = partes[3];
                            int solapin = Integer.parseInt(partes[4]);
                            EstudianteProy estproy = new EstudianteProy(nombreProy, annoDoc, nombre, solapin);
                        }
                        break;
                    }

                }
            }

            br.close();
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
