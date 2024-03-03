/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiori;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class FioreMDB implements MessageListener{
    @Inject
    Event<Fiore> evento;
    
    @Inject
    private FioreEJB ejb;

    @Override
    public void onMessage(Message msg) {
        try{
            MessageWrapper wrapper = msg.getBody(MessageWrapper.class);
            Fiore f = ejb.getFioreById(wrapper.getId());
            f.setGiacenza(f.getGiacenza()+wrapper.getVariazioneGiacenza());
            ejb.modificaFiore(f);
            if(f.getGiacenza() < 10)
                evento.fire(f);
        } catch (JMSException ex) {
            Logger.getLogger(FioreMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
