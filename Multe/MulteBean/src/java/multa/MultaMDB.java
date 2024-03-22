package multa;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class MultaMDB implements MessageListener{
    @Inject
    private MultaEJB ejb;
    
    @Inject
    Event<Multa> evento;
    
    @Inject @Pagato
    Event<Multa> pagato;
    
    @Override
    public void onMessage(Message msg){
        try {
            Multa m = msg.getBody(Multa.class);
            if(m.getId() !=0){
                m.setStato(m.getStato());
                m.setCaricamento(LocalDate.now());
                ejb.modificaMulta(m);
                pagato.fire(m);
            }
            else{
                m = new Multa(m.getId(), m.getNomeCognome(), m.getMotivo(), m.getSomma(), null, LocalDate.now(), "non pagata");
                ejb.aggiungiMulta(m);
                evento.fire(m);
            }
        } catch (JMSException ex) {
            Logger.getLogger(MultaMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
