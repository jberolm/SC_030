

/**
 * Write a description of interface Piloto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface Piloto
{
    public double getDestreza();
    public void setDestreza(double destreza);
    public String getNombre();
    public void setNombre(String nombre);
    public Coche getCoche();
    public void setCoche(Coche vehiculo);
    public double getConcentracion();
    public void setConcentracion(Concentracion concentracion);
    public void setResultados(String circuito, double tiempo, int puntos);
    public void setResultadosPuntos(String circuito, int puntos);
    public PuntuacionPiloto getResultados(String circuito);
    public boolean getDescalificado();
    public void setDescalificado(boolean descalificado);
    public int getPuntosAcumulados();
    public void setPuntosAcumulados(int puntos);
    public int getNumTotalCarreras();
    public void setNumTotalCarreras();
    public int getNumTotalAcabadas();
    public void setNumTotalAcabadas();
    public int getNumTotalAbandonos();
    public void setNumTotalAbandonos();
    public void mostrarPuntuacionCircuito();
    public int funcionPilotoCircuito(Circuito circuito, int limiteAbandonos);
    public int carrerasRealizadas();
}
