/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viaggi;

import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class ViaggioMDB implements MessageListener{
    
    @Inject
    public ViaggioEJB ejb;
    
    @Inject
    Event<Viaggio> evento;
    
    @Override
    public void onMessage(Message msg){
       try{
           MessageWrapper wrapper = msg.getBody(MessageWrapper.class);
           int id = wrapper.getId();
           Viaggio v = ejb.getById(id);
           int sconto = wrapper.getSconto();
           if(v.getCategoria().equals("Montagna"))
               sconto += 5;
           v.setSconto(sconto);
           ejb.modificaViaggio(v);
           evento.fire(v);
       }catch(JMSException ex){
           
       } 
    }
}
