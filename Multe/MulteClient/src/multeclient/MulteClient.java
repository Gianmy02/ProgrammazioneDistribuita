/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multeclient;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import multa.Multa;
import multa.MultaEJBRemote;

/**
 *
 * @author amministratore
 */
public class MulteClient {

    public static MultaEJBRemote ejb;
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        ejb = (MultaEJBRemote) ctx.lookup("java:global/MulteBean/MultaEJB!multa.MultaEJBRemote");
        List<Multa> multe = ejb.getMulte();
        System.out.println("Tutte le multe:");
        for(Multa m: multe)
            System.out.println(m);
        
        System.out.println("Tutte le contestabili");
        multe = ejb.getContestabili();
        for(Multa m: multe)
            System.out.println(m);
        
        System.out.println("Tutte le non pagate");
        multe = ejb.getNonPagate();
        for(Multa m: multe)
            System.out.println(m);
        
    }
    
}
