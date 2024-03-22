
package immobileclient;

import immobile.Immobile;
import immobile.ImmobileEJBRemote;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ImmobileClient{
  public static ImmobileEJBRemote ejb;
  public static void main(String[] args) throws NamingException{
    Context ctx = new InitialContext();
    ejb = (ImmobileEJBRemote) ctx.lookup("java:global/ImmobileBean/ImmobileEJB!immobile.ImmobileEJBRemote");

    System.out.println("Stampa di tutti gli immobili in vendita");
    //qui è stato cambiato immobile da immobili all'interno di list
    List<Immobile> immobili = ejb.getByStato("in vendita");
    for(Immobile i: immobili){
       System.out.println("immobile a indirizzo: "+i.getIndirizzo()+ " Valore: "+i.getValore()+ " ultima modifica: "+i.getModifica()+ " stato: "+i.getStato()); 
    }

    System.out.println("Stampa di tutti gli immobili in vendita da massimo 2 mesi");
    immobili = ejb.getVenditaDueMesi();
    //anche qui è stato cambiato immobile da immobili all'interno di list
    for(Immobile i: immobili){
       System.out.println("immobile a indirizzo: "+i.getIndirizzo()+ " Valore: "+i.getValore()+ " ultima modifica: "+i.getModifica()+ " stato: "+i.getStato()); 
    }
  }
}
