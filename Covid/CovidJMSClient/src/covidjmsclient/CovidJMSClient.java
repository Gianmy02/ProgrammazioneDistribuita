/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidjmsclient;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.JMSContext;
import persona.MessageWrapper;

public class CovidJMSClient {


    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");
    
        MessageWrapper wrapper1 = new MessageWrapper(1, "si");
        MessageWrapper wrapper2 = new MessageWrapper(3, "no");

        try(JMSContext jms = cf.createContext()){
            jms.createProducer().send(topic, wrapper1);
        }
        
        try(JMSContext jms = cf.createContext()){
            jms.createProducer().send(topic, wrapper2);
        }
    }
    
}
