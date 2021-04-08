
import java.util.*;
public class Escuderia
{
    private String nombre;
    private List<Piloto> listaPilotos;
    private List<Coche> listaCoches;
    private ListIterator it;
    
    public Escuderia(){
        nombre=null;
        listaPilotos = new LinkedList<>();
        listaCoches = new LinkedList<>();
    }
    
    public Escuderia(String nombre){
        this.nombre = nombre;
        listaPilotos = new LinkedList<>();
        listaCoches = new LinkedList<>();
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
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre=nombre;
    }
    
    /**
     * Devuelve piloto de una posicion determinada
     *
     * @param index 
     * @return piloto
     */
    public Piloto getPiloto(int index){
        return listaPilotos.get(index);
    }
    
    /**
     * Devuelve la lista de piloto
     *
     * @return listaPilotos
     */
    public List<Piloto> getListaPiloto(){
        return listaPilotos;
    }
    
    /**
     * Añade un piloto a la lista de pilotos
     *
     * @param piloto 
     */
    public void setListaPiloto(Piloto piloto){
        listaPilotos.add(piloto);
    }
    
    /**
     * Muestra los pilotos de la lista de pilotos
     *
     */
    public void mostrarListaPiloto(){
        
        it = listaPilotos.listIterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        /*
        for(Piloto piloto: listaPilotos){
            System.out.println(piloto);
        }
        */
    }
    
    /**
     * Devuelve un coche de la lista de coches
     *
     * @param index 
     * @return coche
     */
    public Coche getListaCoche(int index){
        return listaCoches.get(index);
    }
    
    /**
     * Introduce un coche en la lista de coches
     *
     * @param coche 
     */
    public void setListaCoche(Coche coche){
        listaCoches.add(coche);
    }
    
