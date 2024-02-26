/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arresto;

import java.io.Serializable;


public class MessageWrapper implements Serializable{
    private Integer id;
    private Integer variazioneReati;
    private Integer variazioneTatuaggi;

    public MessageWrapper(Integer id, Integer variazioneReati, Integer variazioneTatuaggi) {
        this.id = id;
        this.variazioneReati = variazioneReati;
        this.variazioneTatuaggi = variazioneTatuaggi;
    }

    public int getId() {
        return id;
    }

    public int getVariazioneReati() {
        return variazioneReati;
    }

    public int getVariazioneTatuaggi() {
        return variazioneTatuaggi;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVariazioneReati(int variazioneReati) {
        this.variazioneReati = variazioneReati;
    }

    public void setVariazioneTatuaggi(int variazioneTatuaggi) {
        this.variazioneTatuaggi = variazioneTatuaggi;
    }
    
    
}
