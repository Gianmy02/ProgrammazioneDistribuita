/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cani;

import java.io.Serializable;

/**
 *
 * @author amministratore
 */
public class MessageWrapper implements Serializable{
    int id;

    public MessageWrapper(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
