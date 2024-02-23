/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricambi;

import java.util.*;
import javax.naming.*;
import ricambi.Ricambio;
import ricambi.RicambioEJBRemote;

public class AutoClient {

    public static void main(String[] args) throws NamingException{
       Context ctx = new InitialContext();
       RicambioEJBRemote ricambiEJB = (RicambioEJBRemote) ctx.lookup("java:global/AutoBean/RicambioEJB!ricambi.RicambioEJBRemote");
       List<Ricambio> ricambi = ricambiEJB.getRicambi();
       System.out.println("Tutti i ricambi");
       for(Ricambio r: ricambi)
           System.out.println("Nome "+r.getNome()+ " Categoria "+r.getCategoria());
       
       System.out.println("Tutti i ricambi poco disponibili");
       ricambi = ricambiEJB.getRicambiPocoDisponibili();
       for(Ricambio r: ricambi)
          System.out.println("Nome "+r.getNome()+ " Categoria "+r.getCategoria());
       
       System.out.println("Tutti i ricambi della Categoria Freni");
       ricambi = ricambiEJB.getRicambiPerCategoria("Freni");
        for(Ricambio r: ricambi)
         System.out.println("Nome "+r.getNome()+ " Categoria "+r.getCategoria());
    }
    
}
