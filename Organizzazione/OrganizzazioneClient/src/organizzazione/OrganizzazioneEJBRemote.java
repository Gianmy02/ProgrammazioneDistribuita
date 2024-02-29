/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizzazione;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface OrganizzazioneEJBRemote {
    public void aggiungiOrganizzazione(Organizzazione o);
    public void eliminaOrganizzazione(Organizzazione o);
    public Organizzazione modificaOrganizzazione(Organizzazione o);
    public List<Organizzazione> getOrganizzazione();
    
    public Organizzazione trovaPerId(int id);
    public List<Organizzazione> numeroProgettiMaggiore(int progetti);
    public List<Organizzazione> stampaBilancioMaggiore();
    public List<Organizzazione> getTrasparenzaCento();
}
