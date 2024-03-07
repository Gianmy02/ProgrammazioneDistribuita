/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilatore;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class VentilatoreMDB implements MessageListener{
    @Inject
    private VentilatoreEJB ejb;
    
    @Inject
    Event<Ventilatore> update;
    
    @Override
    public void onMessage(Message msg){
        try {
            MessageWrapper wrapper = msg.getBody(MessageWrapper.class);
            Ventilatore v = ejb.getById(wrapper.getId());
            v.setVenduti(v.getVenduti() + wrapper.getVendite());
            ejb.modificaVentilatore(v);
            update.fire(v);
        } catch (JMSException ex) {
            Logger.getLogger(VentilatoreMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
