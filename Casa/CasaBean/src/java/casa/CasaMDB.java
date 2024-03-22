/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casa;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class CasaMDB implements MessageListener{
    @Inject
    private CasaEJB ejb;
    
    @Inject
    Event<Casa> modifica;
    
    @Inject @Stato
    Event<Casa> stato;
    
    @Override
    public void onMessage(Message msg){
        try {
            MessageWrapper wrapper = msg.getBody(MessageWrapper.class);
            Casa c = ejb.cercaPerId(wrapper.getId());
            if(c.getStato().equals(wrapper.getStato())){
                c.setPrezzo(wrapper.getPrezzo());
                ejb.modificaCasa(c);
                modifica.fire(c);
            }
            else{
               c.setPrezzo(wrapper.getPrezzo());
               c.setStato(wrapper.getStato());
               ejb.modificaCasa(c);
               stato.fire(c);
            }
        } catch (JMSException ex) {
            Logger.getLogger(CasaMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
