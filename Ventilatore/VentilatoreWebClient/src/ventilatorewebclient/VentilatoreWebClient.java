/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilatorewebclient;

import java.util.Scanner;
import ventilatore.Ventilatore;

/**
 *
 * @author amministratore
 */
public class VentilatoreWebClient {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Inserisci id: ");
        int id = s.nextInt();
        System.out.print("Inserisci nuovi giri: ");
        int giri = s.nextInt();
        Ventilatore v = modificaGiri(id, giri);
        System.out.println(v);
    }
    
    public static Ventilatore modificaGiri(int id, int giri){
        ventilatore.VentilatoreEJBService service = new ventilatore.VentilatoreEJBService();
        ventilatore.VentilatoreEJB port = service.getVentilatoreEJBPort();
        Ventilatore v = port.getById(id);
        v.setGiriMinuto(giri);
        return port.modificaVentilatore(v);
    }
    
}
