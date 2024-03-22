package immobile;

import java.util.List;
import javax.ejb.Remote;

//cambio interface da class
@Remote
public interface ImmobileEJBRemote{
    public void aggiungiImmobile(Immobile i);
    public void eliminaImmobile(Immobile i);
    public Immobile modificaImmobile(Immobile i);
    public Immobile getById(int id);
    public List<Immobile> getImmobili();
    public List<Immobile> getByIndirizzo(String indirizzo);
    public List<Immobile> getByStato(String stato);
    public List<Immobile> getVenditaDueMesi();
}
