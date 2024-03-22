/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casa;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author amministratore
 */
@Remote
public interface CasaEJBRemote {
    public void aggiungiCasa(Casa c);
    public void eliminaCasa(Casa c);
    public Casa modificaCasa(Casa c);
    public Casa cercaPerId(int id);
    public List<Casa> getCase();
    
    public List<Casa> getByTipo(String tipo);
    public List<Casa> getByCap(String cap);
    public List<Casa> getByPrezzoInferiore(float prezzo);
    public List<Casa> getByPrezzoZona(float minimo, float massimo, String cap);
    public List<Casa> getLibera();
}
