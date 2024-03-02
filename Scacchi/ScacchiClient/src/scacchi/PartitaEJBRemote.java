/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchi;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface PartitaEJBRemote {
    public void aggiungiPartita(Partita p);
    public void eliminaPartita(Partita p);
    public Partita modificaPartita(Partita p);
    public List<Partita> getPartite();
    public Partita getById(int id);
    
    public List<Partita> partiteByTipo(String tipo);
    public List<Partita> partiteByGiocatore(String g1, String g2);
    public List<Partita> partiteByRisultato(String risultato);
    public List<Partita> partiteByMosse(String mosse);
    public List<Partita> partiteRatingMaggiore();
}
