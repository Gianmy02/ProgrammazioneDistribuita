/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birra;

import static birra.Negozio.ALCOLICHE_MAGGIORE;
import static birra.Negozio.TROVA_PER_ID;
import static birra.Negozio.TROVA_REGIONE;
import static birra.Negozio.TROVA_TUTTI;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries ({
    @NamedQuery (name = TROVA_TUTTI, query = "SELECT n FROM Negozio n"),
    @NamedQuery (name = TROVA_PER_ID, query = "SELECT n FROM Negozio n WHERE n.id = ?1"),
    @NamedQuery (name = TROVA_REGIONE, query = "SELECT n FROM Negozio n WHERE n.regione = :regione"),
    @NamedQuery (name = ALCOLICHE_MAGGIORE, query = "SELECT n FROM Negozio n WHERE n.birreAlcoliche>n.birreAnalcoliche"),
})
@XmlRootElement
public class Negozio implements Serializable {

    @Id
    private int id;
    private String nome;
    private String direttore;
    private int birreAlcoliche;
    private int birreAnalcoliche;
    private String citta;
    private String provincia;
    private String regione;
   
    public static final String TROVA_TUTTI = "Negozio.trovaTutti";
    public static final String TROVA_PER_ID = "Negozio.trovaPerId";
    public static final String TROVA_REGIONE = "Negozio.trovaRegione";
    public static final String ALCOLICHE_MAGGIORE = "Negozio.alcolicheMaggiore";

    public Negozio(int id, String nome, String direttore, int birreAlcoliche, int birreAnalcoliche, String citta, String provincia, String regione) {
        this.id = id;
        this.nome = nome;
        this.direttore = direttore;
        this.birreAlcoliche = birreAlcoliche;
        this.birreAnalcoliche = birreAnalcoliche;
        this.citta = citta;
        this.provincia = provincia;
        this.regione = regione;
    }

    public Negozio() {
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

    public String getDirettore() {
        return direttore;
    }

    public void setDirettore(String direttore) {
        this.direttore = direttore;
    }

    public int getBirreAlcoliche() {
        return birreAlcoliche;
    }

    public void setBirreAlcoliche(int birreAlcoliche) {
        this.birreAlcoliche = birreAlcoliche;
    }

    public int getBirreAnalcoliche() {
        return birreAnalcoliche;
    }

    public void setBirreAnalcoliche(int birreAnalcoliche) {
        this.birreAnalcoliche = birreAnalcoliche;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Negozio{id=").append(id);
        sb.append(", nome=").append(nome);
        sb.append(", direttore=").append(direttore);
        sb.append(", birreAlcoliche=").append(birreAlcoliche);
        sb.append(", birreAnalcoliche=").append(birreAnalcoliche);
        sb.append(", citta=").append(citta);
        sb.append(", provincia=").append(provincia);
        sb.append(", regione=").append(regione);
        sb.append('}');
        return sb.toString();
    }


}
