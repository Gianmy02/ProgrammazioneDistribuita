package canzoni;

import javax.enterprise.event.Observes;

public class UpdateNotification {
    public void notify(@Observes Canzone c){
        System.out.println(c.getId()+ "è stato modificato " +c);
    }
}
