/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaclient;

import casa.Casa;
import casa.CasaEJBRemote;
import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author amministratore
 */
public class CasaClient {

    public static CasaEJBRemote ejb;
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        ejb = (CasaEJBRemote) ctx.lookup("java:global/CasaBean/CasaEJB!casa.CasaEJBRemote");
        
        System.out.print("Inserisci limite di prezzo: ");
        Scanner s = new Scanner(System.in);
        float limite = Float.parseFloat(s.nextLine());
        List<Casa> casa = ejb.getByPrezzoInferiore(limite);
        for(Casa c: casa)
            System.out.println(c);
        
        System.out.print("Inserisci limite inferiore: ");
        limite = Float.parseFloat(s.nextLine());
        System.out.print("Inserisci limite superiore: ");
        float limiteSup = Float.parseFloat(s.nextLine());
        System.out.print("Inserisci cap: ");
        String cap = s.nextLine();
        casa = ejb.getByPrezzoZona(limite, limiteSup, cap);
        for(Casa c: casa)
            System.out.println(c);
    }
    
}