    /**
     * Muestra la lista de coches
     *
     */
    public void mostrarListaCoche(){
        it = listaCoches.listIterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    
    /**
     * Muestra los pilotos con coche
     *
     */
    public void mostrarPilotosConCoche(){
        for(Piloto piloto: listaPilotos){
            if(piloto.getCoche()!=null)
                System.out.println(piloto);
        }
    }
    
    /**
     * Ordena la lista de coches segun el orden que deseemos
     *
     * @param nombre 
     */
    public void ordenarListaCoches(String nombre){
        switch(nombre){
            case "CombustibleAsc":
                Collections.sort(listaCoches, new ComparadorCombustibleCoche());
                break;
            case "CombustibleDesc":
                Collections.sort(listaCoches, Collections.reverseOrder(new ComparadorCombustibleCoche()));
        }
    }
    
    /**
     * Ordena la lista de pilotos segun el orden que deseemos
     *
     * @param nombre 
     */
    public void ordenarListaPilotos(String nombre){
        switch(nombre){
            case "DestrezaAsc":
                Collections.sort(listaPilotos, new ComparadorDestrezaPiloto());
                break;
            case "DestrezaDesc":
                Collections.sort(listaPilotos, Collections.reverseOrder(new ComparadorDestrezaPiloto()));
                break;
            case "PuntosDestrezaAsc":
                Collections.sort(listaPilotos, new ComparadorPuntosDestrezaPiloto());
                break;
            case "PuntosDestrezaDesc":
                Collections.sort(listaPilotos, Collections.reverseOrder(new ComparadorPuntosDestrezaPiloto()));
                break;
            case "CarrerasTerminadasAsc":
                Collections.sort(listaPilotos, new ComparadorCarrerasTerminadasPiloto());
                break;
            case "CarrerasTerminadasDesc":
                Collections.sort(listaPilotos, Collections.reverseOrder(new ComparadorCarrerasTerminadasPiloto()));
                break;
            case "PuntosCarrerasTerminadasAsc":
                Collections.sort(listaPilotos, new ComparadorPuntosCarrerasTerminadasPiloto());
                break;
            case "PuntosCarrerasTerminadasDesc":
                Collections.sort(listaPilotos, Collections.reverseOrder(new ComparadorPuntosCarrerasTerminadasPiloto()));
                break;
        }
    }
    
    
    /**
     * Devuelve los puntos totales entre todos los pilotos de cada escudería
     *
     * @return puntosTotal
     */
    public int puntosEscuderia(){
        int puntosTotal=0;
        for(Piloto piloto: listaPilotos){
            puntosTotal+= piloto.getPuntosAcumulados();
        }
        return puntosTotal;
    }
    
    /**
     * Devuelve el numero total de carreras realizadas por todos los pilotos de cada escuderia
     *
     * @return carrerasTotal
     */
    public int carrerasTerminadas(){
        int carrerasTotal=0;
        for(Piloto piloto: listaPilotos){
            carrerasTotal+=piloto.carrerasRealizadas();
        }
        return carrerasTotal;
    }
    
    /**
     * Da los coches de la lista de coches a los pilotos de la listade pilotos en orden, es decir, el primero va para el primero, siempre que el piloto
     * no esté descalificado y que el coche tenga combustible.
     *
     * @param limitePilotos Un parámetro
     * @param ordenaPilot Un parámetro
     * @param ordenaCoche Un parámetro
     * @return lista
     */
    public List<Piloto> repartirCochesEscuderia(int limitePilotos, String ordenaPilot, String ordenaCoche){
        int indexCoche=0;
        int indexMax=0;
        int indexPiloto=0;
        ordenarListaPilotos(ordenaPilot);
        ordenarListaCoches(ordenaCoche);
        Piloto p1;
        List<Piloto> lista = new LinkedList<>();
        Coche c1 = null;
        while(listaPilotos.size()>indexPiloto && indexMax<limitePilotos && listaCoches.size()!=0){
            p1 = listaPilotos.get(indexPiloto);
            c1=getListaCoche(indexCoche);
            if(!p1.getDescalificado() && c1.getCombustibleRestante()>0 && p1.getCoche()==null){
                p1.setCoche(c1);
                lista.add(p1);
                listaCoches.remove(indexCoche);
                indexMax++;
            }
            if(c1.getCombustibleRestante()<=0)
                indexCoche++;
            indexPiloto++;
        }
        indexPiloto=0;
        boolean existe=false;
        while(listaPilotos.size()>indexPiloto && indexMax<limitePilotos){
            p1 = listaPilotos.get(indexPiloto);
            if(p1.getCoche()==null && !p1.getDescalificado()){
                existe=true;
                System.out.println("¡¡¡ " + p1.getNombre() + " NO ES ENVIADO A LA CARRERA porque su escudería(" +
                getNombre() + ") no tiene más coches con combustible disponibles !!!");
                indexMax++;
            }
            indexPiloto++;
        }
        if(existe==false)
            System.out.println("********************************************************************************************************");
        return lista;
    }
    
    /**
     * Devuelve en una lista todos los pilotos de la lista de pilotos
     *
     * @return lista
     */
    public List<Piloto> devolverTodosLosPilotos(){
        List<Piloto> lista;
        lista=listaPilotos;
        return lista;
    }
    
    /**
     * Devuelve los pilotos y los coches a las listas de escudería
     *
     * @param lista Un parámetro
     * @param limitePiloto Un parámetro
     */
    public void devolverPilotosCochesColocados(List<Piloto> lista, int limitePiloto){
        int index=0;
        int indexPiloto=0;
        int cont=0;
        int tam=lista.size();
        while(cont!=limitePiloto && lista.size()!=0 && index!=tam){
            if(listaPilotos.size()==indexPiloto+1){
                indexPiloto=0;
                index++;
            }
            if(listaPilotos.get(indexPiloto).getCoche()!=null && listaPilotos.get(indexPiloto).getNombre()==lista.get(index).getNombre()){
                setListaCoche(lista.get(index).getCoche());
                lista.get(index).setCoche(null);
                listaPilotos.remove(indexPiloto);
                setListaPiloto(lista.get(index));
                lista.remove(index);
                indexPiloto=0;
                index=0;
                cont++;
                tam--;

            }
            else{
                indexPiloto++;    
            }
            
            
        }
        

    }
    
    /**
     * Devuelve true o false si en la lista de pilotos solo hay descalificados
     *
     * @return existe
     */
    public boolean listaPilotosDescalificados(){
        boolean existe=false;
        int index=0;
        while(listaPilotos.size()>index && !existe){
            if(listaPilotos.get(index).getDescalificado())
                existe=true;
            index++;
        }
        return existe;
    }
    
    /**
     * Devuelve el número de pilotos que hay en una escuderia
     *
     * @return cont
     */
    public int numPilotosEscuderia(){
        int cont=0;
        for(Piloto piloto: listaPilotos){
            cont++;
        }
        return cont;
    }
    
    /**
     * Devuelve cuantos pilotos descalificados hay en la lista
     *
     * @return cont
     */
    public int cuantosPilotosDescalificados(){
        int cont=0;
        for(Piloto piloto: listaPilotos){
            if(piloto.getDescalificado())
                cont++;
        }
        return cont;
    }
    
    /**
     * Devuelve escrito los pilotos descalificados con sus respectiva puntuacion
     *
     */
    public void mostrarPuntuaciosDescalificados(){
        ordenarListaPilotos("PuntosCarrerasTerminadasDesc");
        for(Piloto piloto: listaPilotos){
            if(piloto.getDescalificado()){
                System.out.println("--- Piloto Descalificado: " + piloto.getNombre() + " - Puntos Totales Anulados: " + piloto.getPuntosAcumulados() + " ---");
                piloto.mostrarPuntuacionCircuito();
                System.out.println("/n");
            }
        }
    }
}
