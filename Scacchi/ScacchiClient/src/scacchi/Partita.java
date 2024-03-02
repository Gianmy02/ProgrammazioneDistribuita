package scacchi;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import static scacchi.Partita.CERCA_GIOCATORI;
import static scacchi.Partita.CERCA_PER_ID;
import static scacchi.Partita.CERCA_RISULTATO;
import static scacchi.Partita.CERCA_TIPO;
import static scacchi.Partita.PARTITA_RATING;
import static scacchi.Partita.TROVA_MOSSE;
import static scacchi.Partita.TROVA_TUTTI;

@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT p FROM Partita p"),
    @NamedQuery(name = TROVA_MOSSE, query = "SELECT p FROM Partita p WHERE p.mosse LIKE CONCAT('%', :mosse, '%')"),
    @NamedQuery(name = CERCA_PER_ID, query = "SELECT p FROM Partita p WHERE p.id = ?1"),
    @NamedQuery(name = CERCA_TIPO, query = "SELECT p FROM Partita p WHERE p.tipo = :tipo"),
    @NamedQuery(name = CERCA_GIOCATORI, query = "SELECT p FROM Partita p WHERE p.giocatore1 = :giocatore1 AND p.giocatore2 = :giocatore2"),
    @NamedQuery(name = CERCA_RISULTATO, query = "SELECT p FROM Partita p WHERE p.risultato = :risultato"),
    @NamedQuery(name = PARTITA_RATING, query = "SELECT p FROM Partita p WHERE p.rating1 > 2300 AND p.rating2 > 2300"),
})
public class Partita implements Serializable {

    @Id
    private int id;
    private String tipo;
    private String giocatore1;
    private String giocatore2;
    private int rating1;
    private int rating2;
    private String mosse;
    private String risultato;
    private boolean conclusa;
    
    public static final String TROVA_TUTTI = "Partita.trovaTutti";
    public static final String CERCA_PER_ID = "Partita.cercaPerId";
    public static final String CERCA_TIPO = "Partita.cercaTipo";
    public static final String CERCA_GIOCATORI ="Partita.cercaGiocatori";
    public static final String CERCA_RISULTATO = "Partita.cercaRisultato";
    public static final String TROVA_MOSSE = "Partita.trovaMosse";
    public static final String PARTITA_RATING = "Partita.partitaRating";

    public Partita(int id, String tipo, String giocatore1, String giocatore2, int rating1, int rating2, String mosse, String risultato, boolean conclusa) {
        this.id = id;
        this.tipo = tipo;
        this.giocatore1 = giocatore1;
        this.giocatore2 = giocatore2;
        this.rating1 = rating1;
        this.rating2 = rating2;
        this.mosse = mosse;
        this.risultato = risultato;
        this.conclusa = conclusa;
    }

    public Partita() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGiocatore1() {
        return giocatore1;
    }

    public void setGiocatore1(String giocatore1) {
        this.giocatore1 = giocatore1;
    }

    public String getGiocatore2() {
        return giocatore2;
    }

    public void setGiocatore2(String giocatore2) {
        this.giocatore2 = giocatore2;
    }

    public int getRating1() {
        return rating1;
    }

    public void setRating1(int rating1) {
        this.rating1 = rating1;
    }

    public int getRating2() {
        return rating2;
    }

    public void setRating2(int rating2) {
        this.rating2 = rating2;
    }

    public String getMosse() {
        return mosse;
    }

    public void setMosse(String mosse) {
        this.mosse = mosse;
    }

    public String getRisultato() {
        return risultato;
    }

    public void setRisultato(String risultato) {
        this.risultato = risultato;
    }

    public boolean isConclusa() {
        return conclusa;
    }

    public void setConclusa(boolean conclusa) {
        this.conclusa = conclusa;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Partita{id=").append(id);
        sb.append(", tipo=").append(tipo);
        sb.append(", giocatore1=").append(giocatore1);
        sb.append(", giocatore2=").append(giocatore2);
        sb.append(", rating1=").append(rating1);
        sb.append(", rating2=").append(rating2);
        sb.append(", mosse=").append(mosse);
        sb.append(", risultato=").append(risultato);
        sb.append(", conclusa=").append(conclusa);
        sb.append('}');
        return sb.toString();
    }
    
    
}
