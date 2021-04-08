
/**
 * Write a description of class CocheResistente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CocheResistente extends Coche
{
    private double reserva;
    /**
     * CocheResistente Constructor
     *
     */
    public CocheResistente(){
        super();
        reserva=100;
    }
    
    /**
     * CocheResistente Constructor
     *
     * @param nombre Un parámetro
     * @param velocidad Un parámetro
     * @param combustible Un parámetro
     */
    public CocheResistente(String nombre, Velocidad velocidad, Combustible combustible){
        super(nombre,velocidad,combustible);
        reserva=100;
    }
    
    /**
     * Método getReserva
     *
     * @return reserva
     */
    @Override
    public double getReserva(){
        return reserva;
    }
    
    /**
     * Utiliza la reserva si no tiene suficiente combustible
     *
     * @param combustible Un parámetro
     */
    @Override
    public void utilizarReserva(double combustible){
        if(reserva>0 && combustible>getCombustibleRestante()){
            combustibleRestante+=reserva;
            reserva=0;
        }
    }
    /**
     * Método toString
     *
     * @return El valor de retorno
     */
    @Override
    public String toString(){
        return "<coche: " + getNombre() + "> <tipo: " +
        getClass().getSimpleName() + "> <vel_teó: " +
        getVelocidad().getValor() + "> <comb: " +
        getCombustible().toString() + "(actual:" +
        getCombustibleRestante() + ")> <reserva: "
        + getReserva();
    }
}
