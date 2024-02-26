/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arresto;

import static arresto.Arresto.CERCA_MINIMO_TATUAGGI;
import static arresto.Arresto.CERCA_PER_COGNOME;
import static arresto.Arresto.CERCA_PER_FORZAPOLIZIA;
import static arresto.Arresto.CERCA_PER_ID;
import static arresto.Arresto.CERCA_PER_ORGANIZZAZIONE;
import static arresto.Arresto.CERCA_PER_TEORIA;
import static arresto.Arresto.CERCA_SCIAMANI;
import static arresto.Arresto.TUTTI_ARRESTI;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries ({
    @NamedQuery(name = CERCA_PER_ID, query = "SELECT a FROM Arresto a WHERE a.id = ?1"),  
    @NamedQuery(name = TUTTI_ARRESTI, query = "SELECT a FROM Arresto a"),
    @NamedQuery(name = CERCA_PER_COGNOME, query = "SELECT a FROM Arresto a WHERE a.cognome = :arresto"),
    @NamedQuery(name = CERCA_PER_TEORIA, query = "SELECT a FROM Arresto a WHERE a.teoria = :teoria"),
    @NamedQuery(name = CERCA_PER_FORZAPOLIZIA, query = "SELECT a FROM Arresto a WHERE a.forzaDiPolizia = :forzaDiPolizia"),
    @NamedQuery(name = CERCA_PER_ORGANIZZAZIONE, query = "SELECT a FROM Arresto a WHERE a.organizzazione = :organizzazione"),
    @NamedQuery(name = CERCA_SCIAMANI, query = "SELECT a FROM Arresto a WHERE a.sciamano = true"),
    @NamedQuery(name = CERCA_MINIMO_TATUAGGI, query = "SELECT a FROM Arresto a WHERE a.numTatuaggi > ?1") 
})
public class Arresto implements Serializable {

    @Id
    private int id;
    private String nome;
    private String cognome;
    private String forzaDiPolizia;
    private String organizzazione;
    private String teoria;
    private int numReati;
    private boolean sciamano;
    private int numTatuaggi;
    
    public static final String CERCA_PER_ID = "Arresto.cercaPerId";
    public static final String TUTTI_ARRESTI = "Arresto.tuttiArresti";
    public static final String CERCA_PER_COGNOME = "Arresto.cercaPerCognome";
    public static final String CERCA_PER_TEORIA = "Arresto.cercaPerTeoria";
    public static final String CERCA_PER_FORZAPOLIZIA ="Arresto.cercaPerForzapolizia";
    public static final String CERCA_PER_ORGANIZZAZIONE = "Arrsto.cercaPerOrganizzazione";
    public static final String CERCA_SCIAMANI = "Arresto.cercaSciamani";
    public static final String CERCA_MINIMO_TATUAGGI = "Arresto.cercaMinimoTatuaggi";

    public Arresto(int id, String nome, String cognome, String forzaDiPolizia, String organizzazione, String teoria, int numReati, boolean sciamano, int numTatuaggi) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.forzaDiPolizia = forzaDiPolizia;
        this.organizzazione = organizzazione;
        this.teoria = teoria;
        this.numReati = numReati;
        this.sciamano = sciamano;
        this.numTatuaggi = numTatuaggi;
    }

    public Arresto() {
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

    public String getForzaDiPolizia() {
        return forzaDiPolizia;
    }

    public void setForzaDiPolizia(String forzaDiPolizia) {
        this.forzaDiPolizia = forzaDiPolizia;
    }

    public String getOrganizzazione() {
        return organizzazione;
    }

    public void setOrganizzazione(String organizzazione) {
        this.organizzazione = organizzazione;
    }

    public String getTeoria() {
        return teoria;
    }

    public void setTeoria(String teoria) {
        this.teoria = teoria;
    }

    public int getNumReati() {
        return numReati;
    }

    public void setNumReati(int numReati) {
        this.numReati = numReati;
    }

    public boolean isSciamano() {
        return sciamano;
    }

    public void setSciamano(boolean sciamano) {
        this.sciamano = sciamano;
    }

    public int getNumTatuaggi() {
        return numTatuaggi;
    }

    public void setNumTatuaggi(int numTatuaggi) {
        this.numTatuaggi = numTatuaggi;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Arresto{id=").append(id);
        sb.append(", nome=").append(nome);
        sb.append(", cognome=").append(cognome);
        sb.append(", forzaDiPolizia=").append(forzaDiPolizia);
        sb.append(", organizzazione=").append(organizzazione);
        sb.append(", teoria=").append(teoria);
        sb.append(", numReati=").append(numReati);
        sb.append(", sciamano=").append(sciamano);
        sb.append(", numTatuaggi=").append(numTatuaggi);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
