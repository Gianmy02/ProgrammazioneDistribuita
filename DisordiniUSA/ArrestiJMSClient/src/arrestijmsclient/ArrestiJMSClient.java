package arrestijmsclient;

import arresto.*;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.JMSContext;

public class ArrestiJMSClient {
   
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        
        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");
        
        MessageWrapper wrapper = new MessageWrapper(2, 2, 13);
        try(JMSContext jmsContext = connectionFactory.createContext()){
            jmsContext.createProducer().send(topic, wrapper);
        }
    }
    
}
