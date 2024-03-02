/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchiwebclient;

import java.util.List;
import scacchi.Partita;

/**
 *
 * @author amministratore
 */
public class ScacchiWebClient {

    public static void main(String[] args) {
        System.out.println("Stampa di tutte le partite");
        List<Partita> partite = getPartite();
        for(Partita p: partite)
            System.out.println(p);
        
    }
    
    public static List<Partita> getPartite(){
        scacchi.PartitaEJBService service  = new scacchi.PartitaEJBService();
        scacchi.PartitaEJB port = service.getPartitaEJBPort();
        return port.getPartite();
    }
}
