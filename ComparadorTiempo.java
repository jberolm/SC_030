import java.util.*;
public class ComparadorTiempo implements Comparator<Piloto>
{
    public int compare(Piloto p1, Piloto p2){
        if(p1.getCoche().tiempoCarrera() == p2.getCoche().tiempoCarrera()){
            return (p1.getNombre().compareTo(p2.getNombre()));
        }
        else if(p1.getCoche().tiempoCarrera() > p2.getCoche().tiempoCarrera())
            return 1;
        else
            return -1;
    }
}
