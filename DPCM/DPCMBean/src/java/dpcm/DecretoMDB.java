/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpcm;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class DecretoMDB implements MessageListener{
    @Inject
    Event<Decreto> a;
    
    @Inject
    private DecretoEJB ejb;
    
    @Override
    public void onMessage(Message msg){
        try{
            MessageWrapper msgContext = msg.getBody(MessageWrapper.class);
            Integer id = msgContext.getId();
            Integer numPres = msgContext.getNumPres();
            
            Decreto d = ejb.cercaPerId(id);
            d.setNumPres(d.getNumPres()+numPres);
            ejb.modificaDecreto(d);
            a.fire(d);
        } catch (JMSException ex) {
            Logger.getLogger(DecretoMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
