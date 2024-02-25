/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanremoclient;

import canzoni.Canzone;
import canzoni.CanzoneEJBRemote;
import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SanremoClient {
    
    private static CanzoneEJBRemote ejb;
    
    public static void main(String[] args) throws NamingException{
        
        System.out.println("Benvenuto a Sanremo");
        Scanner scanner = new Scanner(System.in);
        Context ctx = new InitialContext();
        ejb = (CanzoneEJBRemote) ctx.lookup("java:global/SanremoBean/CanzoneEJB!canzoni.CanzoneEJBRemote");
        List<Canzone> canzoni = ejb.getCanzoni();
        System.out.println("Ecco tutte le canzoni: ");
        for(Canzone c: canzoni)
            System.out.println(c);
        
        System.out.print("Inserisci categoria: ");
        String categoria = scanner.nextLine();
        canzoni = ejb.printByCategory(categoria);
        for(Canzone c: canzoni)
            System.out.println(c);
        
        System.out.print("Inserisci voto: ");
        String voto = scanner.nextLine();
        float v = Float.parseFloat(voto);
        canzoni = ejb.printByVotes(v);
        for(Canzone c: canzoni)
            System.out.println(c);
        
    }
    
}
