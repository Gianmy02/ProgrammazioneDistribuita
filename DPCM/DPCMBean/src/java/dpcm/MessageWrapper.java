package dpcm;

import java.io.Serializable;

public class MessageWrapper implements Serializable{
    private Integer id;
    private Integer numPres;

    public MessageWrapper(Integer id, Integer numPres) {
        this.id = id;
        this.numPres = numPres;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumPres() {
        return numPres;
    }
}
