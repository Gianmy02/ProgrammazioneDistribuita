/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partita;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author amministratore
 */
@Remote
public interface PartitaEJBRemote {
    public void aggiungiPartita(Partita p);
    public void eliminaPartita(Partita p);
    public Partita modificaPartita(Partita p);
    public Partita cercaPerId(int id);
    public List<Partita> getPartite();
    
    public List<Partita> getByTipo(String tipo);
    public List<Partita> getPartiteByAmmonizioni(int ammonizioni);
    public List<Partita> getPartiteByEspulsioni(int espulsioni);
    public List<Partita> getPartiteGoalMaggiori(int goal);
    public List<Partita> getGiocate();
}
