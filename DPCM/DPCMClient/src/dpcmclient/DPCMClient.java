package dpcmclient;

import dpcm.Decreto;
import dpcm.DecretoEJBRemote;
import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DPCMClient {

    public static DecretoEJBRemote ejb;
    
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        ejb = (DecretoEJBRemote) ctx.lookup("java:global/DPCMBean/DecretoEJB!dpcm.DecretoEJBRemote");
        System.out.println("DPCM...");
        Scanner s = new Scanner(System.in);
        List<Decreto> decreti = ejb.getDecreti();
        decreti.forEach(d -> {
            System.out.println(d);
        });
        System.out.print("Inserisci una emergenza: ");
        String emergenza = s.nextLine();
        decreti = ejb.cercaPerEmergenza(emergenza);
        System.out.println("DPCM per l'emergenza scelta");
        decreti.forEach(d -> {
            System.out.println(d);
        });
        
        System.out.print("Inserisci una categoria: ");
        String categoria = s.nextLine();
        decreti = ejb.cercaPerCategoria(categoria);
        System.out.println("DPCM per la categoria scelta");
        decreti.forEach(d -> {
            System.out.println(d);
        });
        
        System.out.print("Inserisci un numero di presenze: ");
        int numPres = s.nextInt();
        System.out.println("Ecco i DPCM con maggiori numero di presenze inserita");
        decreti = ejb.cercaPiuPresentazioni(numPres);
        System.out.println("DPCM con numPres maggiore di quella inserita");
        decreti.forEach(d -> {
            System.out.println(d);
        });
    }
    
}
