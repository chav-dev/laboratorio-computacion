package labComputacion;

import java.util.ArrayList;

/**
 *
 * @author Chavelys
 */
public class Bitacora {

    private ArrayList<String> entradas;
    private ArrayList<String> salidas;
    private ArrayList<Persona> personas;

    public Bitacora() {
        this.entradas = new ArrayList<>();
        this.salidas = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    public Bitacora(ArrayList<String> entradas, ArrayList<String> salidas, ArrayList<Persona> personas) {
        this.entradas = entradas;
        this.salidas = salidas;
        this.personas = personas;
    }

    public void addElemento(Persona persona, String entrada, String salida) {
        entradas.add(entrada);
        salidas.add(salida);
        personas.add(persona);
    }

    public String mostrarBitacora() {
        String bitacora = "";
        for (int i = 0; i < personas.size(); i++) {
            bitacora += personas.get(i).getNombre() + "/" + entradas.get(i) + "/" + salidas.get(i) + "\n";
        }
        System.out.println(bitacora);
        return bitacora;
    }
    
//    /**
//     * Convierte una hora en formato HHMM (entero) a formato de 12 horas
//     * (String).
//     *
//     * @param hora Entero que representa la hora en formato HHMM
//     * @return Hora formateada en sistema de 12 horas (ej: "02:30 PM")
//     */
//    private String convertirHora(int hora) {
//        // Extraer horas y minutos
//        int horas = hora / 100;
//        int minutos = hora % 100;
//
//        // Validar rango de horas (0-23)
//        horas = horas % 24;
//
//        // Determinar período (AM/PM)
//        String periodo = "";
//        if (horas < 12) {
//            periodo = "AM";
//        } else {
//            periodo = "PM";
//        }
//
//        // Convertir a formato de 12 horas
//        int horas12 = horas % 12;
//        if (horas12 == 0) {
//            horas12 = 12; // 0 horas se convierte en 12 AM
//        }
//
//        // Formatear como "HH:MM AM/PM" con dos dígitos
//        return String.format("%02d:%02d %s", horas12, minutos, periodo);
//    }

    public double calcTiempoUso() {
        double tiempo = 0;

        for (int i = 0; i < entradas.size(); i++) {
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
        return tiempo;
    }

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

    public double calcPorcAprov(int tiempoUso) {
        return (calcTiempoUso() * 100.0) / (double) tiempoUso;
    }

    public ArrayList<String> getEntradas() {
        return entradas;
    }

    public void setEntradas(ArrayList<String> entradas) {
        this.entradas = entradas;
    }

    public ArrayList<String> getSalidas() {
        return salidas;
    }

    public void setSalidas(ArrayList<String> salidas) {
        this.salidas = salidas;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
}
