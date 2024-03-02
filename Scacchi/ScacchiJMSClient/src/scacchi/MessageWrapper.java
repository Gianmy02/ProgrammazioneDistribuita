package scacchi;

import java.io.Serializable;

public class MessageWrapper implements Serializable{
    private int id;
    private int rating1;
    private int rating2;
    private String mosse;
    private String risultato;
    private boolean conclusa;

    public MessageWrapper(int id, int rating1, int rating2, String mosse, String risultato, boolean conclusa) {
        this.id = id;
        this.rating1 = rating1;
        this.rating2 = rating2;
        this.mosse = mosse;
        this.risultato = risultato;
        this.conclusa = conclusa;
    }

    public int getId() {
        return id;
    }

    public int getRating1() {
        return rating1;
    }

    public int getRating2() {
        return rating2;
    }

    public String getMosse() {
        return mosse;
    }

    public String getRisultato() {
        return risultato;
    }

    public boolean isConclusa() {
        return conclusa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRating1(int rating1) {
        this.rating1 = rating1;
    }

    public void setRating2(int rating2) {
        this.rating2 = rating2;
    }

    public void setMosse(String mosse) {
        this.mosse = mosse;
    }

    public void setRisultato(String risultato) {
        this.risultato = risultato;
    }

    public void setConclusa(boolean conclusa) {
        this.conclusa = conclusa;
    }
    
    
}
