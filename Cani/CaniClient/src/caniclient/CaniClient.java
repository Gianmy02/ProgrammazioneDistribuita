/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caniclient;

import cani.Cane;
import cani.CaneEJBRemote;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author amministratore
 */
public class CaniClient {

    public static CaneEJBRemote ejb;
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ejb = (CaneEJBRemote) ctx.lookup("java:global/Cani/CaneEJB!cani.CaneEJBRemote");
        
        System.out.println("Ecco tutti i cani di taglia piccola ed eta maggiore di 8 anni");
        List<Cane> cani = ejb.getByTagliaPiccola("8+");
        for(Cane c: cani)
            System.out.println(c);
        
        System.out.println("Ecco tutti i cani non adottati ancora");
        cani = ejb.getByStatus(false);
        for(Cane c: cani)
            System.out.println(c);
        
        System.out.println("Prova di un cane NON adottato, id 3");
        ejb.adotta(3);
        System.out.println("Prova di un cane adottato, id 1");
        ejb.adotta(1);
    }
    
}
