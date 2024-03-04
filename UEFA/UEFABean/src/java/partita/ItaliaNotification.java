/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partita;

import javax.enterprise.event.Observes;

public class ItaliaNotification {
    public void notify(@Observes @ItaliaQualifier Partita p){
        System.out.println("Aleeeeee :-)");
    }
}
