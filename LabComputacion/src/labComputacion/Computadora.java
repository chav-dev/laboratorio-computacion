package labComputacion;

import java.util.ArrayList;
import java.util.Date;
import excepciones.NoAutorizadoException;

/**
 *
 * @author Chavelys
 */
public class Computadora {
    private String estado;
    private int numero;
    private ArrayList<Persona> personas;
    private ArrayList<Date> fechaInicio;
    private ArrayList<Date> fechaFin;
    private Local tipoLocal;

    public Computadora(String estado, int numero, Local tipoLocal) {
        this.estado = estado;
        this.numero = numero;
        this.personas = new ArrayList<>();
        this.fechaInicio = new ArrayList<>();
        this.fechaFin = new ArrayList<>();
        this.tipoLocal = tipoLocal;
    }
    
    public void addTiempoMaquina(Persona p, Date fechaInicio, Date fechaFin) throws NoAutorizadoException{
        if((p instanceof Profesor && tipoLocal instanceof LocalColectInvest) || (p instanceof EstudianteProy && tipoLocal instanceof LabProy) || (p instanceof Estudiante && tipoLocal instanceof LabDoc)){
            personas.add(p);
            this.fechaInicio.add(fechaInicio);
            this.fechaFin.add(fechaFin);
        }else{
            throw new NoAutorizadoException("No esta autorizado a estar en este laboratorio");
        }
    }
    
    public String mostrarBitacora(){
        String bitacora = "";
        for (int i = 0; i < personas.size(); i++) {
            bitacora += personas.get(i).getNombre()+"/"+fechaInicio.get(i)+"/"+fechaFin.get(i)+"\n";
        }
        System.out.println(bitacora);
        return bitacora;
    }

    @Override
    public String toString() {
        return "Computadora{" + "estado=" + estado + ", numero=" + numero + ", tipoLocal=" + tipoLocal + '}';
    }
    
    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public ArrayList<Date> getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(ArrayList<Date> fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public ArrayList<Date> getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(ArrayList<Date> fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Local getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(Local tipoLocal) {
        this.tipoLocal = tipoLocal;
    }
    
    
}
