/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiori;

import java.io.Serializable;

public class MessageWrapper implements Serializable{
    private int id;
    private int variazioneGiacenza;

    public MessageWrapper(int id, int variazioneGiacenza) {
        this.id = id;
        this.variazioneGiacenza = variazioneGiacenza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVariazioneGiacenza() {
        return variazioneGiacenza;
    }

    public void setVariazioneGiacenza(int variazioneGiacenza) {
        this.variazioneGiacenza = variazioneGiacenza;
    }
}
