

import java.util.*;
import java.lang.*;

public abstract class AbstractPiloto implements Piloto{
    private String nombre;
    private Coche vehiculo;
    private Concentracion concentracion;
    private double concent;
    private Map <String, PuntuacionPiloto> resultados;
    private boolean descalificado;
    private int puntosAcumulados;
    private int numTotalCarreras;
    private int numTotalAcabadas;
    private int numTotalAbandonos;
    private double destreza;
    
    
    //Constructor por defecto
    /**
     * Constructor por defecto
     *
     */
    protected AbstractPiloto(){
        nombre=null;
        vehiculo = null;
        concentracion=null;
        resultados= new HashMap <String, PuntuacionPiloto>();
        descalificado=false;
        puntosAcumulados=0;
        numTotalCarreras=0;
        numTotalAcabadas=0;
        numTotalAbandonos=0;
        destreza=0.0;
        
        
    }
    //Constructor parametrizado
    
    /**
     * Constructor parametrizado de la clase abstracta de piloto, solo se puede crear los tres tipos de piloto, no puedes crear un piloto sin más
     *
     * @param  Nombre como el nombre del piloto, concentracion como la concentracion del piloto
     * 
     */
    protected AbstractPiloto(String nombre, Concentracion concentracion) {
        this.nombre=nombre;
        this.vehiculo = null;
        this.concentracion=concentracion;
        this.resultados= new HashMap <String, PuntuacionPiloto>();
        this.descalificado=false;
        puntosAcumulados=0;
        numTotalCarreras=0;
        numTotalAcabadas=0;
        numTotalAbandonos=0;
        destreza=0.0;
    }
    
    /**
     * Devuelve la destreza del piloto
     *
     * 
     * @return     destreza
     */
    public double getDestreza() {
        return destreza;
    }
    
    /**
     * Introduce la destreza del piloto segun el tipo de piloto que tenga, es llamado en los hijos de la super clase(esta clase) y lo calcula
     *
     * @param  destreza, el valor de la destreza del piloto
     * 
     */
    public void setDestreza(double destreza) {
        this.destreza=destreza;
    }
    
    /**
     * Devuelve el nombre del piloto
     *
     * 
     * @return     nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Introduce el nombre del piloto
     *
     * @param  nombre
     * 
     */
    public void setNombre(String nombre) {
        this.nombre=nombre;
    }
    //Para que pueda recibir cualquier coche que queramos poner
    
    /**
     * Introduce el coche que va a utilizar el piloto
     *
     * @param  vehiculo
     * 
     */
    public void setCoche(Coche vehiculo) {
        this.vehiculo= vehiculo;
    }
    //Devuelve el coche del piloto
    
    /**
     * Devuelve el coche del piloto
     *
     * 
     * @return     vehiculo
     */
    public Coche getCoche(){
        return vehiculo;
    }
    //Devuelve el valor de la concentracion
    
    /**
     * Devuelve la concentracion que tiene el piloto
     *
     * 
     * @return     concentracion.getValor()
     */
    public double getConcentracion() {
        return concentracion.getValor();
    }
    
    /**
     * Introduce la concentracion del piloto
     *
     * @param  concentracion
     * 
     */
    public void setConcentracion(Concentracion concentracion) {
        this.concentracion=concentracion;
    }
    //Devuelve el resultado del tiempo en un determinado circuito
    
    /**
     * Devuelve los resultados del piloto en una carrera en concreto
     *
     * @param  circuito.getNombre()
     * @return     resultados.get(circuito)
     */
    public PuntuacionPiloto getResultados(String circuito) {
        return resultados.get(circuito);
    }
    //Inserta la puntuacion, tanto el tiempo como los puntos que ha hecho un piloto en un circuito
    
    /**
     * Introduce los resultados del piloto en una carrera en concreto
     *
     * @param  circuito.getNombre(), tiempo, puntos
     * 
     */
    public void setResultados(String circuito, double tiempo, int puntos) {
        resultados.put(circuito, new PuntuacionPiloto(tiempo,puntos));
    }
    //Devuelve si el piloto está descalificado
    
    /**
     * Introduce los puntos del piloto en una carrera en concreto
     *
     * @param  circuito.getNombre(), puntos
     * 
     */
    public void setResultadosPuntos(String circuito, int puntos){
        for (Map.Entry<String, PuntuacionPiloto> entry : resultados.entrySet()){
            if(entry.getKey()==circuito){
                resultados.put(circuito, new PuntuacionPiloto(entry.getValue().getTiempo(),puntos));
            }
        }
        puntosAcumulados+=puntos;
    }
    /**
     * Devuelve true or false si el piloto está descalificado de la competicion
     *
     * 
     * @return     descalificado
     */
    public boolean getDescalificado() {
        return descalificado;
    }
    
    //Pone descalificado a un piloto
    
    /**
     * Pone descalificado a un piloto
     *
     * @param  descalificado
     * 
     */
    public void setDescalificado(boolean descalificado) {
        this.descalificado=descalificado;
    }
    //Devuelve los puntos totales de las carreras que lleva
    
