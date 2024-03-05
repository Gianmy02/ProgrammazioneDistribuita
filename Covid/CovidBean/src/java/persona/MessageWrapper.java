/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import java.io.Serializable;

/**
 *
 * @author amministratore
 */
public class MessageWrapper implements Serializable{
    private int id;
    private String interesse;

    public MessageWrapper(int id, String interesse) {
        this.id = id;
        this.interesse = interesse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInteresse() {
        return interesse;
    }

    public void setInteresse(String interesse) {
        this.interesse = interesse;
    }
    
    
}
