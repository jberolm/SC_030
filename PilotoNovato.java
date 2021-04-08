import java.lang.*;
import java.util.*;
public class PilotoNovato extends AbstractPiloto {
    /**
     * PilotoNovato Constructor por defecto
     *
     */
    public PilotoNovato() {
        super();
    }
    
    /**
     * PilotoNovato Constructor parametrizado, calcula su destreza
     *
     * @param nombre Un parámetro
     * @param concentracion Un parámetro
     */
    public PilotoNovato(String nombre, Concentracion concentracion) {
        super(nombre, concentracion);
        double d = ((concentracion.getValor()*0.97)/120)-0.03;
        int r = (int) Math.round(d*100); 
        double f = r/100.0;
        setDestreza(f);
    }
}

