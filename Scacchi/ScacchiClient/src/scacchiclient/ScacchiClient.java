/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchiclient;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import scacchi.Partita;
import scacchi.PartitaEJBRemote;

/**
 *
 * @author amministratore
 */
public class ScacchiClient {

    public static PartitaEJBRemote ejb;
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ejb = (PartitaEJBRemote) ctx.lookup("java:global/ScacchiBean/PartitaEJB!scacchi.PartitaEJBRemote");
        
        System.out.println("Stampa di partite con giocatori con rating superiore a 2300");
        
        List<Partita> partite = ejb.partiteRatingMaggiore();
        
        for(Partita p: partite)
            System.out.println(p);
        
        partite = ejb.partiteByRisultato("Patta");
        
        System.out.println("Stampa di partite finite in pareggio");
        
        for(Partita p: partite)
            System.out.println(p);

    }
    
}
