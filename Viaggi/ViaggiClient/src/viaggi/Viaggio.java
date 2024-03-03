/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viaggi;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import static viaggi.Viaggio.CERCA_CATEGORIA;
import static viaggi.Viaggio.CERCA_DESTINAZIONE;
import static viaggi.Viaggio.CERCA_DISPONIBILI;
import static viaggi.Viaggio.CERCA_PER_ID;
import static viaggi.Viaggio.PREZZO_INFERIORE;
import static viaggi.Viaggio.TROVA_TUTTI;

@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT v FROM Viaggio v"),
    @NamedQuery(name = CERCA_PER_ID, query = "SELECT v FROM Viaggio v WHERE v.id = ?1"),
    @NamedQuery(name = CERCA_DESTINAZIONE, query = "SELECT v FROM Viaggio v WHERE v.destinazione = :destinazione"),
    @NamedQuery(name = CERCA_CATEGORIA, query = "SELECT v FROM Viaggio v WHERE v.categoria = :categoria"),
    @NamedQuery(name = CERCA_DISPONIBILI, query = "SELECT v FROM Viaggio v WHERE v.disponibilita > 0"),
    @NamedQuery(name = PREZZO_INFERIORE, query = "SELECT v FROM Viaggio v WHERE v.prezzo < ?1"),
})
public class Viaggio implements Serializable {

    @Id
    private int id;
    private String categoria;
    private String destinazione;
    private int prezzo;
    private int sconto;
    private int disponibilita;

    
    public static final String TROVA_TUTTI = "Viaggio.trovaTutti";
    public static final String CERCA_PER_ID = "Viaggio.cercaPerId";
    public static final String CERCA_DESTINAZIONE = "Viaggio.cercaDestinazione";
    public static final String CERCA_CATEGORIA = "Viaggio.cercaCategoria";
    public static final String CERCA_DISPONIBILI = "Viaggio.cercaDisponibili";
    public static final String PREZZO_INFERIORE = "Viaggio.prezzoInferiore";
    
    public Viaggio(int id, String categoria, String destinazione, int prezzo, int sconto, int disponibilita) {
        this.id = id;
        this.categoria = categoria;
        this.destinazione = destinazione;
        this.prezzo = prezzo;
        this.sconto = sconto;
        this.disponibilita = disponibilita;
    }

    public Viaggio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public int getSconto() {
        return sconto;
    }

    public void setSconto(int sconto) {
        this.sconto = sconto;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Viaggio{id=").append(id);
        sb.append(", categoria=").append(categoria);
        sb.append(", destinazione=").append(destinazione);
        sb.append(", prezzo=").append(prezzo);
        sb.append(", sconto=").append(sconto);
        sb.append(", disponibilita=").append(disponibilita);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
