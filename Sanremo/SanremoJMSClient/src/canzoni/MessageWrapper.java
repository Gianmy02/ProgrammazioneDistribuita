package canzoni;

import java.io.Serializable;

public class MessageWrapper implements Serializable{
    String cantante;
    String incipit;

    public MessageWrapper(String cantante, String incipit) {
        this.cantante = cantante;
        this.incipit = incipit;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public String getIncipit() {
        return incipit;
    }

    public void setIncipit(String incipit) {
        this.incipit = incipit;
    }
    
    
}
