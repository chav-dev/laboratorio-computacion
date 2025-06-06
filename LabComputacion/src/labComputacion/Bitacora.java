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

    public String mostrarBitacora() {
        String bitacora = "";
        for (int i = 0; i < personas.size(); i++) {
            bitacora += personas.get(i).getNombre() + "/" + entradas.get(i) + "/" + salidas.get(i) + "\n";
        }
        System.out.println(bitacora);
        return bitacora;
    }

    public double calcTiempoUso(){
        double tiempo = 0;
        for (int i = 0; i < entradas.size(); i++) {
            if(entradas.get(i).contains("pm") && salidas.get(i).contains("am")){
                tiempo = (Double.parseDouble(entradas.get(i)) + 12) - Double.parseDouble(salidas.get(i));
            }else if(entradas.get(i).contains("am") && salidas.get(i).contains("pm")){
                tiempo = (Double.parseDouble(salidas.get(i)) + 12) - Double.parseDouble(entradas.get(i));
            }else{
                tiempo = Double.parseDouble(salidas.get(i)) - Double.parseDouble(entradas.get(i));
            }
        }
        return tiempo;
    }
    
    public double calcPorcAprov(int tiempoUso) {
        double suma = 0;
        double dif = 0;
        for (int i = 0; i < entradas.size(); i++) {
            if(entradas.get(i).contains("pm") && salidas.get(i).contains("am")){
                dif = (Double.parseDouble(entradas.get(i)) + 12) - Double.parseDouble(salidas.get(i));
            }else if(entradas.get(i).contains("am") && salidas.get(i).contains("pm")){
                dif = (Double.parseDouble(salidas.get(i)) + 12) - Double.parseDouble(entradas.get(i));
            }else{
                dif = Double.parseDouble(salidas.get(i)) - Double.parseDouble(entradas.get(i));
            }
            suma += dif;
        }
        return (suma * 100) / tiempoUso;
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
