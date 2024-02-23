package ricambi;

import javax.enterprise.event.Observes;

public class UpdateNotification {
    public void notify(@Observes Ricambio ricambio){
        System.out.println(ricambio.getId() + " è stato modificato. Stato: "+ricambio);
    }
}
