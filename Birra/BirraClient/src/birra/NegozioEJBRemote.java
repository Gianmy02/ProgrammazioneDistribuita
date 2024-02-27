/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birra;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author amministratore
 */
@Remote
public interface NegozioEJBRemote {
    public void aggiungiNegozio(Negozio n);
    public void eliminaNegozio(Negozio n);
    public Negozio modificaNegozio(Negozio n);
    public List<Negozio> getNeogzi();
    
    public Negozio cercaPerId(int id);
    public List<Negozio> getByRegione(String regione);
    public List<Negozio> getAlcolici();
}
