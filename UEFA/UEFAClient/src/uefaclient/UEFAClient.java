/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uefaclient;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import partita.Partita;
import partita.PartitaEJBRemote;


public class UEFAClient {

    public static PartitaEJBRemote ejb;
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ejb = (PartitaEJBRemote) ctx.lookup ("java:global/UEFABean/PartitaEJB!partita.PartitaEJBRemote");
        
        List<Partita> partite = ejb.getPartiteGoalMaggiori(2);
        
        System.out.println("Stampa di tutte le partite con piu di 2 gol");
        for(Partita p: partite)
            System.out.println(p);
        
        System.out.println("Stampa di tutte le partite con 0 espulsioni");
        partite = ejb.getPartiteByEspulsioni(0);
        for(Partita p: partite)
            System.out.println(p);
    }
    
}
