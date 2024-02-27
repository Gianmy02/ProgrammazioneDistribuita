/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birra;

import java.io.Serializable;

public class MessageWrapper implements Serializable{
    private int id;
    private int variazioneAlcolica;

    public MessageWrapper(int id, int variazioneAlcolica) {
        this.id = id;
        this.variazioneAlcolica = variazioneAlcolica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVariazioneAlcolica() {
        return variazioneAlcolica;
    }

    public void setVariazioneAlcolica(int variazioneAlcolica) {
        this.variazioneAlcolica = variazioneAlcolica;
    }
    
    
}
