package ricambi;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class RicambioMDB implements MessageListener {
    @Inject
    private RicambioEJB ricambioEjb;
    
    @Inject
    Event<Ricambio> event;
    
    @Override
    public void onMessage(Message msg){
        try{
            MessageWrapper wrapper = msg.getBody(MessageWrapper.class);
            Integer id = wrapper.getId();
            Integer itemSold = wrapper.getVendite();
            Ricambio r = ricambioEjb.cercaPerId(id);
            r.setPezziVenduti(r.getPezziVenduti()+itemSold);
            r = ricambioEjb.modificaRicambio(r);
            event.fire(r);
        }catch(JMSException ex){
            Logger.getLogger(Ricambio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
