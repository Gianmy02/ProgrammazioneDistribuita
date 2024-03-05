/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import static persona.Persona.CERCA_CATEGORIA;
import static persona.Persona.CERCA_COVID;
import static persona.Persona.CERCA_DOCENTI_GIOVANI;
import static persona.Persona.CERCA_ETA;
import static persona.Persona.CERCA_PER_ID;
import static persona.Persona.PENSIONATI_INTERESSATI;
import static persona.Persona.TROVA_TUTTI;

@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT p FROM Persona p"),
    @NamedQuery(name = CERCA_PER_ID, query = "SELECT p FROM Persona p WHERE p.id = ?1"),
    @NamedQuery(name = CERCA_CATEGORIA, query = "SELECT p FROM Persona p WHERE p.categoria = :categoria"),
    @NamedQuery(name = CERCA_ETA, query = "SELECT p FROM Persona p WHERE p.eta = ?1"),
    @NamedQuery(name = CERCA_COVID, query = "SELECT p FROM Persona p WHERE p.covid = true"),
    @NamedQuery(name = CERCA_DOCENTI_GIOVANI, query = "SELECT p FROM Persona p WHERE p.categoria = 'Docente' AND p.eta < 55"),
    @NamedQuery(name = PENSIONATI_INTERESSATI, query = "SELECT p FROM Persona p WHERE p.categoria = 'Pensionato' AND p.interesse = 'si'"),
})
public class Persona implements Serializable {

    @Id
    private int id;
    private String cognome;
    private String nome;
    private String categoria;
    private int eta;
    private String genere;
    private int malattiePregresse;
    private boolean covid;
    private String interesse;
    private String priorita;
    
    public static final String TROVA_TUTTI = "Persona.trovaTutti";
    public static final String CERCA_PER_ID = "Persona.cercaPerId";
    public static final String CERCA_CATEGORIA = "Persona.cercaCategoria";
    public static final String CERCA_ETA = "Persona.cercaEta";
    public static final String CERCA_COVID = "Persona.cercaCovid";
    public static final String CERCA_DOCENTI_GIOVANI = "Persona.cercaDocentiGiovani";
    public static final String PENSIONATI_INTERESSATI = "Persona.pensionatiInteressati";

    public Persona(int id, String cognome, String nome, String categoria, int eta, String genere, int malattiePregresse, boolean covid, String interesse, String priorita) {
        this.id = id;
        this.cognome = cognome;
        this.nome = nome;
        this.categoria = categoria;
        this.eta = eta;
        this.genere = genere;
        this.malattiePregresse = malattiePregresse;
        this.covid = covid;
        this.interesse = interesse;
        this.priorita = priorita;
    }

    public Persona() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
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

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getMalattiePregresse() {
        return malattiePregresse;
    }

    public void setMalattiePregresse(int malattiePregresse) {
        this.malattiePregresse = malattiePregresse;
    }

    public boolean isCovid() {
        return covid;
    }

    public void setCovid(boolean covid) {
        this.covid = covid;
    }

    public String getInteresse() {
        return interesse;
    }

    public void setInteresse(String interesse) {
        this.interesse = interesse;
    }

    public String getPriorita() {
        return priorita;
    }

    public void setPriorita(String priorita) {
        this.priorita = priorita;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{id=").append(id);
        sb.append(", cognome=").append(cognome);
        sb.append(", nome=").append(nome);
        sb.append(", categoria=").append(categoria);
        sb.append(", eta=").append(eta);
        sb.append(", genere=").append(genere);
        sb.append(", malattiePregresse=").append(malattiePregresse);
        sb.append(", covid=").append(covid);
        sb.append(", interesse=").append(interesse);
        sb.append(", priorita=").append(priorita);
        sb.append('}');
        return sb.toString();
    }
    
    
}
