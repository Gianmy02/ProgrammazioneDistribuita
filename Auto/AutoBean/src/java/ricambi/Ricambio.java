package ricambi;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import static ricambi.Ricambio.TROVA_TUTTI;
import static ricambi.Ricambio.TROVA_CATEGORIA;
import static ricambi.Ricambio.TROVA_PER_ID;
import static ricambi.Ricambio.TROVA_DISPONIBILITA_BASSA;

@Entity
@NamedQueries({
    @NamedQuery (name = TROVA_TUTTI, query ="SELECT r FROM Ricambio r"),
    @NamedQuery(name = TROVA_CATEGORIA, query = "SELECT r FROM Ricambio r WHERE r.categoria = :categoria"),
    @NamedQuery(name = TROVA_PER_ID, query="SELECT r FROM Ricambio r WHERE r.id = ?1"),
    @NamedQuery(name = TROVA_DISPONIBILITA_BASSA, query = "SELECT r FROM Ricambio r WHERE r.disponibilita<10"),
})
@XmlRootElement
public class Ricambio implements Serializable {
    public static final String TROVA_TUTTI = "Ricambio.trovaTutti";
    public static final String TROVA_CATEGORIA = "Ricambio.trovaCategoria";
    public static final String TROVA_PER_ID = "Ricambio.trovaPerId";
    public static final String TROVA_DISPONIBILITA_BASSA = "Ricambio.trovaDisponibilitaBassa";

    @Id
    private int id;
    private String nome;
    private String categoria;
    private float prezzo;
    private int disponibilita;
    private int pezziVenduti;

    public Ricambio() {
    }
    
    public Ricambio(int id, String nome, String categoria, float prezzo, int disponibilita, int pezziVenduti) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.prezzo = prezzo;
        this.disponibilita = disponibilita;
        this.pezziVenduti = pezziVenduti;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    public int getPezziVenduti() {
        return pezziVenduti;
    }

    public void setPezziVenduti(int pezziVenduti) {
        this.pezziVenduti = pezziVenduti;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ricambio{id=").append(id);
        sb.append(", nome=").append(nome);
        sb.append(", categoria=").append(categoria);
        sb.append(", prezzo=").append(prezzo);
        sb.append(", disponibilita=").append(disponibilita);
        sb.append(", pezziVenduti=").append(pezziVenduti);
        sb.append('}');
        return sb.toString();
    }
    
}
