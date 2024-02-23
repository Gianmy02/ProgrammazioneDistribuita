package canzoni;

import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class CanzoneMDB implements MessageListener{

    @Inject
    Event<Canzone> generalEvent;
    
    @Inject 
    @MorganQualifier
    Event<Canzone> morganEvent;
    
    @Inject
    private CanzoneEJB ejb;
    
    @Override
    public void onMessage(Message msg) {
        try{
            Integer id = msg.getIntProperty("id");
            MessageWrapper msgContent = msg.getBody(MessageWrapper.class);
            Canzone c = ejb.cercaPerId(id);
            if(c.getIncipit().startsWith(msgContent.getIncipit())){
                c.setCantato(true);
                generalEvent.fire(c);
            }
            
            if(msgContent.getCantante().equals("Bugo e Morgan") && msgContent.getIncipit().equals("Le mettendo i piedi in testa")){
                c.setCantato(true);
                c.setCantante("Morgan");
                morganEvent.fire(c);
            }
            ejb.modificaCanzone(c);
        }catch(JMSException ex){
            
        }
        
    }
    
}
