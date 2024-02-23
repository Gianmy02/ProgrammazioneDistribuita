/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpcm;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface DecretoEJBRemote {
    public void aggiungiDecreto(Decreto d);
    public void eliminaDecreto(Decreto d);
    public Decreto modificaDecreto(Decreto d);
    public List<Decreto> getDecreti();
    
    public Decreto cercaPerId(int id);
    public List<Decreto> cercaPerEmergenza(String emergenza);
    public List<Decreto> cercaPiuPresentazioni(int presentazioni);
    public List<Decreto> cercaPerCategoria(String categoria);
}
