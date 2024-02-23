package dpcm;

import static dpcm.Decreto.CERCA_PER_EMERGENZA;
import static dpcm.Decreto.CERCA_PER_ID;
import static dpcm.Decreto.CERCA_PER_TIPO;
import static dpcm.Decreto.PIU_PRESENTAZIONI;
import static dpcm.Decreto.TROVA_TUTTI;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@NamedQueries ({
    @NamedQuery (name = TROVA_TUTTI, query = "SELECT d FROM Decreto d"),
    @NamedQuery (name = CERCA_PER_ID, query = "SELECT d FROM Decreto d WHERE d.id = ?1"),
    @NamedQuery (name = CERCA_PER_EMERGENZA, query = "SELECT d FROM Decreto d WHERE d.emergenza = :emergenza"),
    @NamedQuery (name = PIU_PRESENTAZIONI, query = "SELECT d FROM Decreto d WHERE d.NumPres > ?1"),
    @NamedQuery (name = CERCA_PER_TIPO, query = "SELECT d FROM Decreto d WHERE d.tipo = ?1")
})
@XmlRootElement
public class Decreto implements Serializable {

    @Id
    private int id;
    private String nome;
    private String emergenza;
    private String tipo;
    private int livello;
    private int NumPres;
    
    
    public static final String TROVA_TUTTI = "Decreto.trovaTutti";
    public static final String CERCA_PER_ID = "Decreto.cercaPerId";
    public static final String CERCA_PER_EMERGENZA = "Decreto.cercaPerEmergenza";
    public static final String PIU_PRESENTAZIONI = "Decreto.piuPresentazioni";
    public static final String CERCA_PER_TIPO = "Decreto.cercaPerTipo";

    public Decreto(int id, String nome, String emergenza, String tipo, int livello, int NumPres) {
        this.id = id;
        this.nome = nome;
        this.emergenza = emergenza;
        this.tipo = tipo;
        this.livello = livello;
        this.NumPres = NumPres;
    }

    public Decreto() {
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

    public String getEmergenza() {
        return emergenza;
    }

    public void setEmergenza(String emergenza) {
        this.emergenza = emergenza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }

    public int getNumPres() {
        return NumPres;
    }

    public void setNumPres(int NumPres) {
        this.NumPres = NumPres;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Decreto{id=").append(id);
        sb.append(", nome=").append(nome);
        sb.append(", emergenza=").append(emergenza);
        sb.append(", tipo=").append(tipo);
        sb.append(", livello=").append(livello);
        sb.append(", NumPres=").append(NumPres);
        sb.append('}');
        return sb.toString();
    }

    
}
