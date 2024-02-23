package canzoni;

import javax.enterprise.event.Observes;
import canzoni.MorganQualifier;

public class MorganNotification {
    public void notify(@Observes @MorganQualifier Canzone c){
        System.out.println("Dov'è Bugo?");
    }
}
