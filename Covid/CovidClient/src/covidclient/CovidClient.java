/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidclient;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import persona.Persona;
import persona.PersonaEJBRemote;

/**
 *
 * @author amministratore
 */
public class CovidClient {

    public static PersonaEJBRemote ejb;
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        
        ejb = (PersonaEJBRemote) ctx.lookup("java:global/CovidBean/PersonaEJB!persona.PersonaEJBRemote");
    
        System.out.println("Stampa di tutti gli individui che hanno contratto il covid");
        List<Persona> persone = ejb.getByContratti();
        for(Persona p: persone)
            System.out.println(p);
        
        System.out.println("Stampa di tutti i docenti con meno di 55 anni");
        persone = ejb.getDocentiGiovani();
        for(Persona p: persone)
            System.out.println(p);
        
        System.out.println("Stampa di tutti gli individui pensionati ed interessati al vaccino");
        persone = ejb.getPensionatiInteressati();
        for(Persona p: persone)
            System.out.println(p);
       
    }
    
}
