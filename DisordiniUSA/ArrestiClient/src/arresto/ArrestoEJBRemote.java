/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arresto;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ArrestoEJBRemote {
    public void aggiungiArresto(Arresto a);
    public void eliminaArresto(Arresto a);
    public Arresto modificaArresto(Arresto a);
    public List<Arresto> getArresti(Arresto a);
    
    public Arresto cercaPerId(int id);
    public List<Arresto> getByCognome(String cognome);
    public List<Arresto> getByOrganizzazione(String organizzazione);
    public List<Arresto> getByForzaPolizia(String forzaPolizia);
    public List<Arresto> getByTeoria(String teoria);
    public List<Arresto> getSciamani();
    public List<Arresto> getTatuati(int min);
}