    /**
     * Devuelve los puntos acumulados que tiene un piloto
     *
     * 
     * @return     puntosAcumulados
     */
    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }
    //Aumenta los puntos totales que lleva
    
    /**
     * Incrementa los puntos acumulados del piloto
     *
     * @param  puntos
     * 
     */
    public void setPuntosAcumulados(int puntos) {
        puntosAcumulados+=puntos;
    }
    
    
    /**
     * Devuelve el total de carreras que ha participado
     *
     * @param  numTotalCarreras
     * 
     */
    public int getNumTotalCarreras() {
        return numTotalCarreras;
    }
    
    
    /**
     * Aumenta las carreras en las que ha participado
     *
     * 
     * @return     
     */
    public void setNumTotalCarreras() {
        numTotalCarreras++;
    }
    
    /**
     * Devuelve el numero total de carreras acabadas
     *
     * 
     * @return   numTotalAcabadas
     */
    public int getNumTotalAcabadas() {
        return numTotalAcabadas;
    }
    
    /**
     * Aumenta el numero de carreras acabadas
     *
     * 
     * 
     */
    public void setNumTotalAcabadas() {
        numTotalAcabadas++;
    }
    
    /**
     * Devuelve el numeros de abandonos totales
     *
     * 
     * @return   numTotalAbandonos
     */
    public int getNumTotalAbandonos() {
        return numTotalAbandonos;
    }
    
    /**
     * Aumenta el numero total de abandonos
     *
     * 
     * 
     */
    public void setNumTotalAbandonos() {
        numTotalAbandonos++;
    }
    
    /**
     * Muestra los resultados de piloto en cada circuito
     *
     * 
     * 
     */
    public void mostrarPuntuacionCircuito(){
        for (Map.Entry<String, PuntuacionPiloto> entry : resultados.entrySet()){
            System.out.println("Carrera(" + entry.getKey() + ") - Puntos:" + entry.getValue().getPuntos() + " - Tiempo:" + entry.getValue().getTiempo() + "minutos");
            
        }
    }
    
    /**
     * Como se ve el piloto cuando quieres imprimirlo
     *
     * 
     */
    public String toString(){
        return "<piloto: " + getNombre() + "> <tipo: " +
        getClass().getSimpleName() + "> <dest: " +
        getDestreza() + "> <conc: " + concentracion.getNombre() +
        "> <descalificado: " + getDescalificado() + ">";
    }
      /*La concentracion debería ser si, por ejemplo teniendo una concentración de 90, 
       * en un circuito se necesita 100, ya tiene falta de concentracion y por eso sería 
       * un abandono, necesitando 10 min m´s de concentración
       * En combustible, dependiendo de la longitud del circuito, si falta combustible,
       * también sería un abandono
       * 
       * *************ADVERTENCIA*****************
       * NECESIDAD DE SABER CLASE COCHE PARA MODIFICAR COSAS COMO
       * COMBUSTIBLE Y LOS CREADORES Y MODIFICADORES DE COCHE
       * NECESARIO TAMBIÉN SABER CIRCUITO
       */
  
    /**
     * Piloto corriendo en un circuito, realiza la funcion de darle el resultado de tiempo dependiendo de como acabe la carrera, además
     * de que si ha abandonado el limite de veces, pone al piloto como descalificado de la competicion, para saber que funcion realiza el piloto
     * en el circuito devuelve varios resultados:
     * 1:Carrera completada
     * 2:Abandona Carrera
     * 3:Abandona competicion
     * 4: Combustible insuficiente
     *
     * @param  circuito.getNombre()
     * 
     */
    public int funcionPilotoCircuito(Circuito circuito, int limiteAbandonos) {
        int resultado=0;
        numTotalCarreras++;
        getCoche().tiempoCarrera(circuito.getDistancia());
        
        if(getConcentracion()>getCoche().tiempoCarrera() && getCoche().getCombustibleRestante()>getCoche().tiempoCarrera()) { 
            getCoche().setCombustibleRestante(getCoche().tiempoCarrera());
            setResultados(circuito.getNombre(),getCoche().tiempoCarrera(),0);
            numTotalAcabadas++;
            resultado=1;
        }
        else {
            if(concentracion.getValor()<getCoche().tiempoCarrera()) {
                setResultados(circuito.getNombre(),concentracion.getValor()-getCoche().tiempoCarrera(),0);
                getCoche().setCombustibleRestante(concentracion.getValor());
                numTotalAbandonos++;
                resultado=2;
                if(numTotalAbandonos==limiteAbandonos){
                    descalificado=true;
                    resultado=4;
                }
            }
            else{
                if(getCoche().getCombustibleRestante()<getCoche().tiempoCarrera()) {
                    setResultados(circuito.getNombre(),getCoche().getCombustibleRestante()-getCoche().tiempoCarrera(),0);
                    getCoche().setCombustibleRestante(getCoche().getCombustibleRestante());
                    resultado=3;
                    //guardar en resultados el número negativo que indica los minutos de combustible extra que hubiera necesitado para para poder terminar la carrera.
                }
            }
            
        }
        return resultado;
    }
    
    /**
     * Muestra el numero de carreras realizadas
     *
     * 
     * @return     carreras
     */
    public int carrerasRealizadas(){
        int carreras=0;
        for (Map.Entry<String, PuntuacionPiloto> entry : resultados.entrySet()){
            if(entry.getKey()!=null){
                carreras++;
            }
        }
        return carreras;
    }
    
    
}
