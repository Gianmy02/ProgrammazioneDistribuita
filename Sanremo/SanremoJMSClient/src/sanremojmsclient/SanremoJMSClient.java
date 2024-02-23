package sanremojmsclient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import canzoni.MessageWrapper;

public class SanremoJMSClient {

    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        
        Destination Topic = (Destination) ctx.lookup("jms/javaee7/Topic");
        
        MessageWrapper wrapper1 = new MessageWrapper("Diodato", "Sai che cosa penso");
        MessageWrapper wrapper2 = new MessageWrapper("Bugo e Morgan", "Le mettendo i piedi in testa");
        
        try(JMSContext jmsContext = cf.createContext()){
            jmsContext.createProducer().setProperty("id", 1).send(Topic, wrapper1);
            jmsContext.createProducer().setProperty("id", 3).send(Topic, wrapper2);

        }
    }
    
}
