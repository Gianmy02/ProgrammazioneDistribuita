package autojmsclient;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import ricambi.MessageWrapper;

public class AutoJMSClient {

    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");
        Integer id = 1;
        Integer vendite = 10;
        MessageWrapper wrapper = new MessageWrapper(id, vendite);
        
        try(JMSContext jmsCtx = cf.createContext()){
           jmsCtx.createProducer().send(topic, wrapper);
        }
    }
    
}
