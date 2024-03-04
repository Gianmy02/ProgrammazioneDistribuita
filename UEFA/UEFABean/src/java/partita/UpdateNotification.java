/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partita;

import javax.enterprise.event.Observes;


public class UpdateNotification {
    public void notify(@Observes Partita p){
        System.out.println("Partita id: "+p.getId()+" Aggiornamento effettuato");
    }
}
