/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;


@MessageDriven(mappedName = "jms/javaee7/Topic")
public class PersonaMDB implements MessageListener{
    @Inject
    private PersonaEJB ejb;
    
    @Inject
    Event<Persona> update;
    
    @Inject @QualifierPensionato
    Event<Persona> pensionato;
         
    @Override        
    public void onMessage(Message msg){
        try {
            MessageWrapper wrapper = msg.getBody(MessageWrapper.class);
            Persona p = ejb.getById(wrapper.getId());
            p.setInteresse(wrapper.getInteresse());
            if(p.getMalattiePregresse() > 2)
                p.setPriorita("alta");
            ejb.modificaPersona(p);
            if(p.getCategoria().equals("Pensionato") && p.getInteresse().equals("si"))
                pensionato.fire(p);
            else
                update.fire(p);
        } catch (JMSException ex) {
            Logger.getLogger(PersonaMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
