/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multejmsclient;

import java.time.LocalDate;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.Destination;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import multa.Multa;

/**
 *
 * @author amministratore
 */
public class MulteJMSClient {

    
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");
        
        Multa m1 = new Multa(1, "Numa Pompilio", "divieto di sosta", 50, LocalDate.of(2024, 11, 01), LocalDate.now(), "pagata");
        
        Multa m2 = new Multa(0, "Tonio Cartonio", "divieto di sosta", 50, LocalDate.of(2024, 03, 17), LocalDate.now(), "non pagata");
        
        try(JMSContext jms = cf.createContext()){
            jms.createProducer().send(topic, m1);
        }
        
        try(JMSContext jms = cf.createContext()){
            jms.createProducer().send(topic, m2);
        }
    }
    
}
