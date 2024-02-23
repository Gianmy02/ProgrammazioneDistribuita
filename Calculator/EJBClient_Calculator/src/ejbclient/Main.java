/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbclient;
import ejb.CalculatorEJBRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 *
 * @author amministratore
 */
public class Main{
    public static void main(String[] args) throws NamingException {
        Context ctx;
        ctx = new InitialContext();
        CalculatorEJBRemote bean = (CalculatorEJBRemote)ctx.lookup("java:global/EJB_Calculator/CalculatorEJB!ejb.CalculatorEJBRemote");
        System.out.println("Ora invoco...");
        bean.push(3F);
        bean.push(2F);
        bean.push(3F);
        bean.sum();
        System.out.println("Somma di 2 + 3 = "+bean.pop());
        
        bean.push(54F);
        bean.push(24F);
        bean.sub();
        System.out.println("Differenza di 54 - 24 = "+bean.pop());
        
        bean.push(2F);
        bean.push(3F);
        bean.mul();
        System.out.println("Prodotto di 2 * 3 = "+bean.pop());
        
        bean.push(2F);
        bean.push(3F);
        bean.mul();
        System.out.println("Prodotto di 2 * 3 = "+bean.pop());
        
        bean.push(2F);
        bean.push(3F);
        bean.push(7F);
        bean.sum();
        System.out.println("Prodotto di 3 + 7 con 2 inserito in precedenza = "+bean.pop());
        
    }
}


