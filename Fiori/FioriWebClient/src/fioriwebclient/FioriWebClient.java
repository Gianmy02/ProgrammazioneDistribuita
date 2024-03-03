/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioriwebclient;

import fiori.Fiore;
import java.util.List;

/**
 *
 * @author amministratore
 */
public class FioriWebClient {

       public static void main(String[] args) {
        System.out.println("Stampa di tutti i fiori antinfiammatori");
        List<Fiore> fiori = getByProprieta("Antinfiammatorie");
        for(Fiore f: fiori)
            System.out.println(f);
    }
    
    public static List<Fiore> getByProprieta(java.lang.String arg0){
        fiori.FioreEJBService service = new fiori.FioreEJBService();
        fiori.FioreEJB port = service.getFioreEJBPort();
        return port.getByProprieta(arg0);
    }
    
}
