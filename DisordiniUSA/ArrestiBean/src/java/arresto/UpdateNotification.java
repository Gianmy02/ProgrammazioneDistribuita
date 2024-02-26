/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arresto;

import javax.enterprise.event.Observes;

/**
 *
 * @author amministratore
 */
public class UpdateNotification {
    public void notify(@Observes Arresto a){
        System.out.println(a+" è stato aggiornato");
        
        if(a.getNumTatuaggi()> 10)
            a.setSciamano(true);
    }
}
