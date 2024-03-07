/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilatore;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import static ventilatore.Ventilatore.CERCA_NAZIONE;
import static ventilatore.Ventilatore.CERCA_PER_ID;
import static ventilatore.Ventilatore.TROVA_TUTTI;
import static ventilatore.Ventilatore.VELOCITA_SUPERIORE;

@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT v FROM Ventilatore v"),
    @NamedQuery(name = CERCA_PER_ID, query = "SELECT v FROM Ventilatore v WHERE v.id = ?1"),
    @NamedQuery(name = CERCA_NAZIONE, query = "SELECT v FROM Ventilatore v WHERE v.nazione = :nazione"),
    @NamedQuery(name = VELOCITA_SUPERIORE, query = "SELECT v FROM Ventilatore v WHERE v.giriMinuto > 2000"),
})
@XmlRootElement
public class Ventilatore implements Serializable {

    @Id
    private int id;
    private String modello;
    private String marca;
    private int giriMinuto;
    private int rumore;
    private int venduti;
    private String nazione;
    
    public static final String TROVA_TUTTI = "Ventilatore.trovaTutti";
    public static final String CERCA_PER_ID = "Ventilatore.cercaPerId";
    public static final String CERCA_NAZIONE = "Ventilatore.cercaNazione";
    public static final String VELOCITA_SUPERIORE = "Ventilatore.velocitaSuperiore";

    public Ventilatore(int id, String modello, String marca, int giriMinuto, int rumore, int venduti, String nazione) {
        this.id = id;
        this.modello = modello;
        this.marca = marca;
        this.giriMinuto = giriMinuto;
        this.rumore = rumore;
        this.venduti = venduti;
        this.nazione = nazione;
    }

    public Ventilatore() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getGiriMinuto() {
        return giriMinuto;
    }

    public void setGiriMinuto(int giriMinuto) {
        this.giriMinuto = giriMinuto;
    }

    public int getRumore() {
        return rumore;
    }

    public void setRumore(int rumore) {
        this.rumore = rumore;
    }

    public int getVenduti() {
        return venduti;
    }

    public void setVenduti(int venduti) {
        this.venduti = venduti;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ventilatore{id=").append(id);
        sb.append(", modello=").append(modello);
        sb.append(", marca=").append(marca);
        sb.append(", giriMinuto=").append(giriMinuto);
        sb.append(", rumore=").append(rumore);
        sb.append(", venduti=").append(venduti);
        sb.append(", nazione=").append(nazione);
        sb.append('}');
        return sb.toString();
    }

    
}
