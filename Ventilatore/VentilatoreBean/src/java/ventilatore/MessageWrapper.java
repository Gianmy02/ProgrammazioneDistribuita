/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilatore;

import java.io.Serializable;

public class MessageWrapper implements Serializable{
    private int id;
    private int vendite;

    public MessageWrapper(int id, int vendite) {
        this.id = id;
        this.vendite = vendite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendite() {
        return vendite;
    }

    public void setVendite(int vendite) {
        this.vendite = vendite;
    }
    
    
}
