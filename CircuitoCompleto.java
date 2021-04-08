import java.util.*;
/**
 * Write a description of class CircuitoCompleto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircuitoCompleto
{
    public static void main(String[] args){
        Organizacion organizacion;
        organizacion = Organizacion.getInstance(2,2);
        
        Circuito c1 = new Circuitodec("Portugal", Complejidad.MEDIA, Distancia.CORTA);
        c1 = new Gravilla(c1);
        c1 = new Nocturno(c1);
        organizacion.insertarCircuitos(c1);
        c1=null;
        c1 = new Circuitodec("Cerdeña", Complejidad.ALTA, Distancia.CORTA);
        c1 = new Gravilla(c1);
        c1 = new Mojado(c1);
        organizacion.insertarCircuitos(c1);
        c1=null;
        c1 = new Circuitodec("Australia", Complejidad.BAJA, Distancia.LARGA);
        c1 = new Gravilla(c1);
        organizacion.insertarCircuitos(c1);
        c1=null;
        c1 = new Circuitodec("Corcega", Complejidad.MEDIA, Distancia.INTERMEDIA);
        c1 = new Nocturno(c1);
        c1 = new Gravilla(c1);
        organizacion.insertarCircuitos(c1);
        c1=null;
        c1 = new Circuitodec("Finlandia", Complejidad.ALTA, Distancia.CORTA);
        c1 = new Nocturno(c1);
        c1 = new Frio(c1);
        c1 = new Mojado(c1);
        organizacion.insertarCircuitos(c1);
        c1=null;
        c1 = new Circuitodec("Alemania", Complejidad.MEDIA, Distancia.INTERMEDIA);
        c1 = new Mojado(c1);
        organizacion.insertarCircuitos(c1);
        c1=null;
        c1 = new Circuitodec("Chile", Complejidad.ALTA, Distancia.CORTA);
        c1 = new Gravilla(c1);
        organizacion.insertarCircuitos(c1);
        
        Escuderia e1 = new Escuderia("Peugeot");
        e1.ordenarListaPilotos("PuntosDestrezaDesc");
        e1.ordenarListaCoches("CombustibleDesc");
        organizacion.inscripcionEscuderia(e1);
        e1=null;
        e1 = new Escuderia("Citroen");
        e1.ordenarListaPilotos("PuntosDestrezaAsc");
        e1.ordenarListaCoches("CombustibleAsc");
        organizacion.inscripcionEscuderia(e1);
        e1=null;
        e1 = new Escuderia("Seat");
        e1.ordenarListaPilotos("PuntosDestrezaAsc");
        e1.ordenarListaCoches("CombustibleAsc");
        organizacion.inscripcionEscuderia(e1);
        e1=null;
        
        
        for(Escuderia escuderia: organizacion.getListaEscuderia()){
            if(escuderia.getNombre()=="Citroen"){
                escuderia.setListaCoche(new CocheResistente("Citroen C5", Velocidad.RAPIDA, Combustible.ELEFANTE));
                escuderia.setListaCoche(new CocheRapido("Citroen C4", Velocidad.RAPIDA, Combustible.ESCASO));
                escuderia.setListaCoche(new Coche("Citroen C3", Velocidad.RAPIDA, Combustible.ESCASO));
                escuderia.setListaPiloto(new PilotoExperimentado("Loeb", Concentracion.NORMAL));
                escuderia.setListaPiloto(new PilotoEstrella("Makinen", Concentracion.ZEN));
                escuderia.setListaPiloto(new PilotoNovato("Auriol", Concentracion.NORMAL));
            }
            if(escuderia.getNombre()=="Seat"){
                escuderia.setListaCoche(new CocheResistente("Seat Tarraco", Velocidad.TORTUGA, Combustible.GENEROSO));
                escuderia.setListaCoche(new CocheRapido("Seat Ateca", Velocidad.GUEPARDO, Combustible.GENEROSO));
                escuderia.setListaCoche(new Coche("Seat Arona", Velocidad.RAPIDA, Combustible.ESCASO));
                escuderia.setListaPiloto(new PilotoExperimentado("Ogier", Concentracion.NORMAL));
                escuderia.setListaPiloto(new PilotoEstrella("McRae", Concentracion.CONCENTRADO));
                escuderia.setListaPiloto(new PilotoNovato("Blomquist", Concentracion.DESPISTADO));
            }
            if(escuderia.getNombre()=="Peugeot"){
                escuderia.setListaCoche(new CocheResistente("Peugeot 5008", Velocidad.LENTA, Combustible.GENEROSO));
                escuderia.setListaCoche(new CocheRapido("Peugeot 3008", Velocidad.GUEPARDO, Combustible.NORMAL));
                escuderia.setListaCoche(new Coche("Peugeot 2008", Velocidad.NORMAL, Combustible.ESCASO));
                escuderia.setListaPiloto(new PilotoExperimentado("Kankunnen", Concentracion.CONCENTRADO));
                escuderia.setListaPiloto(new PilotoEstrella("Sainz", Concentracion.ZEN));
                escuderia.setListaPiloto(new PilotoNovato("Sordo", Concentracion.DESPISTADO));
            }
        }
        System.out.println("*********************************************************************************************************");
	System.out.println("*****************ESTA SIMULACIÓN CONCLUYE NORMALMENTE COMPLETÁNDOSE TODAS LAS CARRERAS*******************");        
	System.out.println("*********************************************************************************************************\n");
        organizacion.rallyFinal("PuntosDestrezaDesc","CombustibleDesc");
    }
}
