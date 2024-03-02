/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchi;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;


@MessageDriven(mappedName = "jms/javaee7/Topic")
public class PartitaMDB implements MessageListener{
    
    @Inject
    public PartitaEJB ejb;
    
    @Inject
    Event<Partita> mosseEvent;
    

    @Override
    public void onMessage(Message message) {
        try {
            MessageWrapper wrapper = message.getBody(MessageWrapper.class);
            int id = wrapper.getId();
            Partita p = ejb.getById(id);
            p.setMosse(p.getMosse()+" "+wrapper.getMosse());
            if(wrapper.isConclusa()){
                p.setConclusa(wrapper.isConclusa());
                p.setRisultato(wrapper.getRisultato());
                p.setRating1(wrapper.getRating1());
                p.setRating2(wrapper.getRating2());
            }
            ejb.modificaPartita(p);
            mosseEvent.fire(p);
        } catch (JMSException ex) {
            Logger.getLogger(PartitaMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
