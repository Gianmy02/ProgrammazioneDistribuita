/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cani;

import static cani.Cane.CERCA_PER_ID;
import static cani.Cane.TROVA_ADOTTATI;
import static cani.Cane.TROVA_ETA;
import static cani.Cane.TROVA_NOME;
import static cani.Cane.TROVA_PICCOLI;
import static cani.Cane.TROVA_RAZZA;
import static cani.Cane.TROVA_TAGLIA;
import static cani.Cane.TROVA_TUTTI;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
    @NamedQuery(name = CERCA_PER_ID, query = "SELECT c FROM Cane c WHERE c.id = ?1"),
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT c FROM Cane c"),
    @NamedQuery(name = TROVA_RAZZA, query = "SELECT c FROM Cane c WHERE c.razza = :razza"),
    @NamedQuery(name = TROVA_NOME, query = "SELECT c FROM Cane c WHERE c.nome = :nome"),
    @NamedQuery(name = TROVA_TAGLIA, query = "SELECT c FROM Cane c WHERE c.taglia = :taglia"),
    @NamedQuery(name = TROVA_ADOTTATI, query = "SELECT c FROM Cane c WHERE c.status = :status"),
    @NamedQuery(name = TROVA_PICCOLI, query = "SELECT c FROM Cane c WHERE c.fasciaEta = :fasciaEta AND c.taglia = 'Piccola'"),
    @NamedQuery(name = TROVA_ETA, query = "SELECT c FROM Cane c WHERE c.fasciaEta = :fasciaEta")
})
@XmlRootElement
public class Cane implements Serializable {

    @Id
    private int id;
    private String razza;
    private String nome;
    private String taglia;
    private String fasciaEta;
    private String sesso;
    private String microchip;
    private boolean status;
    
    public static final String CERCA_PER_ID = "Cane.cercaPerId";
    public static final String TROVA_TUTTI = "Cane.trovaTutti";
    public static final String TROVA_RAZZA = "Cane.trovaRazza";
    public static final String TROVA_NOME = "Cane.trovaNome";
    public static final String TROVA_TAGLIA = "Cane.trovaTaglia";
    public static final String TROVA_ETA = "Cane.trovaEta";
    public static final String TROVA_ADOTTATI = "Cane.trovaAdottati";
    public static final String TROVA_PICCOLI = "Cane.trovaPiccoli";

    public Cane(int id, String razza, String nome, String taglia, String fasciaEta, String sesso, String microchip, boolean status) {
        this.id = id;
        this.razza = razza;
        this.nome = nome;
        this.taglia = taglia;
        this.fasciaEta = fasciaEta;
        this.sesso = sesso;
        this.microchip = microchip;
        this.status = status;
    }

    public Cane() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTaglia() {
        return taglia;
    }

    public void setTaglia(String taglia) {
        this.taglia = taglia;
    }

    public String getFasciaEta() {
        return fasciaEta;
    }

    public void setFasciaEta(String fasciaEta) {
        this.fasciaEta = fasciaEta;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getMicrochip() {
        return microchip;
    }

    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cane{id=").append(id);
        sb.append(", razza=").append(razza);
        sb.append(", nome=").append(nome);
        sb.append(", taglia=").append(taglia);
        sb.append(", fasciaEta=").append(fasciaEta);
        sb.append(", sesso=").append(sesso);
        sb.append(", microchip=").append(microchip);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
 
    

}
