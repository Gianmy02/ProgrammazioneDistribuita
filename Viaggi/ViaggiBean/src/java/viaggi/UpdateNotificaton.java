/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viaggi;

import javax.enterprise.event.Observes;

public class UpdateNotificaton {
    public void notify(@Observes Viaggio v){
        System.out.println("Viaggio "+v.getDestinazione()+" aggiornato con sconto a: "+v.getSconto());
    }
}
