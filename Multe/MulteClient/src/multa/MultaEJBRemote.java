/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multa;

import java.util.List;
import javax.ejb.Remote;


@Remote
public interface MultaEJBRemote {
    public void aggiungiMulta(Multa m);
    public void eliminaMulta(Multa m);
    public Multa modificaMulta(Multa m);
    public Multa cercaMulta(int id);
    public List<Multa> getMulte();
    
    public List<Multa> getContestabili();
    public List<Multa> getByNomecognome(String nomeCognome);
    public List<Multa> getNonPagate();
}
