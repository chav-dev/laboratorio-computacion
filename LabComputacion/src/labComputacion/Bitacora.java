package labComputacion;

import java.util.ArrayList;

/**
 * Clase para gestionar el registro de acceso (entradas/salidas) de personas.
 * Almacena información sobre las horas de entrada/salida y realiza cálculos de
 * tiempo de uso.
 *
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public class Bitacora {

    private ArrayList<String> entradas;
    private ArrayList<String> salidas;
    private ArrayList<Persona> personas;

    /**
     * Constructor por defecto que inicializa las listas vacías.
     */
    public Bitacora() {
        this.entradas = new ArrayList<>();
        this.salidas = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    /**
     * Constructor que inicializa las listas con datos existentes.
     *
     * @param entradas Lista preexistente de horas de entrada
     * @param salidas Lista preexistente de horas de salida
     * @param personas Lista preexistente de objetos Persona
     */
    public Bitacora(ArrayList<String> entradas, ArrayList<String> salidas, ArrayList<Persona> personas) {
        this.entradas = entradas;
        this.salidas = salidas;
        this.personas = personas;
    }

    /**
     * Agrega un nuevo registro a la bitácora.
     *
     * @param persona Objeto Persona asociado al registro
     * @param entrada Hora de entrada (ej: "09:15 AM")
     * @param salida Hora de salida (ej: "11:45 AM")
     */
    public void addElemento(Persona persona, String entrada, String salida) {
        personas.add(persona);
        entradas.add(entrada);
        salidas.add(salida);
    }

    /**
     * Genera y muestra en consola todos los registros en formato:
     * "Nombre/Entrada/Salida"
     *
     * @return String concatenado con todos los registros
     */
    public String mostrarBitacora() {
        String bitacora = "";
        for (int i = 0; i < personas.size(); i++) {
            bitacora += personas.get(i).getNombre() + "/" + entradas.get(i) + "/" + salidas.get(i) + "\n";
        }
        System.out.println(bitacora);
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
            tiempoTotal += calcularDiferencia(entradas.get(i), salidas.get(i));
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
                tiempo += calcularDiferencia(entradas.get(i), salidas.get(i));
            }
        }

        return tiempo;
    }

    /**
     * Calcula la diferencia horaria entre dos marcas de tiempo en formato
     * "h:mmam/pm"
     *
     * @param entrada Hora de inicio en formato "h:mmam/pm"
     * @param salida Hora de fin en formato "h:mmam/pm"
     * @return Diferencia horaria en horas decimales
     */
    private double calcularDiferencia(String entrada, String salida) {

        // ENTRADA: Procesamiento de la hora de inicio
        int posEntrada = entrada.indexOf(':');
        double horaEntrada = Double.parseDouble(entrada.substring(0, posEntrada));
        String restoEntrada = entrada.substring(posEntrada + 1);  // Obtiene el resto (minutos + am/pm)
        double minEntrada = Double.parseDouble(restoEntrada.substring(0, restoEntrada.length() - 2)) / 60.0;  // Convierte minutos a fracción horaria
        double totalEntrada = horaEntrada + minEntrada;  // Combina horas y minutos como decimal

        // SALIDA: Procesamiento de la hora de fin
        int posSalida = salida.indexOf(':');
        double horaSalida = Double.parseDouble(salida.substring(0, posSalida));
        String restoSalida = salida.substring(posSalida + 1);  // Obtiene el resto (minutos + am/pm)
        double minSalida = Double.parseDouble(restoSalida.substring(0, restoSalida.length() - 2)) / 60.0;  // Convierte minutos a fracción horaria
        double totalSalida = horaSalida + minSalida; // Combina horas y minutos como decimal

        // CONVERSIÓN A 24 HORAS - ENTRADA
        if (restoEntrada.toLowerCase().endsWith("pm")) {
            if (horaEntrada != 12) {
                totalEntrada += 12;
            } else if (horaEntrada == 12) {
                totalEntrada = minEntrada;
            }
        }

        // CONVERSIÓN A 24 HORAS - SALIDA
        if (restoSalida.toLowerCase().endsWith("pm")) {
            if (horaSalida != 12) {
                totalSalida += 12;
            } else if (horaSalida == 12) {
                totalSalida = minSalida;
            }
        }

        // Si la hora de fin es menor que la de inicio, se asume que es del día siguiente
        if (totalSalida < totalEntrada) {
            totalSalida += 24.0;  // Suma 24 horas para ajustar al día siguiente
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
