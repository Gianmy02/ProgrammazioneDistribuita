/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizzazionewebclient;

import java.util.List;
import organizzazione.Organizzazione;

/**
 *
 * @author amministratore
 */
public class OrganizzazioneWebClient {

    public static void main(String[] args) {
        System.out.println("Ecco la lista di tutte le organizzazioni con trasparenza 100%");
        List<Organizzazione> organizzazioni = stampaPerBilancio();
        for(Organizzazione o: organizzazioni)
            System.out.println(o);
    }
    
    private static List<Organizzazione> stampaPerBilancio(){
        organizzazione.OrganizzazioneEJBService service = new organizzazione.OrganizzazioneEJBService();
        organizzazione.OrganizzazioneEJB port = service.getOrganizzazioneEJBPort();
        return port.getTrasparenzaCento();
    }
    
}
