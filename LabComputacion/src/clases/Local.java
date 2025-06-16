package clases;

import java.util.ArrayList;
import excepciones.*;

/**
 * Clase abstracta que representa un local genérico en el sistema de gestión.
 * Contiene información básica sobre el local, sus computadoras y bitácora asociada. Esta clase sirve como base para locales especializados como 
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

    public Local(String nombre, int tiempoUso, String labor, int cantPc) {
        this.nombre = nombre;
        this.tiempoUso = tiempoUso;
        this.labor = labor;
        this.cantPc = cantPc;
    }
    
    

    /**
     * Agrega una nueva computadora al local
     *
     * @param comp Computadora a agregar
     * @throws ExisteException Si ya existe una PC con el mismo número
     */
    public void addPc(Computadora comp) throws ExisteException {
        for (int i = 0; i < computadoras.size(); i++) {
            if (computadoras.get(i).getNumero() == comp.getNumero()) {
                throw new ExisteException("Ya existe una computadora con el numero " + comp.getNumero());
            }
        }

        computadoras.add(comp);
    }

    /**
     * Elimina una computadora del local
     *
     * @param num Número de la computadora a eliminar
     * @throws NoExisteException Si no existe una PC con ese número
     */
    public void deletePc(int num) throws NoExisteException {
        boolean enc = false;
        for (int i = 0; i < computadoras.size(); i++) {
            if (computadoras.get(i).getNumero() == num) {
                enc = true;
                computadoras.remove(i);
                break;
            }
        }

        if (!enc) {
            throw new NoExisteException("No existe computadora con numero " + num);
        }
    }

    /**
     * Obtiene la lista de computadoras rotas
     *
     * @return ArrayList de computadoras con estado "Rota"
     */
    public ArrayList<Computadora> pcRotas() {
        ArrayList<Computadora> pcRotas = new ArrayList<>();
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
        for (int i = 0; i < computadoras.size(); i++) {
            if (computadoras.get(i).getEstado().equalsIgnoreCase("Libre")) {
                countLibre++;
            }
        }
        return countLibre;
    }

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
