
/**
 * Write a description of class CocheRapido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CocheRapido extends Coche
{
    private double nitro;
    /**
     * CocheRapido Constructor
     *
     */
    public CocheRapido(){
        super();
        nitro=80.0;
    }
    
    /**
     * CocheRapido Constructor
     *
     * @param nombre Un parámetro
     * @param velocidad Un parámetro
     * @param combustible Un parámetro
     */
    public CocheRapido(String nombre, Velocidad velocidad, Combustible combustible){
        super(nombre,velocidad,combustible);
        nitro=80.0;
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
        getCombustibleRestante() + ")> <nitroPendiente: " +
        getNitro() + ">";
    }
    
    /**
     * Método getNitro
     *
     * @return nitro
     */
    @Override
    public double getNitro(){
        return nitro;
    }
    
    /**
     * Velocidad real con el nitro
     *
     * @return velocidad real
     */
    @Override
    public double setVelocidadRealNitro(){
        double i=0.0;
        if(nitro>0.0){
            i=getVelocidadReal()*0.2;
            if(i<nitro){
                velocidadReal+=i;
                nitro=nitro-i;
            }
            else{
                i=getVelocidadReal()*(nitro/100);
                velocidadReal+=i;
                nitro=0;
            }
        }
        return i;
    }
}
