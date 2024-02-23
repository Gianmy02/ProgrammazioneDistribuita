package ricambi;

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
