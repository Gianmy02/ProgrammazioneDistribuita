/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partita;

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
    Event<Partita> update;
    
    @Inject @ItaliaQualifier
    Event<Partita> italia;
    
    @Override
    public void onMessage(Message msg){
        try {
            MessageWrapper wrapper = msg.getBody(MessageWrapper.class);
            Partita p = ejb.cercaPerId(wrapper.getId());
            String squadra;
            if(wrapper.getSquadra().equals("casa"))
            {
                p.setGoalCasa(p.getGoalCasa() + wrapper.getGoal());
                squadra = p.getSqCasa();
            }
            else{
                p.setGoalOspite(p.getGoalOspite() + wrapper.getGoal());
                squadra = p.getSqOspite();
            }
            ejb.modificaPartita(p);

            
            if(squadra.equals("Italia"))
                italia.fire(p);
            else
                update.fire(p);                
        } catch (JMSException ex) {
            Logger.getLogger(PartitaMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
