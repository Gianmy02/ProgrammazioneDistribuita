/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viaggi;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author amministratore
 */
@Remote
public interface ViaggioEJBRemote {
    public void aggiungiViaggio(Viaggio v);
    public void eliminaViaggio(Viaggio v);
    public Viaggio modificaViaggio(Viaggio v);
    public Viaggio getById(int id);
    public List<Viaggio> getViaggi();
    
    public List<Viaggio> getByDestinazione(String destinazione);
    public List<Viaggio> getByCategoria(String categoria);
    public List<Viaggio> getDisponibili();
    public List<Viaggio> getViaggiPrezzoInf(int prezzo);
}
