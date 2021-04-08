
/**
 * Write a description of class PuntuacionPiloto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PuntuacionPiloto
{
    private double tiempo;
    private int puntos;
    
    public PuntuacionPiloto(){
        tiempo=0;
        puntos=0;
    }
    public PuntuacionPiloto(double tiempo, int puntos){
        this.tiempo=tiempo;
        this.puntos=puntos;
    }    
    public void setTiempo(double tiempo){
        this.tiempo=tiempo;
    }
    public double getTiempo(){
        return tiempo;
    }
    public void setPuntos(int puntos){
        this.puntos=puntos;
    }
    public int getPuntos(){
        return puntos;
    }
}
