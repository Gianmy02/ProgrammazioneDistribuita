package immobile;

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
public class ImmobileMDB implements MessageListener{
  @Inject
  public ImmobileEJB ejb;

  @Inject
  Event<Immobile> aggiornamento;

  @Override
  public void onMessage(Message msg){
     try{
        MessageWrapper wrapper = msg.getBody(MessageWrapper.class);
        //cambiato == in !=
        if(wrapper.getIndirizzo() != null){
          Immobile i = new Immobile(wrapper.getId(), wrapper.getIndirizzo(), wrapper.getValore(), wrapper.getModifica(), wrapper.getCaricamento(), wrapper.getStato());
          ejb.aggiungiImmobile(i);
          System.out.println(i.getCaricamento()+ ": inserimento immobile in "+i.getIndirizzo()+ " di valore "+i.getValore());
        }
        else{

          Immobile i = ejb.getById(wrapper.getId());
          if(wrapper.getStato().equals("venduta") && !(i.getStato().equals("venduta"))){
            i.setStato(wrapper.getStato());
            i.setModifica(LocalDate.now());
            ejb.modificaImmobile(i);
            aggiornamento.fire(i);
            //aggiunta scritta else, gia vi erano le parentesi
          }else{
            //wrapper.getModifica cambiato da i
           i.setModifica(wrapper.getModifica());
           i.setStato(wrapper.getStato());
           ejb.modificaImmobile(i);
          }
        }
     }catch(JMSException ex){
        Logger.getLogger(ImmobileMDB.class.getName()).log(Level.SEVERE, null, ex);
     }
  }
}
