/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correntisti;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface CorrentistaEJBRemote {
    public void aggiungiCorrentista(Correntista c);
    public void eliminaCorrentista(Correntista c);
    public Correntista modificaCorrentista(Correntista c);
    public List<Correntista> getCorrentisti();
    
    public List<Correntista> getCorrentistiByCognome(String cognome);
    public List<Correntista> getCorrentistiByImpiego(String impiego);
    public List<Correntista> getCorrentistiInsolventi();
    public List<Correntista> getCorrenistiOperazioni(int totale);
    public Correntista cercaPerId(int id);
    public List<Correntista> getBonificiIngresso(int totale);
    public boolean effettuaBonifico(int id, int bonifico);
}
