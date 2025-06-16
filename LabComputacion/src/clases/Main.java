package clases;

import excepciones.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chavelys
 */
public class Main {

    public static void main(String[] args) throws ExisteException, IOException {
        Persona p1 = new Estudiante(1, "aaa", 123);
        Persona p2 = new Estudiante(2, "bbb", 321);
        Persona p3 = new EstudianteProy("abc", 2, "ccc", 432);
        Persona p4 = new EstudianteProy("mnb", 4, "ddd", 876);
        Persona p5 = new Profesor("mate", "eee", 987);
        Persona p6 = new Profesor("prog", "fff", 654);

        Bitacora b1 = new Bitacora();
        Bitacora b2 = new Bitacora();
        Bitacora b3 = new Bitacora();
        Bitacora b4 = new Bitacora();
        Bitacora b5 = new Bitacora();
        Bitacora b6 = new Bitacora();
        Bitacora b7 = new Bitacora();
        Bitacora b8 = new Bitacora();
        Bitacora b9 = new Bitacora();

        Local l1 = new LabDoc("lll", 24, "Estudiar", 4, b1);
        Local l2 = new LocalColectInvest("sss", 20, "a", 10, b2);
        Local l3 = new LabProy("ttt", 16, "proyectos", 14, b3);
        Local l4 = new LabDoc("ooo", 24, "ed", 20, b4);

        Computadora c1 = new Computadora("Rota", 1, l1, b5);
        Computadora c2 = new Computadora("Libre", 32, l2, b6);
        Computadora c3 = new Computadora("Ocupada", 54, l3, b7);
        Computadora c4 = new Computadora("Libre", 65, l4, b8);
        Computadora c5 = new Computadora("rota", 45, l2, b9);

        //Adds
        Facultad f1 = new Facultad();
//        try {
//            f1.cargarFacultad("./datos.dat");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try {
            l1.addPc(c1);
            l2.addPc(c2);
            l3.addPc(c3);
            l4.addPc(c4);
            l4.addPc(c5);
        } catch (ExisteException ex) {
            System.out.println("ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");;
        }

        try {
            f1.addLocal(l1);
            f1.addLocal(l2);
            f1.addLocal(l3);
            f1.addLocal(l4);
            f1.guardarFacultad("C:/Universidad/1er Año/2do Semestre/POO/Proyectos/Proyecto Final/laboratorio-computacion/LabComputacion/Personas.txt");
        } catch (ExisteException e) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11111");
        }
        c2.getBitacoraPc().addElemento(p5, "12:00 pm", "2:00 pm", "2025-01-15");
        l2.getBitacoraLocal().addElemento(p5, "12:00 pm", "2:00 pm", "2025-01-15");

        c4.getBitacoraPc().addElemento(p6, "11:00 am", "2:00 pm", "2025-05-06");
        l4.getBitacoraLocal().addElemento(p6, "11:00 am", "2:00 pm", "2025-05-06");
        c4.getBitacoraPc().addElemento(p1, "2:00 pm", "6:00 pm", "2025-05-06");
        l4.getBitacoraLocal().addElemento(p1, "2:00 pm", "6:00 pm", "2025-05-06");

        System.out.println("Bitacora local 2");
        l2.getBitacoraLocal().mostrarBitacoraFecha("13/03/2025");
        System.out.println("");

        System.out.println("Bitacora local 4");
        l4.getBitacoraLocal().mostrarBitacoraFecha("12/04/2025");
        System.out.println("");

        System.out.println("Bitacora pc 4");
        c4.getBitacoraPc().mostrarBitacoraFecha("48/02/2025");
        System.out.println("");

        System.out.println("Tiempo de uso local 4");
        double tuso = l4.getBitacoraLocal().calcTiempoUso();
        System.out.println("" + tuso);
        System.out.println("");

        System.out.println("Tiempo de uso de la persona 5 en la pc 2");
        double tusop = c2.getBitacoraPc().calcTiempoPersona("eee");
        System.out.println("" + tusop);
        System.out.println("");

        System.out.println("Porciento de aprovechamiento local 4");
        double pca = l4.getBitacoraLocal().calcPorcAprov(l4.getTiempoUso());
        System.out.println("" + pca);
        System.out.println("");

        System.out.println("Buscar info de una persona de la facultad");
        System.out.println("" + f1.buscarInfoPersona("eee"));
        System.out.println("");

        System.out.println("Persona destacada");
        System.out.println("" + f1.buscarPersona());
        System.out.println("");

        System.out.println("Mejor Porciento");
        System.out.println("" + f1.mejorPorc());
        System.out.println("");

        System.out.println("Peor Porciento");
        System.out.println("" + f1.peorPorc());
        System.out.println("");

        System.out.println("Bitacora de fecha");
        System.out.println("" + l4.getBitacoraLocal().mostrarBitacoraFecha("2025-05-06"));

//        Facultad f2 = new Facultad();
//        try {
//            f2.cargarPersonas(personasFiles);
//            System.out.println("Personas cargadas:" + f2.getPersonas().size());
//            for (Persona p : f2.getPersonas()) {
//                System.out.println(p.getClass().getSimpleName() + ": " + p.getNombre());
//            }
//        } catch (IOException e) {
//            System.err.println("Error cargando: " + e.getMessage());
//        }
    }
}
