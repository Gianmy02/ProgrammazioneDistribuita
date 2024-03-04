/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uefawebclient;

import java.util.List;
import partita.Partita;

public class UEFAWebClient {

    public static void main(String[] args) {
        System.out.println("Stampa di tutte le partite giocate");
        List<Partita> partite = getGiocate();
        for(Partita p : partite)
            System.out.println(p);
    }
    
    public static List<Partita> getGiocate(){
        partita.PartitaEJBService service = new partita.PartitaEJBService();
        partita.PartitaEJB port = service.getPartitaEJBPort();
        return port.getGiocate();
    }
    
}
