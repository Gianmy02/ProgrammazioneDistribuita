package casajmsclient;

import casa.MessageWrapper;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
/**
 *
 * @author amministratore
 */
public class CasaJMSClient {
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");
        
        MessageWrapper wrapper = new MessageWrapper(1, "Libero", 500F);
        MessageWrapper wrapper2 = new MessageWrapper(2, "Locato", 400F);

        try(JMSContext jms = cf.createContext()){
            jms.createProducer().send(topic, wrapper);
        }
        
        try(JMSContext jms = cf.createContext()){
            jms.createProducer().send(topic, wrapper2);
        }
    }
    
}
