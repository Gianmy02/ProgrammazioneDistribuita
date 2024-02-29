/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizzazionejmsclient;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.JMSContext;

import organizzazione.MessageWrapper;

public class OrganizzazioneJMSClient {

    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");
    
        MessageWrapper wrapper = new MessageWrapper(1, 5);
        
        try(JMSContext jmsCtx = cf.createContext()){
            jmsCtx.createProducer().send(topic, wrapper);
        }
    }
    
}
