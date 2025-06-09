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
     * Calcula el tiempo total de uso acumulado.
     *
     * @return Sumatoria de tiempos de uso en horas
     */
    public double calcTiempoUso() {
        double tiempoTotal = 0;
        for (int i = 0; i < entradas.size(); i++) {
            String entrada = entradas.get(i);
            String salida = salidas.get(i);

            // Procesar hora de entrada
            int posEntrada = entrada.indexOf(':');
            double horaEntrada = Double.parseDouble(entrada.substring(0, posEntrada));
            String minEntradaStr = entrada.substring(posEntrada + 1, entrada.length() - 2);
            double minEntrada = Double.parseDouble(minEntradaStr) / 60.0;
            double totalEntrada = horaEntrada + minEntrada;

            // Procesar hora de salida
            int posSalida = salida.indexOf(':');
            double horaSalida = Double.parseDouble(salida.substring(0, posSalida));
            String minSalidaStr = salida.substring(posSalida + 1, salida.length() - 2);
            double minSalida = Double.parseDouble(minSalidaStr) / 60.0;
            double totalSalida = horaSalida + minSalida;

            // Ajuste para formato 24h
            if (entrada.endsWith("pm") && horaEntrada != 12) {
                totalEntrada += 12;
            }else if (entrada.endsWith("am") && horaEntrada == 12) {
                totalEntrada = minEntrada;
            }else if (salida.endsWith("pm") && horaSalida != 12) {
                totalSalida += 12;
            }else if (salida.endsWith("am") && horaSalida == 12) {
                totalSalida = minSalida;
            }

            // Manejo de intervalos nocturnos
            if (totalSalida < totalEntrada) {
                totalSalida += 24.0;
            }

            // Acumular diferencia
            tiempoTotal += totalSalida - totalEntrada;
        }
        return tiempoTotal;
    }

    /**
     * Calcula tiempo de uso para una persona específica (contiene mismos
     * errores que calcTiempoUso).
     *
     * @param nombre Nombre de la persona a buscar
     * @return Tiempo acumulado en horas (cálculo problemático)
     */
    public double calcTiempoPersona(String nombre) {
        double tiempo = 0;
        for (int i = 0; i < entradas.size(); i++) {
            if (personas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                String horaEntrada = entradas.get(i).split(":")[0];
                String horaSalida = salidas.get(i).split(":")[0];
                if (entradas.get(i).contains("pm") && salidas.get(i).contains("am")) {
                    tiempo = 12.0 - (Double.parseDouble(horaEntrada)) + Double.parseDouble(horaSalida);
                } else if (entradas.get(i).contains("am") && salidas.get(i).contains("pm")) {
                    tiempo = (Double.parseDouble(horaSalida)) + 12.0 - Double.parseDouble(horaEntrada);
                } else {
                    tiempo = Double.parseDouble(horaSalida) - Double.parseDouble(horaEntrada);
                }
            }
        }
        return tiempo;
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
