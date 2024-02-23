package autowebclient;

import java.util.Scanner;
import ricambi.Ricambio;

public class AutoWebClient {

    public static void main(String[] args) {
        System.out.print("Quale pezzo vuoi modificare, inserire l'id? ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        
        System.out.print("Con quale valore? ");
        Float prezzo = scanner.nextFloat();
        
        Ricambio r = cercaPerId(id);
        r.setPrezzo(prezzo);
        Ricambio modificaRicambio = modificaRicambio(r);
        System.out.println("Modifica avvenuta: "+modificaRicambio);
    }
    
     private static Ricambio cercaPerId(java.lang.Integer arg0) {
        ricambi.RicambioEJBService service = new ricambi.RicambioEJBService();
        ricambi.RicambioEJB port = service.getRicambioEJBPort();
        return port.cercaPerId(arg0);
    }
    
    private static Ricambio modificaRicambio(ricambi.Ricambio arg0){
        ricambi.RicambioEJBService service = new ricambi.RicambioEJBService();
        ricambi.RicambioEJB port = service.getRicambioEJBPort();
        return port.modificaRicambio(arg0);
    }
}
