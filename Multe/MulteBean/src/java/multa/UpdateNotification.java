/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multa;

import java.time.LocalDate;
import javax.enterprise.event.Observes;


public class UpdateNotification {
    public void notify(@Observes Multa m){
        System.out.println(LocalDate.now()+ ": Inserimento contravvenzione per il signor "+m.getNomeCognome()+": motivazione "+m.getMotivo());
    }
}
