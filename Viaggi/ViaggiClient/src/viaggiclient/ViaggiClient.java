/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viaggiclient;

import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import viaggi.Viaggio;
import viaggi.ViaggioEJBRemote;

/**
 *
 * @author amministratore
 */
public class ViaggiClient {

    public static ViaggioEJBRemote ejb;
    
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ejb = (ViaggioEJBRemote) ctx.lookup("java:global/ViaggiBean/ViaggioEJB!viaggi.ViaggioEJBRemote");
        
        System.out.print("Inserire prezzo limite viaggio: ");
        Scanner s = new Scanner(System.in);
        int prezzo = s.nextInt();
        List<Viaggio> viaggi = ejb.getViaggiPrezzoInf(prezzo);
        for(Viaggio v : viaggi)
            System.out.println(v);
    }
    
}
