package immobilewebclient;

import immobile.Immobile;
import java.util.List;


public class ImmobileWebClient{
  public static void main(String[] args){
    List<Immobile> immobili = getVenduti(); 
    System.out.println("Ecco tutti gli immobili venduti");
    for(Immobile i: immobili){
       System.out.println("Immobile stato "+i.getStato()+ " id: "+i.getId()+ " indirizzo: "+i.getIndirizzo());
    }
  }

  private static List<Immobile> getVenduti(){
    immobile.ImmobileEJBService service = new immobile.ImmobileEJBService();
    immobile.ImmobileEJB port = service.getImmobileEJBPort();
    return port.getByStato("venduta");
  }
}
    