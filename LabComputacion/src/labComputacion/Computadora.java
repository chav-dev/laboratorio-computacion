package labComputacion;
/**
 *
 * @author Chavelys
 */
public class Computadora {
    private String estado;
    private int numero;
    private Bitacora bitacoraPC;
    private Local tipoLocal;

    public Computadora(String estado, int numero, Local tipoLocal) {
        this.estado = estado;
        this.numero = numero;
        this.tipoLocal = tipoLocal;
    }
    
//    public void addTiempoMaquina(Persona p, LocalTime fechaInicio, LocalTime fechaFin) throws NoAutorizadoException, PCNoDisponibleException{
//        if(estado.equals("Rota") || estado.equals("Ocupada")){
//            throw new PCNoDisponibleException("En este momento no esta disponible");
//        }
//        
//        if((p instanceof Profesor && tipoLocal instanceof LocalColectInvest) || (p instanceof EstudianteProy && tipoLocal instanceof LabProy) || (p instanceof Estudiante && tipoLocal instanceof LabDoc)){
//            personas.add(p);
//            this.fechaInicio.add(fechaInicio);
//            this.fechaFin.add(fechaFin);
//        }else{
//            throw new NoAutorizadoException("No esta autorizado a estar en este laboratorio");
//        }
//    }
//    
//    public String mostrarBitacora(){
//        String bitacora = "";
//        for (int i = 0; i < personas.size(); i++) {
//            bitacora += personas.get(i).getNombre()+"/"+fechaInicio.get(i)+"/"+fechaFin.get(i)+"\n";
//        }
//        System.out.println(bitacora);
//        return bitacora;
//    }
//    
//    public Duration calcTiempoUsoComputadora(){
//        Duration tiempo = Duration.ZERO;
//        for (int i = 0; i < personas.size(); i++) {
//            Duration pTime = Duration.between(fechaFin.get(i), fechaInicio.get(i)); 
//            tiempo = tiempo.plus(pTime);
//        }
//        return tiempo;
//    }
//    
//    public double calcPorcientoAprovechamiento(){
//        double solve = calcTiempoUsoComputadora().dividedBy(tipoLocal.getTiempoUso());
//        return  solve * 100;
//    }

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

    public Bitacora getBitacoraPC() {
        return bitacoraPC;
    }

    public void setBitacoraPC(Bitacora bitacoraPC) {
        this.bitacoraPC = bitacoraPC;
    }

    public Local getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(Local tipoLocal) {
        this.tipoLocal = tipoLocal;
    }
}
