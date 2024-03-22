/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caniwebclient;

import cani.Cane;
import java.util.List;

/**
 *
 * @author amministratore
 */
public class CaniWebClient {

       public static void main(String[] args) {
        System.out.println("Stampa di tutti i cani gia adottati");
        List<Cane> cani = getAdottati(true);
        for(Cane c : cani)
            System.out.println(c);
    }
    
    public static List<Cane> getAdottati(boolean b){
        cani.CaneEJBService service = new cani.CaneEJBService();
        cani.CaneEJB port = service.getCaneEJBPort();
        return port.getByStatus(b);
    }
    
}
