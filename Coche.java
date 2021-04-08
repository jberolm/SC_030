
/**
 * Write a description of class Coche here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coche implements Coches
{
    private String nombre;
    private Velocidad velocidad;
    private Combustible combustible;
    protected double velocidadReal;
    protected double combustibleRestante;
    private double tiempo;
    
    /**
     * Coche Constructor
     *
     */
    public Coche(){
        this.nombre = null;
        this.velocidad = null;
        this.combustible = null;
        this.velocidadReal = 0.0;
        this.combustibleRestante = 0.0;
        this.tiempo = 0.0;
    }
    /**
     * Coche Constructor
     *
     * @param nombre Un parámetro
     * @param velocidad Un parámetro
     * @param combustible Un parámetro
     */
    public Coche(String nombre, Velocidad velocidad, Combustible combustible) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.combustible = combustible;
        this.velocidadReal = velocidad.getValor();
        this.combustibleRestante = combustible.getValor();
        this.tiempo = 0.0;
    }

    /**
     * Método getNombre
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método setNombre
     *
     * @param nombre Un parámetro
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método getVelocidad
     *
     * @return velocidad
     */
    public Velocidad getVelocidad() {
        return velocidad;
    }

    /**
     * Método setVelocidad
     *
     * @param velocidad Un parámetro
     */
    public void setVelocidad(Velocidad velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * Método getCombustible
     *
     * @return combustible
     */
    public Combustible getCombustible() {
        return combustible;
    }

    /**
     * Método setCombustible
     *
     * @param combustible Un parámetro
     */
    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }
    
    /**
     * Método getVelocidadReal
     *
     * @return VelocidadReal
     */
    public double getVelocidadReal(){
        return velocidadReal;
    }
    
    /**
     * Método setVelocidadReal
     *
     * @param piloto Un parámetro
     * @param complejidad Un parámetro
     */
    public void setVelocidadReal(Piloto piloto, double complejidad) {
        double d = (getVelocidad().getValor() * piloto.getDestreza())/complejidad; 
        int r = (int) Math.round(d*100); 
        double f = r/100.0;
        velocidadReal = f;   
    }
    
    /**
     * Método tiempoCarrera
     *
     * @param distancia Un parámetro
     */
    public void tiempoCarrera(double distancia) {
        double d = (distancia/ getVelocidadReal()) * 60; 
        int r = (int) Math.round(d*100); 
        double f = r/100.0;
        tiempo = f;
    }
    
    /**
     * Método tiempoCarrera
     *
     * @return tiempo
     */
    public double tiempoCarrera(){
        return tiempo;
    }
    
    /**
     * Método setCombustibleRestante
     *
     * @param combustible Un parámetro
     */
    public void setCombustibleRestante(double combustible) {
        combustibleRestante -= combustible;
    }
    
    /**
     * Método getCombustibleRestante
     *
     * @return combustibleRestante
     */
    public double getCombustibleRestante(){
        return combustibleRestante;
    }
    
    /**
     * Método getNitro
     *
     * @return 0
     */
    public double getNitro(){
        return 0.0;
    }
    
    /**
     * Método setVelocidadRealNitro
     *
     * @return velocidadReal
     */
    public double setVelocidadRealNitro(){
        return velocidadReal;
    }
    
    /**
     * Método getReserva
     *
     * @return 0
     */
    public double getReserva(){
        return 0.0;
    }
    
    /**
     * Método utilizarReserva
     *
     * @param distancia Un parámetro
     */
    public void utilizarReserva(double distancia){
        setCombustibleRestante(distancia);
    }
    
    /**
     * Método toString
     *
     * @return El valor de retorno
     */
    public String toString(){
        return "<coche: " + getNombre() + "> <tipo: " +
        getClass().getSimpleName() + "Normal> <vel_teó: " +
        getVelocidad().getValor() + "> <comb: " +
        getCombustible().toString() + "(actual:" +
        getCombustibleRestante() + ")>";
    }
}
    
