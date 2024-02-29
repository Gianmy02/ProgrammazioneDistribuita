package organizzazione;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class OrganizzazioneMDB implements MessageListener{

    @Inject
    private OrganizzazioneEJB ejb;
    
    @Inject
    Event<Organizzazione> event;

    @Override
    public void onMessage(Message msg) {
        try {
            MessageWrapper wrapper = msg.getBody(MessageWrapper.class);
            Integer id = wrapper.getId();
            Organizzazione o = ejb.trovaPerId(id);
            Integer nuovi = wrapper.getNuoviDonatori();
            o.setNumDonatori(o.getNumDonatori() + nuovi);
            ejb.modificaOrganizzazione(o);
            event.fire(o);
        } catch (JMSException ex) {
            Logger.getLogger(OrganizzazioneMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
