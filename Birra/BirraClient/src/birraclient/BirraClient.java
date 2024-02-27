/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birraclient;

import birra.Negozio;
import birra.NegozioEJBRemote;
import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author amministratore
 */
public class BirraClient {
    
    public static NegozioEJBRemote ejb;
    
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        ejb = (NegozioEJBRemote) ctx.lookup("java:global/BirraBean/NegozioEJB!birra.NegozioEJBRemote");
        Scanner in = new Scanner(System.in);
        System.out.print("Inserire regione: ");
        String regione = in.nextLine();
        List<Negozio> negozi = ejb.getByRegione(regione);
        for(Negozio n : negozi){
            System.out.println(n);
        }
        
        System.out.println("Stampa di tutti i negozi con vendite alcoliche maggiori delle analcoliche");
        negozi = ejb.getAlcolici();
        for(Negozio n : negozi){
            System.out.println(n);
        }
    }
    
}
