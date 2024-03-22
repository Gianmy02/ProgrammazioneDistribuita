package immobile;

import static immobile.Immobile.CERCA_PER_ID;
import static immobile.Immobile.TROVA_INDIRIZZO;
import static immobile.Immobile.TROVA_STATO;
import static immobile.Immobile.TROVA_TUTTI;
import static immobile.Immobile.TROVA_VENDITA_DUE_MESI;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
  @NamedQuery(name = CERCA_PER_ID, query = "SELECT i FROM Immobile i WHERE i.id = ?1"),
  @NamedQuery(name = TROVA_TUTTI, query = "SELECT i FROM Immobile i"),
  @NamedQuery(name = TROVA_INDIRIZZO, query = "SELECT i FROM Immobile i WHERE i.indirizzo = :indirizzo"),
  @NamedQuery(name = TROVA_STATO, query = "SELECT i FROM Immobile i WHERE i.stato = :stato"),
  @NamedQuery(name = TROVA_VENDITA_DUE_MESI, query = "SELECT i FROM Immobile i WHERE i.modifica BETWEEN :data1 AND :data2 AND i.stato = :stato"),
})
@XmlRootElement
public class Immobile implements Serializable{
  
  @Id
  private int id;
  private String indirizzo;
  private int valore;
  private LocalDate modifica;
  private LocalDate caricamento;
  private String stato;

  public static final String CERCA_PER_ID = "Immobile.cercaPerId";
  public static final String TROVA_TUTTI = "Immobile.trovaTutti";
  public static final String TROVA_INDIRIZZO = "Immobile.trovaIndirizzo";
  public static final String TROVA_STATO = "Immobile.trovaStato";
  public static final String TROVA_VENDITA_DUE_MESI = "Immobile.trovaVenditaDueMesi";

    public Immobile() {
    }

    public Immobile(int id, String indirizzo, int valore, LocalDate modifica, LocalDate caricamento, String stato) {
        this.id = id;
        this.indirizzo = indirizzo;
        this.valore = valore;
        this.modifica = modifica;
        this.caricamento = caricamento;
        this.stato = stato;
    }
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    public LocalDate getModifica() {
        return modifica;
    }

    public void setModifica(LocalDate modifica) {
        this.modifica = modifica;
    }

    public LocalDate getCaricamento() {
        return caricamento;
    }

    public void setCaricamento(LocalDate caricamento) {
        this.caricamento = caricamento;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

  
}
