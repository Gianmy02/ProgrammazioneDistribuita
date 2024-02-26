/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arresto;

import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class ArrestoMDB implements MessageListener{
    
    @Inject
    Event<Arresto> updateEvent;
    
    @Inject 
    @RilascioQualifier
    Event<Arresto> rilascioEvent;

    @Inject 
    private ArrestoEJB ejb;
    
    @Override
    public void onMessage(Message msg) {
        try{
            
           MessageWrapper msgContent =  msg.getBody(MessageWrapper.class);
           Integer id = msgContent.getId();
           Arresto a = ejb.cercaPerId(id);
           int variazioneReati = a.getNumReati() + msgContent.getVariazioneReati();
           int variazioneTatuaggi = a.getNumTatuaggi() + msgContent.getVariazioneTatuaggi();
           a.setNumReati(variazioneReati);
           a.setNumTatuaggi(variazioneTatuaggi);
           ejb.modificaArresto(a);
           updateEvent.fire(a);
           
           if(a.getNumReati() == 0)
               rilascioEvent.fire(a);
        }catch(JMSException ex){
            
        }
    }
    
}
