/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arresticlient;

import arresto.Arresto;
import arresto.ArrestoEJBRemote;
import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author amministratore
 */
public class ArrestiClient {

    public static ArrestoEJBRemote ejb;
    
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        ejb = (ArrestoEJBRemote) ctx.lookup("java:global/ArrestiBean/ArrestoEJB!arresto.ArrestoEJBRemote");
        
        Scanner in = new Scanner(System.in);
        System.out.println("Stampa di tutti gli sciamani");
        List<Arresto> arresti = ejb.getSciamani();
        for(Arresto a : arresti)
            System.out.println(a);
        
        System.out.print("Inserisci un organizzazione: ");
        String organizzazione = in.nextLine();
        arresti = ejb.getByOrganizzazione(organizzazione);
        for(Arresto a : arresti)
            System.out.println(a);
        
        System.out.print("Inserisci un numero di tatoo minimo: ");
        int min = in.nextInt();
        arresti = ejb.getTatuati(min);
        for(Arresto a : arresti)
            System.out.println(a);
    }
    
}
