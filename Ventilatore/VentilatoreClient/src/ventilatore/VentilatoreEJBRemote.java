/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilatore;

import java.util.List;
import javax.ejb.Remote;


@Remote
public interface VentilatoreEJBRemote {
    public void aggiungiVentilatore(Ventilatore v);
    public void eliminaVentilatore(Ventilatore v);
    public Ventilatore modificaVentilatore(Ventilatore v);
    public Ventilatore getById(int id);
    public List<Ventilatore> getVentilatori();
    
    public List<Ventilatore> printByCountry(String nazione);
    public List<Ventilatore> printQuickFan();
}
