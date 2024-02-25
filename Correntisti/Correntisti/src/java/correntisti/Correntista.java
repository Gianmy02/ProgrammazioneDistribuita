/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correntisti;

import static correntisti.Correntista.CERCA_INSOLVENTI;
import static correntisti.Correntista.CERCA_PER_ID;
import static correntisti.Correntista.NUMERO_BONIFICI_INGRESSO;
import static correntisti.Correntista.TOTALE_OPERAZIONI;
import static correntisti.Correntista.TROVA_COGNOME;
import static correntisti.Correntista.TROVA_IMPIEGO;
import static correntisti.Correntista.TROVA_TUTTI;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries ({
    @NamedQuery(name = TROVA_TUTTI, query ="SELECT c FROM Correntista c"),
    @NamedQuery(name = TROVA_COGNOME, query ="SELECT c FROM Correntista c WHERE c.cognome = :cognome"),
    @NamedQuery(name = TROVA_IMPIEGO, query ="SELECT c FROM Correntista c WHERE c.impiego = :impiego"),
    @NamedQuery(name = CERCA_INSOLVENTI, query ="SELECT c FROM Correntista c WHERE c.insolvente = 'SI'"),
    @NamedQuery(name = TOTALE_OPERAZIONI, query ="SELECT c FROM Correntista c WHERE (c.ingTot + c.uscTot) > ?1"),
    @NamedQuery(name = CERCA_PER_ID, query ="SELECT c FROM Correntista c WHERE c.id = ?1"),
    @NamedQuery(name = NUMERO_BONIFICI_INGRESSO, query = "SELECT c FROM Correntista c WHERE c.ingTot > ?1")

})
@XmlRootElement
public class Correntista implements Serializable {

    @Id
    private int id;
    private String nome;
    private String cognome;
    private String impiego;
    private String insolvente;
    private int bonIng;
    private int bonUsc;
    private int ingTot;
    private int uscTot;
    private int ingresso;
    private int uscita;
    
    public static final String TROVA_TUTTI = "Correntista.trovaTutti"; 
    public static final String CERCA_PER_ID = "Correntista.cercaPerId"; 
    public static final String TROVA_COGNOME = "Correntista.trovaCognome"; 
    public static final String TROVA_IMPIEGO = "Correntista.trovaImpiego";
    public static final String CERCA_INSOLVENTI = "Correntista.cercaInsolventi";
    public static final String TOTALE_OPERAZIONI = "Correntista.totaleOperazioni"; 
    public static final String NUMERO_BONIFICI_INGRESSO = "Correntista.numeroBonificiIngresso";
    
    public Correntista(int id, String nome, String cognome, String impiego, String insolvente, int bonIng, int bonUsc, int ingTot, int uscTot, int ingresso, int uscita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.impiego = impiego;
        this.insolvente = insolvente;
        this.bonIng = bonIng;
        this.bonUsc = bonUsc;
        this.ingTot = ingTot;
        this.uscTot = uscTot;
        this.ingresso = ingresso;
        this.uscita = uscita;
    }

    public Correntista() {
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getImpiego() {
        return impiego;
    }

    public void setImpiego(String impiego) {
        this.impiego = impiego;
    }

    public String getInsolvente() {
        return insolvente;
    }

    public void setInsolvente(String insolvente) {
        this.insolvente = insolvente;
    }

    public int getBonIng() {
        return bonIng;
    }

    public void setBonIng(int bonIng) {
        this.bonIng = bonIng;
    }

    public int getBonUsc() {
        return bonUsc;
    }

    public void setBonUsc(int bonUsc) {
        this.bonUsc = bonUsc;
    }

    public int getIngTot() {
        return ingTot;
    }

    public void setIngTot(int ingTot) {
        this.ingTot = ingTot;
    }

    public int getUscTot() {
        return uscTot;
    }

    public void setUscTot(int uscTot) {
        this.uscTot = uscTot;
    }

    public int getIngresso() {
        return ingresso;
    }

    public void setIngresso(int ingresso) {
        this.ingresso = ingresso;
    }

    public int getUscita() {
        return uscita;
    }

    public void setUscita(int uscita) {
        this.uscita = uscita;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Correntista{id=").append(id);
        sb.append(", nome=").append(nome);
        sb.append(", cognome=").append(cognome);
        sb.append(", impiego=").append(impiego);
        sb.append(", insolvente=").append(insolvente);
        sb.append(", bonIng=").append(bonIng);
        sb.append(", bonUsc=").append(bonUsc);
        sb.append(", ingTot=").append(ingTot);
        sb.append(", uscTot=").append(uscTot);
        sb.append(", ingresso=").append(ingresso);
        sb.append(", uscita=").append(uscita);
        sb.append('}');
        return sb.toString();
    }
    
    
}
