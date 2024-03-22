/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multewebclient;

import java.util.List;
import multa.Multa;

/**
 *
 * @author amministratore
 */
public class MulteWebClient {

     public static void main(String[] args) {
        List<Multa> multe = getNonPagate();
        for(Multa m: multe)
            System.out.println(m);
    }
    
    public static List<Multa> getNonPagate(){
        multa.MultaEJBService service = new multa.MultaEJBService();
        multa.MultaEJB port = service.getMultaEJBPort();
        return port.getNonPagate();
    }
    
}
