/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiori;

import javax.enterprise.event.Observes;

/**
 *
 * @author amministratore
 */
public class UpdateNotification {
    public void notify(@Observes Fiore f){
        System.out.println("Giacenza bassa per i prodotto: "+f.getSpecie());
    }
}
