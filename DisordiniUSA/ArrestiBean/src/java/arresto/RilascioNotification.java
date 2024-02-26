/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arresto;

import javax.enterprise.event.Observes;

public class RilascioNotification {
    public void notify(@Observes @RilascioQualifier Arresto a){
        System.out.println(a.getCognome() + " " + a.getNome() + " può essere rilasciato");
    }
}
