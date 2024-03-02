/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchi;

import javax.enterprise.event.Observes;

public class UpdateNotification {
    public void notify(@Observes Partita p) {
        System.out.println("Aggiornamento effettuato");
        if (p.isConclusa()) {
            if (p.getRisultato().equals("Patta")) {
                System.out.println("Partita conclusa con pareggio");
            }
            if (p.getRisultato().equals("G1")) {
                if (p.getRating1() > 2800) {
                    System.out.println(p.getGiocatore1() + " è un superplayer");
                }
            } else {
                if (p.getRating2() > 2800) {
                    System.out.println(p.getGiocatore2() + " è un superplayer");
                }
            }
        }
    }
}
