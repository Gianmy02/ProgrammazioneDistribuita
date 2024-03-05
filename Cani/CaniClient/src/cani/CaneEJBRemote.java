/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cani;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface CaneEJBRemote {
    public void aggiungiCane(Cane c);
    public void eliminaCane(Cane c);
    public Cane modificaCane(Cane c);
    public Cane getCaneById(int id);
    public List<Cane> getCani();
    
    public List<Cane> getByRazza(String razza);
    public List<Cane> getByNome(String nome);
    public List<Cane> getByTaglia(String taglia);
    public List<Cane> getByEta(String eta);
    public List<Cane> getByStatus(boolean status);
    public List<Cane> getByTagliaPiccola(String eta);
    public void adotta(int id);
}
