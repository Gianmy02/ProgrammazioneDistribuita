package scacchijmsclient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import scacchi.MessageWrapper;

public class ScacchiJMSClient {
    
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");
        
        MessageWrapper wrapper = new MessageWrapper(3, 3000, 2700, "a6", "G1", true);
        
        try(JMSContext jms = cf.createContext()){
            jms.createProducer().send(topic, wrapper);
        }
    }
    
}
