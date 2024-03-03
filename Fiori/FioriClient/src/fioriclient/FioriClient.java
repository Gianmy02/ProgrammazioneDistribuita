/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioriclient;

import fiori.Fiore;
import fiori.FioreEJBRemote;
import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class FioriClient {

    public static FioreEJBRemote ejb;
    
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ejb = (FioreEJBRemote) ctx.lookup("java:global/FioriBean/FioreEJB!fiori.FioreEJBRemote");
        
        System.out.print("Inserire ciclo biologico: ");
        Scanner s = new Scanner(System.in);
        String ciclo = s.nextLine();
        List<Fiore> fiori = ejb.getbyCiclo(ciclo);
        System.out.println("Stampa di tutti i fiori con ciclo biologico "+ciclo+":");
        for(Fiore f: fiori){
            System.out.println(f);
        }
        
        System.out.println("Stampa di tutti i fiori per uso Dolci");
        fiori = ejb.getByUso("Dolci");
        for(Fiore f: fiori){
            System.out.println(f);
        }
    }
    
}
