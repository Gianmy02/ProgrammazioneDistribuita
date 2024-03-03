/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viaggiwebclient;

import java.util.List;
import viaggi.Viaggio;

/**
 *
 * @author amministratore
 */
public class ViaggiWebClient {

    public static void main(String[] args) {
        System.out.println("Ecco tutti i viaggi rimasti disponibili");
        List<Viaggio> viaggi = getDisponibili();
        for(Viaggio v : viaggi)
            System.out.println(v);
    }
    
    public static List<Viaggio> getDisponibili(){
        viaggi.ViaggioEJBService service = new viaggi.ViaggioEJBService();
        viaggi.ViaggioEJB port = service.getViaggioEJBPort();
        return port.getDisponibili();
    }
    
}
