import java.util.*;
/**
 * Write a description of class Organizacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Organizacion
{
    private static Organizacion instance;
    
    private int limiteAbandonos;
    private int limitePilotos;
    private TreeSet<Circuito> circuitos;
    private List<Escuderia> escuderias;
    private List<Piloto> pilotosCarrera;
    
    //Singleton
    /**
     * Organizacion Constructor, hay que destacar que es un patron de diseño llamado singleton, que solo permite crear una unica instancia
     *
     * @param limiteAbandonos Un parámetro
     * @param limitePilotos Un parámetro
     */
    private Organizacion(int limiteAbandonos, int limitePilotos){
        this.limiteAbandonos=limiteAbandonos;
        this.limitePilotos=limitePilotos;
        circuitos = new TreeSet<>(Collections.reverseOrder(new ComparadorDistanciaCircuito()));
        escuderias = new LinkedList<>();
        pilotosCarrera = new LinkedList<>();
    }
    
    /**
     * Método getInstance parte del singleton
     *
     * @param limiteAbandonos Un parámetro
     * @param limitePilotos Un parámetro
     * @return El valor de retorno
     */
    public synchronized static Organizacion getInstance(int limiteAbandonos, int limitePilotos){
        if(instance == null){
            instance = new Organizacion(limiteAbandonos,limitePilotos);
        }
        return instance;
    }
    
    /**
     * La inscripcion de escuderia
     *
     * @param e Un parámetro
     */
    public void inscripcionEscuderia(Escuderia e){
        escuderias.add(e);
    }
    
    /**
     * Añadir piloto a la lista pilotosCarrera
     *
     * @param piloto Un parámetro
     */
    public void setPilotosCarrera(Piloto piloto){
        pilotosCarrera.add(piloto);
    }
    
    /**
     * Obtener piloto de la lista de una determinada posicion
     *
     * @param index Un parámetro
     * @return piloto
     */
    public Piloto getPilotoCarrera(int index){
        return pilotosCarrera.get(index);
    }
    
    /**
     * Muestra los pilotos de la lista
     *
     */
    public void mostrarPilotosCarrera(){
        for(Piloto piloto: pilotosCarrera){
            System.out.println(piloto);
        }
    }
    
    /**
     * Devuelve escuderia de una determinada posicion de la lista escuderias
     *
     * @param index Un parámetro
     * @return escuderia
     */
    public Escuderia getEscuderia(int index){
        return escuderias.get(index);
    }
    
    /**
     * Devuelve la lista de escuderias
     *
     * @return escuderias
     */
    public List<Escuderia> getListaEscuderia(){
        return escuderias;
    }
    
    /**
     * Insertar circuitos al treeset de circuito
     *
     * @param circuito Un parámetro
     */
    public void insertarCircuitos(Circuito circuito){
        circuitos.add(circuito);
    }
    
    /**
     * Mostrar los circuitos de la organizacion
     *
     */
    public void mostrarCircuitos(){
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||| CIRCUITOS DEL CAMPEONATO |||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        for(Circuito circuito: circuitos){
            System.out.println(circuito);
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\n");
    }
    
    
    /**
     * Mostrar las escuderias que van a competir
     *
     */
    public void mostrarEscuderias(){
        Collections.sort(escuderias, Collections.reverseOrder(new ComparadorPuntosYCarrerasTotales()));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%% ESCUDERÍAS DEL CAMPEONATO %%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        for(Escuderia escuderia: escuderias){
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("%%%" + escuderia.getNombre() + "%%%");
            escuderia.mostrarListaPiloto();
            escuderia.mostrarListaCoche();
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
        System.out.println("\n");
    }
    
    
    /**
     * Comprueba que si están todos los pilotos descalificados
     *
     * @return existe
     */
    public boolean piltosDescalificados(){
        boolean existe=false;
        int cont=0;
        int indexEscuderia=0;
        for(Escuderia e: escuderias){
            if(e.listaPilotosDescalificados())
                cont++;
            indexEscuderia++;
        }
        if(cont==indexEscuderia)
            existe=true;
        return existe;
    }
    
    /**
     * Comprueba si solo queda un piloto para competir
     *
     * @return existe
     */
    public boolean soloUnPiloto(){
        boolean existe=false;
        int cont=0;
        int todosLosPilotos=0;
        for(Escuderia e: escuderias){
            todosLosPilotos+=e.numPilotosEscuderia();
            cont+=e.cuantosPilotosDescalificados();
        }
        todosLosPilotos--;
        if(todosLosPilotos==cont)
            existe=true;
        return existe;
    }
    
    /**
     * Se finaliza la competicion cuando se da los dos metodos anteriores
     *
     * @return true or false
     */
    public boolean CondicionFinalizacion(){
        return (piltosDescalificados() || soloUnPiloto());
    }
    
    /**
     * Muestra la puntuacion final si hay ganadores
     *
     */
    public void mostrarPuntuacionFinal(){
        System.out.println("****************************************************");
        System.out.println("**************** FIN DEL CAMPEONATO ****************");
        System.out.println("****************************************************");
        int index=1;
        for(Piloto piloto: pilotosCarrera){
            if(!piloto.getDescalificado()){
                System.out.println("@@@ Posición(" + index + "): " + piloto.getNombre() + " - Puntos Totales: " + piloto.getPuntosAcumulados() + " @@@");
                piloto.mostrarPuntuacionCircuito();
                System.out.println("/n");
                index++;
            }
        }
    }
    
    /**
     * Muestra todas las puntuaciones de los pilotos descalificados
     *
     */
    public void mostrarPuntuacionPilotosDescalificados(){
        System.out.println("****************************************************");
        System.out.println("************** PILOTOS DESCALIFICADOS **************");
        System.out.println("****************************************************");
        for(Escuderia e: escuderias){
            e.mostrarPuntuaciosDescalificados();
        }
        System.out.println("\n");
    }
    
    /**
     * Muestra las escuderias descalificadas por no tener ningun piloto sin descalificar
     *
     */
    public void mostrarEscuderiasDescalificadas(){
        Collections.sort(escuderias, Collections.reverseOrder(new ComparadorPuntosYCarrerasTotales()));
        System.out.println("****************************************************");
        System.out.println("************ ESCUDERIAS DESCALIFICADAS *************");
        System.out.println("****************************************************");
        for(Escuderia e: escuderias){
            if(e.listaPilotosDescalificados()){
                System.out.println("¡¡¡ Escudería Descalificada: " + e.getNombre() + " con 0.0 puntos !!!");
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                System.out.println("%%% " + e.getNombre() + " %%%");
                e.mostrarListaPiloto();
                e.mostrarListaCoche();
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            }
        }
    }
    
    /**
     * Esto en el caso de que todos los pilotos estén descalificados
     *
     */
    public void ganadorDesierto(){
        if(piltosDescalificados()){
            System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
            System.out.println("¡¡¡ No se celebra esta carrera ni la(s) siguiente(s) por no haber pilotos para competir !!!!");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("****************************************************");
            System.out.println("**************** FIN DEL CAMPEONATO ****************");
            System.out.println("****************************************************");
            System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
            System.out.println("¡¡¡ Campeonato de pilotos queda desierto por haber sido descalificados todos los pilotos !!!");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            mostrarPuntuacionPilotosDescalificados();
            System.out.println("\n");
            System.out.println("****************************************************");
            System.out.println("******** CLASIFICACIÓN FINAL DE ESCUDERÍAS *********");
            System.out.println("****************************************************");
            System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
            System.out.println("¡¡¡ Campeonato de escuderías queda desierto por haber sido descalificados todos los pilotos !!!");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            mostrarEscuderiasDescalificadas();
        }
    }
    
    /**
     * Realiza la funcion de piloto en un circuito e imprime los resultados
     *
     * @param piloto Un parámetro
     * @param circuito Un parámetro
     */
    public void carreraTerminadaPorPilotoConCoche(Piloto piloto, Circuito circuito){
        if(piloto.getCoche().getClass().getSimpleName()=="CocheRapido"){
            System.out.println("+++ El " + piloto.getCoche().getNombre() + " usa " + piloto.getCoche().setVelocidadRealNitro() + " de nitro para alcanzar " 
            + piloto.getCoche().getVelocidadReal() + " km/hora y el nitro restante es " + piloto.getCoche().getNitro() + " +++");
        }
        piloto.getCoche().tiempoCarrera(circuito.getDistancia());
        if(piloto.getCoche().getClass().getSimpleName()=="CocheResistente"){
            if(piloto.getCoche().tiempoCarrera()>piloto.getCoche().getCombustibleRestante()){
                piloto.getCoche().utilizarReserva(circuito.getDistancia());
                System.out.println("+++ El " + piloto.getCoche().getNombre() + " usa " + " 100 litros de reserva para alcanzar " 
                + piloto.getCoche().getCombustibleRestante() + " litros y la reserva restante es " + piloto.getCoche().getReserva() + " +++");
            }
        }
        int index=piloto.funcionPilotoCircuito(circuito, limiteAbandonos);
        switch (index){
            case 1:
                System.out.println("+++ " + piloto.getNombre() + " termina la carrera en " + piloto.getCoche().tiempoCarrera() + "minutos +++");
                break;
            case 2:
                System.out.println("¡¡¡ " + piloto.getNombre() + " perdió la concentración a falta de " 
                + (piloto.getCoche().tiempoCarrera()-piloto.getConcentracion()) + " minutos para terminar !!!");
                System.out.println("¡¡¡ En el momento del despiste llevaba en carrera " + piloto.getConcentracion() + " minutos !!!");
                break;
            case 3:
                System.out.println("¡¡¡ El  " + piloto.getCoche().getNombre() + " se quedó sin combustible a falta de " + 
                (piloto.getCoche().getCombustibleRestante()-piloto.getCoche().tiempoCarrera()) + " minutos para terminar !!!");
                System.out.println("¡¡¡ En el momento de quedarse sin combustible llevaba en carrera "+ piloto.getCoche().getCombustibleRestante() + " minutos !!!");
                break;
            case 4:
                System.out.println("¡¡¡ " + piloto.getNombre() + " es DESCALIFICADO del campeonato por alcanzar el límite de abandonos(" + limiteAbandonos + ") !!!");
                break;
        } 
    }
    
    
    /**
     * Clasificacion de los pilotos por carrera
     *
     * @param circuito Un parámetro
     */
    public void clasificacionFinalPorCarrera(Circuito circuito){
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++ Clasificación final de la carrera en " + circuito.getNombre() + " ++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        int posicion=1;
        int posicionesConPuntos=4;
        int puntos=10;
        Collections.sort(pilotosCarrera, Collections.reverseOrder(new ComparadorTiempo()));
        for(Piloto piloto: pilotosCarrera){
            if(piloto.getConcentracion()>piloto.getCoche().tiempoCarrera() && (piloto.getCoche().getCombustibleRestante()+piloto.getCoche().tiempoCarrera())>piloto.getCoche().tiempoCarrera()){
                System.out.println("@@@ Posición(" + posicion + "): " + piloto.getNombre() + " - Tiempo: " 
                + piloto.getCoche().tiempoCarrera() + " minutos - Puntos: " + puntos + " @@@");
                piloto.setResultadosPuntos(circuito.getNombre(), puntos);
                if(posicion<=posicionesConPuntos)
                    puntos-=2;
                posicion++;
            }
        }
        for(Piloto piloto: pilotosCarrera){
        
            if(!piloto.getDescalificado()){
                if(piloto.getConcentracion()<piloto.getCoche().tiempoCarrera()){  
                    System.out.println("¡¡¡ Ha abandonado " + piloto.getNombre() + " - Tiempo: " 
                    + (piloto.getConcentracion()-piloto.getCoche().tiempoCarrera()) + " minutos - Puntos: 0 !!!");
                    
                }
                if((piloto.getCoche().getCombustibleRestante()+piloto.getCoche().tiempoCarrera())<piloto.getCoche().tiempoCarrera()){
                    System.out.println("¡¡¡ Ha abandonado " + piloto.getNombre() + " - Tiempo: " 
                    + (piloto.getCoche().getCombustibleRestante()-piloto.getCoche().tiempoCarrera()) + " minutos - Puntos: 0 !!!");
                }
                piloto.setResultados(circuito.getNombre(), piloto.getCoche().tiempoCarrera(), 0);    
            }
            else{
                System.out.println("¡¡¡ Ha abandonado " + piloto.getNombre() + " - Tiempo: " 
                + piloto.getCoche().tiempoCarrera() + " minutos - Puntos: 0 - Además ha sido descalificado para el resto del Campeonato !!!");
                piloto.setResultados(circuito.getNombre(), piloto.getCoche().tiempoCarrera(), 0);
            }
            
        }
        
        
    }
    
    /**
     * La gestion de la carrera
     *
     * @param c Un parámetro
     * @param indexCarrera Un parámetro
     * @param ordenaPiloto Un parámetro
     * @param ordenaCoche Un parámetro
     */
    public void gestionDeCarreras(Circuito c,int indexCarrera, String ordenaPiloto, String ordenaCoche){
        
        int indexPosicion=1;
        List<Piloto> listaPilotoAux = new LinkedList<Piloto>();
        
        System.out.println("********************************************************************************************************");
        System.out.println("*** CARRERA<" + indexCarrera + "> EN " + c + " ***");
        System.out.println("********************************************************************************************************");
        for(Escuderia e: escuderias){
            listaPilotoAux=e.repartirCochesEscuderia(limitePilotos,ordenaPiloto,ordenaCoche);
            for(Piloto piloto: listaPilotoAux){
                setPilotosCarrera(piloto);
            }
            listaPilotoAux=null;
        }
        if(pilotosCarrera.size()>1){
            System.out.println("********************************************************************************************************");
            System.out.println("******************************** Pilotos que van a competir en " + c.getNombre() + " *******************************");
            System.out.println("********************************************************************************************************");
            Collections.sort(pilotosCarrera, new ComparadorPuntosCarrerasTerminadasPiloto());
            mostrarPilotosCarrera();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++ Comienza la carrera en " + c.getNombre() + " ++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            for(Piloto piloto: pilotosCarrera){
                System.out.println("@@@ Piloto " + indexPosicion + " de " + pilotosCarrera.size());
                System.out.println(piloto + " con");
                System.out.println(piloto.getCoche());
                piloto.getCoche().setVelocidadReal(piloto, c.getComplejidad());
                System.out.println("+++ Con estas condiciones es capaz de correr a " + piloto.getCoche().getVelocidadReal() + " km/hora +++");
                carreraTerminadaPorPilotoConCoche(piloto, c);
                indexPosicion++;
            }
            clasificacionFinalPorCarrera(c);
        }
        
        for(Escuderia e: escuderias){
            e.devolverPilotosCochesColocados(pilotosCarrera, limitePilotos);
        }
        
    }
    
    /**
     * RALLY el juego
     *
     * @param ordenarPilotos Un parámetro
     * @param ordenarCoches Un parámetro
     */
    public void rallyFinal(String ordenarPilotos, String ordenarCoches){
        mostrarCircuitos();
        mostrarEscuderias();
        int index=1;
        boolean existe=false;
        for(Circuito c: circuitos){
            if(!CondicionFinalizacion()){
                for(Escuderia e: escuderias){
                    e.ordenarListaCoches(ordenarCoches);
                    e.ordenarListaPilotos(ordenarPilotos);
                }
                gestionDeCarreras(c,index,ordenarPilotos,ordenarCoches);
                index++;
            }
            else
                existe=true;
            
        }
        
        List<Piloto> listaPilotAux = new LinkedList<Piloto>();
        pilotosCarrera=listaPilotAux;
        for(Escuderia e: escuderias){
            listaPilotAux=e.devolverTodosLosPilotos();
            for(Piloto p: listaPilotAux){
                pilotosCarrera.add(p);
            }
        }
        
        Collections.sort(pilotosCarrera, Collections.reverseOrder(new ComparadorPuntosCarrerasTerminadasPiloto()));
        
        if(existe){
            if(piltosDescalificados())
                ganadorDesierto();
            else{
                mostrarPuntuacionPilotosDescalificados();
                mostrarEscuderiasDescalificadas();
            }
        }
        else{
            mostrarPuntuacionFinal();
            mostrarPuntuacionPilotosDescalificados();
            
        }
        
    }
}
