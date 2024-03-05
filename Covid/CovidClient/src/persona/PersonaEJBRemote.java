/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author amministratore
 */
@Remote
public interface PersonaEJBRemote {
    public void aggiungiPersona(Persona p);
    public void eliminaPersona(Persona p);
    public Persona modificaPersona(Persona p);
    public Persona getById(int id);
    public List<Persona> getPersone();
    
    public List<Persona> getByCategoria(String categoria);
    public List<Persona> getByEta(int eta);
    public List<Persona> getByContratti();
    public List<Persona> getDocentiGiovani();
    public List<Persona> getPensionatiInteressati();
}
