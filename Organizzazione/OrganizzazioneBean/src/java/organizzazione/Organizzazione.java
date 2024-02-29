package organizzazione;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import static organizzazione.Organizzazione.NUMERO_PROGETTI;
import static organizzazione.Organizzazione.STAMPA_PER_BILANCIO;
import static organizzazione.Organizzazione.TRASPARENZA_CENTO;
import static organizzazione.Organizzazione.TROVA_PER_ID;
import static organizzazione.Organizzazione.TROVA_TUTTI;

@Entity
@NamedQueries ({
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT o FROM Organizzazione o"),
    @NamedQuery(name = TROVA_PER_ID, query = "SELECT o FROM Organizzazione o WHERE o.id = ?1"),
    @NamedQuery(name = NUMERO_PROGETTI, query = "SELECT o FROM Organizzazione o WHERE o.numProgetti > ?1"),
    @NamedQuery(name = STAMPA_PER_BILANCIO, query = "SELECT o FROM Organizzazione o WHERE o.bilancio > 50000000"),
    @NamedQuery(name = TRASPARENZA_CENTO, query = "SELECT o FROM Organizzazione o WHERE o.trasparenza = 100"),    
})
@XmlRootElement
public class Organizzazione implements Serializable {

    @Id
    private int id;
    private String nome;
    private String sede;
    private int numProgetti;
    private int numPaesi;
    private int numDonatori;
    private float bilancio;
    private int trasparenza;
    
    public static final String TROVA_TUTTI = "Organizzazione.trovaTutti";
    public static final String TROVA_PER_ID = "Organizzazione.trovaPerId";
    public static final String NUMERO_PROGETTI = "Organizzazione.numeroProgetti";
    public static final String STAMPA_PER_BILANCIO = "Organizzazione.stampaPerBilancio";
    public static final String TRASPARENZA_CENTO = "Organizzazione.trasparenzaCento";

    public Organizzazione(int id, String nome, String sede, int numProgetti, int numPaesi, int numDonatori, float bilancio, int trasparenza) {
        this.id = id;
        this.nome = nome;
        this.sede = sede;
        this.numProgetti = numProgetti;
        this.numPaesi = numPaesi;
        this.numDonatori = numDonatori;
        this.bilancio = bilancio;
        this.trasparenza = trasparenza;
    }

    public Organizzazione() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getNumProgetti() {
        return numProgetti;
    }

    public void setNumProgetti(int numProgetti) {
        this.numProgetti = numProgetti;
    }

    public int getNumPaesi() {
        return numPaesi;
    }

    public void setNumPaesi(int numPaesi) {
        this.numPaesi = numPaesi;
    }

    public int getNumDonatori() {
        return numDonatori;
    }

    public void setNumDonatori(int numDonatori) {
        this.numDonatori = numDonatori;
    }

    public float getBilancio() {
        return bilancio;
    }

    public void setBilancio(float bilancio) {
        this.bilancio = bilancio;
    }

    public int getTrasparenza() {
        return trasparenza;
    }

    public void setTrasparenza(int trasparenza) {
        this.trasparenza = trasparenza;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Organizzazione{id=").append(id);
        sb.append(", nome=").append(nome);
        sb.append(", sede=").append(sede);
        sb.append(", numProgetti=").append(numProgetti);
        sb.append(", numPaesi=").append(numPaesi);
        sb.append(", numDonatori=").append(numDonatori);
        sb.append(", bilancio=").append(bilancio);
        sb.append(", trasparenza=").append(trasparenza);
        sb.append('}');
        return sb.toString();
    }
    
    
}
