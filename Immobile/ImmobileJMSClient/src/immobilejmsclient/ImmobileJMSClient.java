package immobilejmsclient;

import immobile.MessageWrapper;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;

public class ImmobileJMSClient{
                                        //aggiunta di NamingException
  public static void main(String[] args) throws NamingException{
    Context ctx = new InitialContext();
    ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");

    Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");

    MessageWrapper wrapper1 = new MessageWrapper(1, "venduta");
    
    MessageWrapper wrapper2 = new MessageWrapper(5, "Via Roma", 100, "in vendita");

    try(JMSContext jms = cf.createContext()){
     jms.createProducer().send(topic, wrapper1);
    }

    try(JMSContext jms = cf.createContext()){
     jms.createProducer().send(topic, wrapper2);
    }
  }
}

