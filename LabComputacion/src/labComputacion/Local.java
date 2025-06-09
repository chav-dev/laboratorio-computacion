package labComputacion;

import java.util.ArrayList;
import excepciones.*;

/**
 * Clase abstracta que representa un local genérico en el sistema de gestión.
 * Contiene información básica sobre el local, sus computadoras y bitácora
 * asociada. Esta clase sirve como base para locales especializados como
 * laboratorios y colectivo de investigación.
 *
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
public abstract class Local {

    protected String nombre;
    protected int tiempoUso;
    protected String labor;
    protected int cantPc;
    protected ArrayList<Computadora> computadoras;
    protected Bitacora bitacoraLocal;

    /**
     * Constructor de la clase Local
     *
     * @param nombre Nombre del local
     * @param tiempoUso Tiempo máximo de uso en horas
     * @param labor Tipo de actividad principal
     * @param cantPc Capacidad de computadoras
     * @param bitacoraLocal Bitácora asociada al local
     */
    public Local(String nombre, int tiempoUso, String labor, int cantPc, Bitacora bitacoraLocal) {
        this.nombre = nombre;
        this.tiempoUso = tiempoUso;
        this.labor = labor;
        this.cantPc = cantPc;
        this.computadoras = new ArrayList<>();
        this.bitacoraLocal = bitacoraLocal;
    }

    /**
     * Agrega una nueva computadora al local
     *
     * @param c Computadora a agregar
     * @throws PcExiste Si ya existe una PC con el mismo número
     */
    public void addPC(Computadora c) throws existe {
        // Verificar si ya existe una PC con ese número
        for (int i = 0; i < computadoras.size(); i++) {
            if (computadoras.get(i).getNumero() == c.getNumero()) {
                throw new existe("Ya existe una computadora con el numero " + c.getNumero());
            }
        }
        // Agregar la computadora si no existe
        computadoras.add(c);
    }

    /**
     * Elimina una computadora del local
     *
     * @param num Número de la computadora a eliminar
     * @throws PcNoExiste Si no existe una PC con ese número
     */
    public void deletePC(int num) throws noExiste {
        // Buscar la computadora por su número
        for (int i = 0; i < computadoras.size(); i++) {
            if (computadoras.get(i).getNumero() == num) {
                computadoras.remove(i);
                break;
            } else {
                // Lanzar excepción si no se encontró
                throw new noExiste("No existe computadora con numero " + num);
            }
        }
    }

    /**
     * Obtiene la lista de computadoras rotas
     *
     * @return ArrayList de computadoras con estado "Rota"
     */
    public ArrayList<Computadora> pcRotas() {
        ArrayList<Computadora> pcRotas = new ArrayList<>();
        // Recorrer todas las computadoras
        for (int i = 0; i < computadoras.size(); i++) {
            if (computadoras.get(i).getEstado().equals("Rota")) {
                pcRotas.add(computadoras.get(i));
            }
        }
        return pcRotas;
    }

    /**
     * Cuenta las computadoras rotas
     *
     * @return Cantidad de computadoras rotas
     */
    public int cantPcRota() {
        return pcRotas().size();
    }

    /**
     * Cuenta las computadoras ocupadas
     *
     * @return Cantidad de computadoras ocupadas
     */
    public int cantPcOcupada() {
        int countOcupada = 0;
        // Recorrer todas las computadoras
        for (int i = 0; i < computadoras.size(); i++) {
            if (computadoras.get(i).getEstado().equalsIgnoreCase("Ocupada")) {
                countOcupada++;
            }
        }
        return countOcupada;
    }

    /**
     * Cuenta las computadoras libres
     *
     * @return Cantidad de computadoras libres
     */
    public int cantPcLibre() {
        int countLibre = 0;
        // Recorrer todas las computadoras
        for (int i = 0; i < computadoras.size(); i++) {
            if (computadoras.get(i).getEstado().equalsIgnoreCase("Libre")) {
                countLibre++;
            }
        }
        return countLibre;
    }

//    /**
//     * Busca una persona en las bitácoras de las computadoras
//     * @param nombre Nombre de la persona a buscar
//     * @return String con información de la persona encontrada
//     */
//    public String buscarPersona(String nombre){
//        int nroPc = 0;
//        String tipoLocal = "";
//        double tiempo = 0;
//        String name= "";
//        
//        // Buscar en todas las computadoras
//        for(int i = 0; i < computadoras.size(); i++){
//            Bitacora bitacora = computadoras.get(i).getBitacoraPc();
//            // Buscar en todas las personas de la bitácora
//            for(int j = 0; j < bitacora.getPersonas().size(); j++){
//                if(bitacora.getPersonas().get(j).getNombre().equals(nombre)){
//                    name = bitacora.getPersonas().get(j).getNombre();
//                    nroPc = computadoras.get(i).getNumero();
//                    tipoLocal = computadoras.get(i).getTipoLocal().toString();
//                    tiempo = bitacora.calcTiempoUso();
//                }
//            }
//        }
//        return "Nombre: " +name+ ", Local: " +tipoLocal+ ", Numero de Computadora: " +nroPc+ ", Tiempo: " +tiempo;
//    }
    /**
     * Representación en String del objeto Local
     *
     * @return String con información básica del local
     */
    @Override
    public String toString() {
        return "Local{" + "nombre=" + nombre + ", tiempoUso=" + tiempoUso + ", labor=" + labor + ", cantPC=" + cantPc + '}';
    }

    /**
     * Obtiene el nombre del local.
     *
     * @return Nombre del local.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del local.
     *
     * @param nombre Nuevo nombre del local.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tiempo máximo de uso permitido en minutos.
     *
     * @return Tiempo de uso en minutos.
     */
    public int getTiempoUso() {
        return tiempoUso;
    }

    /**
     * Establece el tiempo máximo de uso permitido.
     *
     * @param tiempoUso Nuevo tiempo de uso en minutos.
     */
    public void setTiempoUso(int tiempoUso) {
        this.tiempoUso = tiempoUso;
    }

    /**
     * Obtiene el tipo de actividad principal del local.
     *
     * @return Labor del local.
     */
    public String getLabor() {
        return labor;
    }

    /**
     * Establece el tipo de actividad principal del local.
     *
     * @param labor Nueva labor del local.
     */
    public void setLabor(String labor) {
        this.labor = labor;
    }

    /**
     * Obtiene la capacidad de computadoras del local.
     *
     * @return Capacidad de computadoras.
     */
    public int getCantPc() {
        return cantPc;
    }

    /**
     * Establece la capacidad de computadoras del local.
     *
     * @param cantPc Nueva capacidad de computadoras.
     */
    public void setCantPC(int cantPc) {
        this.cantPc = cantPc;
    }

    /**
     * Obtiene la lista de computadoras del local.
     *
     * @return ArrayList de computadoras.
     */
    public ArrayList<Computadora> getComputadoras() {
        return computadoras;
    }

    /**
     * Establece la lista de computadoras del local.
     *
     * @param computadoras Nueva lista de computadoras.
     */
    public void setComputadoras(ArrayList<Computadora> computadoras) {
        this.computadoras = computadoras;
    }

    /**
     * Obtiene la bitácora asociada al local.
     *
     * @return Bitácora del local.
     */
    public Bitacora getBitacoraLocal() {
        return bitacoraLocal;
    }

    /**
     * Establece la bitácora asociada al local.
     *
     * @param bitacoraLocal Nueva bitácora del local.
     */
    public void setBitacoraLocal(Bitacora bitacoraLocal) {
        this.bitacoraLocal = bitacoraLocal;
    }
}
