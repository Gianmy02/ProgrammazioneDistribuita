package correntisticlient;

import correntisti.Correntista;
import correntisti.CorrentistaEJBRemote;
import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CorrentistiClient {
    public static CorrentistaEJBRemote ejb;
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        ejb = (CorrentistaEJBRemote) ctx.lookup("java:global/Correntisti/CorrentistaEJB!correntisti.CorrentistaEJBRemote");
        
        List<Correntista> correntisti = ejb.getCorrentistiInsolventi();
        System.out.println("Ecco i correntisti insolventi");
        for(Correntista c : correntisti){
            System.out.println(c);
        }
        
        Scanner s = new Scanner(System.in);
        System.out.print("Insierisci il numero di operazioni: ");
        int op = s.nextInt();
        correntisti = ejb.getCorrenistiOperazioni(op);
        System.out.println("Ecco i correntisti con il numero di operazioni maggiore di quello inserito");
        for(Correntista c : correntisti){
            System.out.println(c);
        }
        
        System.out.println("Prova del bonifico da 15000");
        ejb.effettuaBonifico(1, 200000);
    }
    
}
