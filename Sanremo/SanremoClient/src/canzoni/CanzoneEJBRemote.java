/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canzoni;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface CanzoneEJBRemote {
    public void aggiungiCanzone(Canzone c);
    public void eliminaCanzone(Canzone c);
    public Canzone modificaCanzone(Canzone c);
    public List<Canzone> getCanzoni();
    
    public Canzone cercaPerId(int id);
    public List<Canzone> printByVotes(Float voto);
    public List<Canzone> printByCategory(String categoria);
}
