/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricambi;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author amministratore
 */
@Remote
public interface RicambioEJBRemote {

    void aggiungiRicambio(Ricambio r);
    void eliminaRicambio(Ricambio r);
    Ricambio modificaRicambio(Ricambio r);
    
    List<Ricambio> getRicambi();
    Ricambio cercaPerId(int id);
    List<Ricambio> getRicambiPocoDisponibili();
    List<Ricambio> getRicambiPerCategoria(String categoria);
}
