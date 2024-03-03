/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiorijmsclient;

import fiori.MessageWrapper;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.Destination;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;


public class FioriJMSClient {

    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");
        
        MessageWrapper wrapper = new MessageWrapper(1, -10);
        
        try(JMSContext jms = cf.createContext()){
            jms.createProducer().send(topic, wrapper);
        }
    }
    
}
