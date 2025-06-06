package labComputacion;

import java.util.ArrayList;

/**
 *
 * @author Chavelys
 */
public class Bitacora {
    private ArrayList<Double> entradas;
    private ArrayList<Double> salidas;
    private ArrayList<Persona> personas;

    public Bitacora() {
        this.entradas = new ArrayList<>();
        this.salidas = new ArrayList<>();
        this.personas = new ArrayList<>();
    }
    
    // public double porcAprov(int tiempoUso){
    //     double suma = 0;
    //     double dif = 0;
    //     for (int i = 0; i < entradas.size(); i++) {
    //         dif = salidas.get(i) - entradas.get(i);
    //         suma += dif;
    //     }
    //     return (suma * 100) / tiempoUso;
    // }
    
    //method: calcular el mejor y peor porc de aprovechamiento

    public ArrayList<Double> getEntradas() {
        return entradas;
    }

    public void setEntradas(ArrayList<Double> entradas) {
        this.entradas = entradas;
    }

    public ArrayList<Double> getSalidas() {
        return salidas;
    }

    public void setSalidas(ArrayList<Double> salidas) {
        this.salidas = salidas;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
}
