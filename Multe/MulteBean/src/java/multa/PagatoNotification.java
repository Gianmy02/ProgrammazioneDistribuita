/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multa;

import javax.enterprise.event.Observes;


public class PagatoNotification {
   public void notify(@Observes @Pagato Multa m){
       if(m.getStato().equals("pagata"))
           System.out.println(m.getId()+" Contravvenzione pagata");
   } 
}
