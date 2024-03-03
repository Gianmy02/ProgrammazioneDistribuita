/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiori;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface FioreEJBRemote {
    public void aggiungiFiore(Fiore f);
    public void eliminaFiore(Fiore f);
    public Fiore modificaFiore(Fiore f);
    public List<Fiore> getFiori();
    public Fiore getFioreById(int id);
    
    public List<Fiore> getbyCiclo(String cicloBiologico);
    public List<Fiore> getByColore(String colore);
    public List<Fiore> getByParassiti(String parassiti);
    public List<Fiore> getByUso(String uso);
    public List<Fiore> getByProprieta(String proprieta);
}
