/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casawebclient;

import casa.Casa;
import java.util.List;
public class CasaWebClient {

    
       public static void main(String[] args) {
        System.out.println("Ecco tutte le case libere:");
        List<Casa> casa = getCasaLibere();
        for(Casa c: casa)
            System.out.println(c);
    }
    
    private static List<Casa> getCasaLibere(){
        casa.CasaEJBService service = new casa.CasaEJBService();
        casa.CasaEJB port = service.getCasaEJBPort();
        return port.getLibera();
    }
    
}
