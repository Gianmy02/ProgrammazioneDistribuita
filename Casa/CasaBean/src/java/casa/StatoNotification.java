/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casa;

import javax.enterprise.event.Observes;

public class StatoNotification {
    public void notify(@Observes @Stato Casa c){
        System.out.println("Immobile "+c.getTipo()+" in "+c.getIndirizzo()+ " ha cambiato lo stato in "+c.getStato());
    }
}
