/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizzazione;

import java.io.Serializable;


public class MessageWrapper implements Serializable{
    private Integer nuoviDonatori;
    private Integer id;

    public MessageWrapper(Integer id, Integer nuoviDonatori) {
        this.id = id;
        this.nuoviDonatori = nuoviDonatori;

    }
    
    public Integer getNuoviDonatori() {
        return nuoviDonatori;
    }

    public void setNuoviDonatori(Integer nuoviDonatori) {
        this.nuoviDonatori = nuoviDonatori;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
}
