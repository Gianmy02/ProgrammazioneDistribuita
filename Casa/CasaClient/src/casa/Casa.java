/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casa;

import static casa.Casa.CERCA_CAP;
import static casa.Casa.CERCA_INTERVALLO_ZONA;
import static casa.Casa.CERCA_LIBERO;
import static casa.Casa.CERCA_PER_ID;
import static casa.Casa.CERCA_PREZZO_INF;
import static casa.Casa.CERCA_TIPO;
import static casa.Casa.TROVA_TUTTI;
import java.io.Serializable;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT c FROM Casa c"),
    @NamedQuery(name = CERCA_PER_ID, query = "SELECT c FROM Casa c WHERE c.id = ?1"),
    @NamedQuery(name = CERCA_TIPO, query = "SELECT c FROM Casa c WHERE c.tipo = :tipo"),
    @NamedQuery(name = CERCA_CAP, query = "SELECT c FROM Casa c WHERE c.cap = :cap"),
    @NamedQuery(name = CERCA_PREZZO_INF, query = "SELECT c FROM Casa c WHERE c.prezzo < ?1"),
    @NamedQuery(name = CERCA_INTERVALLO_ZONA, query = "SELECT c FROM Casa c WHERE c.prezzo >= ?1 AND c.prezzo <= ?2 AND c.cap = ?3"),
    @NamedQuery(name = CERCA_LIBERO, query = "SELECT c FROM Casa c WHERE c.stato = ?1"),
})
@XmlRootElement
public class Casa implements Serializable {

    @Id
    private int id;
    private String tipo;
    private String indirizzo;
    private String cap;
    private float prezzo;
    private String stato;
    
    public static final String TROVA_TUTTI = "Casa.trovaTutti";
    public static final String CERCA_PER_ID = "Casa.cercaPerId";
    public static final String CERCA_TIPO = "Casa.cercaTipo";
    public static final String CERCA_CAP = "Casa.cercaCap";
    public static final String CERCA_PREZZO_INF = "Casa.cercaPrezzoInf";
    public static final String CERCA_INTERVALLO_ZONA = "Casa.cercaIntervalloZona";
    public static final String CERCA_LIBERO = "Casa.cercaLibero";

    public Casa(int id, String tipo, String indirizzo, String cap, float prezzo, String stato) {
        this.id = id;
        this.tipo = tipo;
        this.indirizzo = indirizzo;
        this.cap = cap;
        this.prezzo = prezzo;
        this.stato = stato;
    }

    public Casa() {
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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
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
        sb.append("Casa{id=").append(id);
        sb.append(", tipo=").append(tipo);
        sb.append(", indirizzo=").append(indirizzo);
        sb.append(", cap=").append(cap);
        sb.append(", prezzo=").append(prezzo);
        sb.append(", stato=").append(stato);
        sb.append('}');
        return sb.toString();
    }
    
    
}
