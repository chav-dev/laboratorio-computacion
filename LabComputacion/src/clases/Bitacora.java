package clases;

import java.util.ArrayList;

/**
 * Clase para gestionar el registro de acceso (entradas/salidas/fechas) de personas.
 * Almacena información sobre las horas de entrada/salida y la fecha y realiza cálculos de tiempo de uso.
 *
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class Bitacora {

    private ArrayList<String> entradas;
    private ArrayList<String> salidas;
    private ArrayList<String> fechas;
    private ArrayList<Persona> personas;

    /**
     * Constructor por defecto que inicializa las listas vacías.
     */
    public Bitacora() {
        this.entradas = new ArrayList<>();
        this.salidas = new ArrayList<>();
        this.fechas = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    /**
     * Constructor que inicializa las listas con datos existentes.
     *
     * @param entradas Lista preexistente de horas de entrada
     * @param salidas Lista preexistente de horas de salida
     * @param fechas Lista preexistente de fechas
     * @param personas Lista preexistente de objetos Persona
     */
    public Bitacora(ArrayList<String> entradas, ArrayList<String> salidas, ArrayList<String> fechas, ArrayList<Persona> personas) {
        this.entradas = entradas;
        this.salidas = salidas;
        this.fechas = fechas;
        this.personas = personas;
    }

    /**
     * Agrega un nuevo registro a la bitácora.
     *
     * @param persona Objeto Persona asociado al registro
     * @param entrada Hora de entrada (ej: "09:15 AM")
     * @param salida Hora de salida (ej: "11:45 AM")
     * @param fecha Fecha (ej: "2025-05-10")
     */
    public void addElemento(Persona persona, String entrada, String salida, String fecha) {
        personas.add(persona);
        entradas.add(entrada);
        salidas.add(salida);
        fechas.add(fecha);
    }

    /**
     * Elimina una persona y sus registros asociados (entrada, salida y fecha) en la misma posición.
     *
     * @param persona La persona a eliminar.
     * @return true si se eliminó correctamente, false si no se encontró.
     * @throws IllegalArgumentException si la persona es null.
     */
    public boolean deleteElemento(Persona persona) {
        // Validar que la persona no es null
        if (persona == null) {
            throw new IllegalArgumentException("La persona no puede ser null.");
        }

        // Buscar el índice de la persona
        int indicePersona = -1;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).equals(persona)) {
                indicePersona = i;
                break;
            }
        }

        // Si no existe, retornar false
        if (indicePersona == -1) {
            return false;
        }

        personas.remove(indicePersona);
        entradas.remove(indicePersona);
        salidas.remove(indicePersona);
        fechas.remove(indicePersona);

        return true;
    }

    /**
     * Genera y muestra en consola todos los registros en formato: "Nombre/Fecha/Entrada/Salida"
     *
     * @return String concatenado con todos los registros
     */
    public String mostrarBitacora() {
        String bitacora = "";
        for (int i = 0; i < personas.size(); i++) {
            bitacora += personas.get(i).getNombre() + "/" + fechas.get(i) + "/" + entradas.get(i) + "/" + salidas.get(i) + "\n";
        }
        System.out.println(bitacora);
        return bitacora;
    }
    
    /**
     * Genera y muestra en consola los registros de una fecha en específico
     *
     * @return String concatenado con todos los registros de la fecha
     */
    public String mostrarBitacoraFecha(String fecha){
        String bitacora = "Fecha: " + fecha + "\n";
        
        for (int i = 0; i < fechas.size(); i++) {
            if(fechas.get(i).equalsIgnoreCase(fecha)){
                bitacora += personas.get(i).getNombre() + "/" + entradas.get(i) + "/" + salidas.get(i) + "\n";
            }
        }
        return bitacora;
    }

    /**
     * Calcula el tiempo total acumulado de todos los locales
     *
     * @return Sumatoria de tiempos de uso en horas decimales
     */
    public double calcTiempoUso() {
        double tiempoTotal = 0;

        for (int i = 0; i < entradas.size(); i++) {
            tiempoTotal += calcDiferencia(entradas.get(i), salidas.get(i));
        }

        return tiempoTotal;
    }

    /**
     * Calcula el tiempo acumulado para una persona específica
     *
     * @param nombre Nombre de la persona a buscar
     * @return Tiempo total acumulado en horas decimales
     */
    public double calcTiempoPersona(String nombre) {
        double tiempo = 0;

        for (int i = 0; i < entradas.size(); i++) {
            if (personas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                tiempo += calcDiferencia(entradas.get(i), salidas.get(i));
            }
        }

        return tiempo;
    }

    /**
     * Calcula la diferencia horaria entre dos marcas de tiempo en formato "hh:mm am/pm"
     *
     * @param entrada Hora de inicio en formato "hh:mm am/pm"
     * @param salida Hora de fin en formato "hh:mm am/pm"
     * @return Diferencia horaria en horas decimales
     */
    private double calcDiferencia(String entrada, String salida) {

        //Procesar la hora de inicio
        int posEntrada = entrada.indexOf(':');
        double horaEntrada = Double.parseDouble(entrada.substring(0, posEntrada));
        String restoEntrada = entrada.substring(posEntrada + 1);
        double minEntrada = Double.parseDouble(restoEntrada.substring(0, restoEntrada.length() - 2)) / 60.0;
        double totalEntrada = horaEntrada + minEntrada;

        //Procesar la hora de fin
        int posSalida = salida.indexOf(':');
        double horaSalida = Double.parseDouble(salida.substring(0, posSalida));
        String restoSalida = salida.substring(posSalida + 1);
        double minSalida = Double.parseDouble(restoSalida.substring(0, restoSalida.length() - 2)) / 60.0;
        double totalSalida = horaSalida + minSalida;

        //Convertir la hora de entrada a formato 24 horas
        if (restoEntrada.toLowerCase().endsWith("pm")) {
            if (horaEntrada != 12) {
                totalEntrada += 12;
            } else {
                totalEntrada = minEntrada;
            }
        }

        //Convertir la hora de salida a formato 24 horas
        if (restoSalida.toLowerCase().endsWith("pm")) {
            if (horaSalida != 12) {
                totalSalida += 12;
            } else {
                totalSalida = minSalida;
            }
        }

        // Si la hora de fin es menor que la de inicio, se asume que es del día siguiente
        if (totalSalida < totalEntrada) {
            totalSalida += 24.0;
        }

        return totalSalida - totalEntrada;
    }

    /**
     * Calcula porcentaje de tiempo usado respecto a un tiempo de referencia.
     *
     * @param tiempoUso Tiempo total de referencia en horas
     * @return Porcentaje calculado
     */
    public double calcPorcAprov(int tiempoUso) {
        return (calcTiempoUso() * 100.0) / (double) tiempoUso;
    }

    /**
     * Obtiene la lista completa de entradas.
     *
     * @return ArrayList de cadenas con horas de entrada
     */
    public ArrayList<String> getEntradas() {
        return entradas;
    }

    /**
     * Reemplaza la lista actual de entradas.
     *
     * @param entradas Nueva lista de entradas
     */
    public void setEntradas(ArrayList<String> entradas) {
        this.entradas = entradas;
    }

    /**
     * Obtiene la lista completa de salidas.
     *
     * @return ArrayList de cadenas con horas de salida
     */
    public ArrayList<String> getSalidas() {
        return salidas;
    }

    /**
     * Reemplaza la lista actual de salidas.
     *
     * @param salidas Nueva lista de salidas
     */
    public void setSalidas(ArrayList<String> salidas) {
        this.salidas = salidas;
    }

    /**
     * Obtiene la lista completa de fechas.
     *
     * @return ArrayList de cadenas con fechas
     */
    public ArrayList<String> getFechas() {
        return fechas;
    }

    /**
     * Reemplaza la lista actual de fechas.
     *
     * @param fechas Nueva lista de fechas
     */
    public void setFechas(ArrayList<String> fechas) {
        this.fechas = fechas;
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
     * @param personas Nueva lista de objetos Persona
     */
    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
}
