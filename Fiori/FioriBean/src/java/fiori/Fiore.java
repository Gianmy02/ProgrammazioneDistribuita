/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiori;

import static fiori.Fiore.TROVA_CICLO;
import static fiori.Fiore.TROVA_COLORE;
import static fiori.Fiore.TROVA_PARASSITI;
import static fiori.Fiore.TROVA_PER_ID;
import static fiori.Fiore.TROVA_PROPRIETA;
import static fiori.Fiore.TROVA_TUTTI;
import static fiori.Fiore.TROVA_USO;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_PER_ID, query = "SELECT f FROM Fiore f WHERE f.id = ?1"),
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT f FROM Fiore f"),
    @NamedQuery(name = TROVA_CICLO, query = "SELECT f FROM Fiore f WHERE f.cicloBiologico = :cicloBiologico"),
    @NamedQuery(name = TROVA_COLORE, query = "SELECT f FROM Fiore f WHERE f.colore = :colore"),
    @NamedQuery(name = TROVA_PARASSITI, query = "SELECT f FROM Fiore f WHERE f.parassiti = :parassiti"),
    @NamedQuery(name = TROVA_USO, query = "SELECT f FROM Fiore f WHERE f.uso = :uso"),
    @NamedQuery(name = TROVA_PROPRIETA, query = "SELECT f FROM Fiore f WHERE f.proprieta = :proprieta"),
})
@XmlRootElement
public class Fiore implements Serializable {

    @Id
    private int id;
    private String specie;
    private String famigliaBotanica;
    private String cicloBiologico;
    private String origine;
    private String proprieta;
    private String colore; 
    private String parassiti;
    private String uso;
    private int giacenza;
    
    public static final String TROVA_PER_ID = "Fiore.trovaPerId";
    public static final String TROVA_TUTTI = "Fiore.trovaTutti";
    public static final String TROVA_CICLO = "Fiore.trovaCiclo";
    public static final String TROVA_COLORE = "Fiore.trovaColore";
    public static final String TROVA_PARASSITI = "Fiore.trovaParassiti";
    public static final String TROVA_USO = "Fiore.trovaUso";
    public static final String TROVA_PROPRIETA = "Fiore.trovaProprieta";
    
    public Fiore() {
    }

    public Fiore(int id, String specie, String famigliaBotanica, String cicloBiologico, String origine, String proprieta, String colore, String parassiti, String uso, int giacenza) {
        this.id = id;
        this.specie = specie;
        this.famigliaBotanica = famigliaBotanica;
        this.cicloBiologico = cicloBiologico;
        this.origine = origine;
        this.proprieta = proprieta;
        this.colore = colore;
        this.parassiti = parassiti;
        this.uso = uso;
        this.giacenza = giacenza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getFamigliaBotanica() {
        return famigliaBotanica;
    }

    public void setFamigliaBotanica(String famigliaBotanica) {
        this.famigliaBotanica = famigliaBotanica;
    }

    public String getCicloBiologico() {
        return cicloBiologico;
    }

    public void setCicloBiologico(String cicloBiologico) {
        this.cicloBiologico = cicloBiologico;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getProprieta() {
        return proprieta;
    }

    public void setProprieta(String proprieta) {
        this.proprieta = proprieta;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String getParassiti() {
        return parassiti;
    }

    public void setParassiti(String parassiti) {
        this.parassiti = parassiti;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public int getGiacenza() {
        return giacenza;
    }

    public void setGiacenza(int giacenza) {
        this.giacenza = giacenza;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fiore{id=").append(id);
        sb.append(", specie=").append(specie);
        sb.append(", famigliaBotanica=").append(famigliaBotanica);
        sb.append(", cicloBiologico=").append(cicloBiologico);
        sb.append(", origine=").append(origine);
        sb.append(", proprieta=").append(proprieta);
        sb.append(", colore=").append(colore);
        sb.append(", parassiti=").append(parassiti);
        sb.append(", uso=").append(uso);
        sb.append(", giacenza=").append(giacenza);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
