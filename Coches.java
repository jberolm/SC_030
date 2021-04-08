
/**
 * Write a description of interface Coches here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface Coches
{
    public String getNombre();
    public void setNombre(String nombre);
    public Velocidad getVelocidad();
    public void setVelocidad(Velocidad velocidad);
    public Combustible getCombustible();
    public void setCombustible(Combustible combustible);
    public double getVelocidadReal();
    public void setVelocidadReal(Piloto piloto, double complejidad);
    public void tiempoCarrera(double distancia);
    public double tiempoCarrera();
    public void setCombustibleRestante(double combustible);
    public double getCombustibleRestante();
    public double getNitro();
    public double setVelocidadRealNitro();
    public double getReserva();
    public void utilizarReserva(double distancia);
    
}
