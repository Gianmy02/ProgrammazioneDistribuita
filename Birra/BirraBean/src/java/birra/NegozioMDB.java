/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birra;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class NegozioMDB implements MessageListener{
    
    @Inject
    private NegozioEJB ejb;
    
    @Inject
    Event<Negozio> updateNegozio;

    @Override
    public void onMessage(Message message) {
        try {
            MessageWrapper wrapper = message.getBody(MessageWrapper.class);
            int id = wrapper.getId();
            Negozio n = ejb.cercaPerId(id);
            n.setBirreAlcoliche(n.getBirreAlcoliche()+wrapper.getVariazioneAlcolica());
            ejb.modificaNegozio(n);
            updateNegozio.fire(n);
        } catch (JMSException ex) {
            Logger.getLogger(NegozioMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
