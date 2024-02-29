/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizzazioneclient;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import organizzazione.Organizzazione;
import organizzazione.OrganizzazioneEJBRemote;


public class OrganizzazioneClient {

    private static OrganizzazioneEJBRemote ejb;
    
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        
        ejb = (OrganizzazioneEJBRemote) ctx.lookup("java:global/OrganizzazioneBean/OrganizzazioneEJB!organizzazione.OrganizzazioneEJBRemote");
        
        System.out.println("Stampa di tutte le organizzazioni");
        
        List<Organizzazione> organizzazioni = ejb.getOrganizzazione();
        for(Organizzazione o : organizzazioni){
            System.out.println(o);
        }
        
        System.out.println("Stampa di tutte le organizzazioni con bilancio maggiore a 50.000.000,00");
        organizzazioni = ejb.stampaBilancioMaggiore();
        for(Organizzazione o : organizzazioni){
            System.out.println(o);
        }
    }
    
}
