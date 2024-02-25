/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correntistiwebclient;

import java.util.List;
import java.util.Scanner;
import correntisti.Correntista;

/**
 *
 * @author amministratore
 */
public class CorrentistiWebClient {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Insierisci il numero di bonifici ingresso: ");
        int op = s.nextInt();
        List<Correntista> correntisti = getBonificiIngresso(op);
        System.out.println("Ecco i correntisti con il numero di bonifici in ingresso maggiore di quello inserito");
        for(Correntista c : correntisti){
            System.out.println(c);
        }
    }
    
    private static List<Correntista> getBonificiIngresso(java.lang.Integer args0){
        correntisti.CorrentistaEJBService service = new correntisti.CorrentistaEJBService();
        correntisti.CorrentistaEJB port = service.getCorrentistaEJBPort();
        return port.getBonificiIngresso(args0);
    }
    
    
}
