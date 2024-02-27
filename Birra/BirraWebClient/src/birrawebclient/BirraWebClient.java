/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birrawebclient;

import java.util.Scanner;

/**
 *
 * @author amministratore
 */
public class BirraWebClient {

    public static void main(String[] args) {
       System.out.print("Inserisci nuovo nome: ");
       Scanner in = new Scanner (System.in); 
       String direttore = in.nextLine();
       modificaDirettore(1, direttore);
    }
    
    private static void modificaDirettore(int agrs0, java.lang.String args1){
        birra.NegozioEJBService service = new birra.NegozioEJBService();
        birra.NegozioEJB port = service.getNegozioEJBPort();
        port.updateDirector(agrs0, args1);
    }
    
}
