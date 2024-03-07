/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilatoreclient;

import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import ventilatore.Ventilatore;
import ventilatore.VentilatoreEJBRemote;


public class VentilatoreClient {

    public static VentilatoreEJBRemote ejb;
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ejb = (VentilatoreEJBRemote) ctx.lookup("java:global/VentilatoreBean/VentilatoreEJB!ventilatore.VentilatoreEJBRemote");
        
        Scanner s = new Scanner(System.in);
        System.out.print("Inserisci nazione: ");
        String nazione = s.nextLine();
        
        List<Ventilatore> ventilatori = ejb.printByCountry(nazione);
        System.out.println("Ecco tutti i ventilatori della nazione "+nazione);
        for(Ventilatore v : ventilatori)
            System.out.println(v);
        
        System.out.println("Stampa di tutti i ventilatori con piu di 2000 giri/minuto");
        ventilatori = ejb.printQuickFan();
        for(Ventilatore v: ventilatori)
            System.out.println(v);
    }
    
}
