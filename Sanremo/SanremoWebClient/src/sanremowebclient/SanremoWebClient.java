package sanremowebclient;

import canzoni.Canzone;
import java.util.Scanner;


public class SanremoWebClient {

    public static void main(String[] args) {
        Canzone c;
        Scanner s = new Scanner(System.in);
        System.out.print("Inserisci id della canzone da modificare: ");
        int id = s.nextInt();
        System.out.print("Inserisci voti della canzone con id: ");
        Float voto = s.nextFloat();
        c = cercaPerId(id);
        c.setVoto(voto);
        aggiornaCanzone(c);
    }
    
    private static Canzone cercaPerId(int arg0){
        canzoni.CanzoneEJBService service = new canzoni.CanzoneEJBService();
        canzoni.CanzoneEJB port = service.getCanzoneEJBPort();
        return port.cercaPerId(arg0);
    }
    
    private static void aggiornaCanzone(canzoni.Canzone arg0){
        canzoni.CanzoneEJBService service = new canzoni.CanzoneEJBService();
        canzoni.CanzoneEJB port = service.getCanzoneEJBPort();
        port.modificaCanzone(arg0);
    }
    
}
