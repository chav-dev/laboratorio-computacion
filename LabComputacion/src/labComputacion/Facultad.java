package labComputacion;

import java.util.ArrayList;

/**
 *
 * @author Chavelys
 */
public class Facultad {
    private ArrayList<Local> locales;
    
    public Facultad(ArrayList<Local> locales) {
        this.locales = locales;
    }

    public String mejorPorc(Bitacora bitacora){
        double mejorPorc = bitacora.calcPorcAprov(0);
        String nombre = "";
        
        for (int i = 1; i < locales.size(); i++) {
           if(bitacora.calcPorcAprov(i) < mejorPorc){
               mejorPorc = bitacora.calcPorcAprov(i);
               nombre = locales.get(i).getNombre();
           }
        }
        return nombre;
    }
    
    public String peorPorc(Bitacora bitacora){
        double peorPorc = bitacora.calcPorcAprov(0);
        String nombre = "";
        
        for (int i = 1; i < locales.size(); i++) {
           if(bitacora.calcPorcAprov(i) > peorPorc){
               peorPorc = bitacora.calcPorcAprov(i);
               nombre = locales.get(i).getNombre();
           }
        }
        return nombre;
    }
}
