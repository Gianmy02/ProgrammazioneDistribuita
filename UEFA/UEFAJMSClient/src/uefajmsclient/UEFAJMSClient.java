/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uefajmsclient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.jms.Destination;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.naming.NamingException;
import partita.MessageWrapper;

public class UEFAJMSClient {

    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
    
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");
        
        MessageWrapper wrapper1 = new MessageWrapper(1, 1, "ospite");
        MessageWrapper wrapper2 = new MessageWrapper(3, 1, "casa");
        
        try(JMSContext jms = cf.createContext()){
            jms.createProducer().send(topic, wrapper1);
        }
        
        try(JMSContext jms = cf.createContext()){
            jms.createProducer().send(topic, wrapper2);
        }
    }
    
}
