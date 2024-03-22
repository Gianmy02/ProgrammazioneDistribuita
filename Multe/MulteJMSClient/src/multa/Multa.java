/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multa;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import static multa.Multa.CERCA_CONTESTABILI;
import static multa.Multa.CERCA_NOMECOGNOME;
import static multa.Multa.CERCA_NON_PAGATE;
import static multa.Multa.CERCA_PER_ID;
import static multa.Multa.TROVA_TUTTI;

@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT m FROM Multa m"),
    @NamedQuery(name = CERCA_PER_ID, query = "SELECT m FROM Multa m WHERE m.id = ?1"),
    @NamedQuery(name = CERCA_NOMECOGNOME, query = "SELECT m FROM Multa m WHERE m.nomeCognome = :nomeCognome"),
    @NamedQuery(name = CERCA_CONTESTABILI, query = "SELECT m FROM Multa m WHERE m.notifica <= :dataOggi AND m.notifica >= :data30"),
    @NamedQuery(name = CERCA_NON_PAGATE, query = "SELECT m FROM Multa m WHERE m.stato = 'non pagata'"),
})
public class Multa implements Serializable {

    @Id
    private int id;
    private String nomeCognome;
    private String motivo;
    private int somma;
    private LocalDate notifica;
    private LocalDate caricamento;
    private String stato;
    
    public static final String TROVA_TUTTI = "Multa.trovaTutti";
    public static final String CERCA_PER_ID = "Multa.cercaPerId";
    public static final String CERCA_NOMECOGNOME = "Multa.cercaNomecognome";
    public static final String CERCA_CONTESTABILI = "Multa.cercaContestabili";
    public static final String CERCA_NON_PAGATE = "Multa.cercaNonPagate";

    public Multa(int id, String nomeCognome, String motivo, int somma, LocalDate notifica, LocalDate caricamento, String stato) {
        this.id = id;
        this.nomeCognome = nomeCognome;
        this.motivo = motivo;
        this.somma = somma;
        this.notifica = notifica;
        this.caricamento = caricamento;
        this.stato = stato;
    }

    public Multa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCognome() {
        return nomeCognome;
    }

    public void setNomeCognome(String nomeCognome) {
        this.nomeCognome = nomeCognome;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getSomma() {
        return somma;
    }

    public void setSomma(int somma) {
        this.somma = somma;
    }

    public LocalDate getNotifica() {
        return notifica;
    }

    public void setNotifica(LocalDate notifica) {
        this.notifica = notifica;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Multa{id=").append(id);
        sb.append(", nomeCognome=").append(nomeCognome);
        sb.append(", motivo=").append(motivo);
        sb.append(", somma=").append(somma);
        sb.append(", notifica=").append(notifica);
        sb.append(", caricamento=").append(caricamento);
        sb.append(", stato=").append(stato);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
