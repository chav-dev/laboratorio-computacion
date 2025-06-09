package labComputacion;

import excepciones.PcExiste;
import excepciones.PcNoExiste;

/**
 *
 * @author Chavelys
 */
public class Main {

    public static void main(String[] args) {
        Persona p1 = new Estudiante(1, "aaa", 123);
        Persona p2 = new Estudiante(2, "bbb", 321);
        Persona p3 = new EstudianteProy("abc", 2, "ccc", 432);
        Persona p4 = new EstudianteProy("mnb", 4, "ddd", 876);
        Persona p5 = new Profesor("mate", "eee", 987);
        Persona p6 = new Profesor("prog", "fff", 654);
        Facultad f1 = new Facultad();
        Bitacora b1 = new Bitacora();
        Bitacora b2 = new Bitacora();
        Bitacora b3 = new Bitacora();
        Bitacora b4 = new Bitacora();
        Local l1 = new LabDoc("lll", 24, "Estudiar", 4, b1);
        Local l2 = new LocalColectInvest("sss", 20, "a", 10, b2);
        Local l3 = new LabProy("ttt", 16, "proyectos", 14, b3);
        Local l4 = new LabDoc("ooo", 24, "ed", 20, b4);
        Computadora c1 = new Computadora("Rota", 1, l1, b1);
        Computadora c2 = new Computadora("Libre", 32, l2, b2);
        Computadora c3 = new Computadora("Ocupada", 54, l3, b3);
        Computadora c4 = new Computadora("Libre", 65, l4, b4);
        Computadora c5 = new Computadora("rota", 45, l2, b2);


        b1.addElemento(p6, "12:00pm", "5:30pm");
        b1.calcPorcAprov(12);
        b1.calcTiempoPersona("fff");
        b1.calcTiempoUso();
        b1.mostrarBitacora();

        try {
            l1.addPC(c5);
            l1.addPC(c5);
        } catch (PcExiste e) {
            e.getMessage();
        }

        l1.cantPcLibre();
        l1.cantPcOcupada();
        l1.cantPcRota();
        try {
            l1.deletePC(1);
            l1.deletePC(0);
        } catch (PcNoExiste e) {
            e.getMessage();
        }
        l1.pcRotas();
        
        
        f1.addPersona(p1);
        f1.addPersona(p2);
        f1.addlocal(l1);
        f1.addlocal(l2);
        System.out.println(""+f1.buscarInfoPersona("aaa"));
        System.out.println(""+f1.buscarInfoPersona(""));
        System.out.println(""+f1.buscarPersona());
        System.out.println(""+f1.mejorPorc());
        System.out.println(""+f1.peorPorc());
    }
}
