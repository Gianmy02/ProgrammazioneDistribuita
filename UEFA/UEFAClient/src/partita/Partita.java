/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partita;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import static partita.Partita.CERCA_AMMONIZIONI;
import static partita.Partita.CERCA_ESPULSIONI;
import static partita.Partita.CERCA_GIOCATE;
import static partita.Partita.CERCA_PER_ID;
import static partita.Partita.CERCA_TIPO;
import static partita.Partita.GOAL_MAGGIORE;
import static partita.Partita.TROVA_TUTTI;

@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT p FROM Partita p"),
    @NamedQuery(name = CERCA_PER_ID, query = "SELECT p FROM Partita p WHERE p.id = ?1"),
    @NamedQuery(name = CERCA_TIPO, query = "SELECT p FROM Partita p WHERE p.tipo = :tipo"),
    @NamedQuery(name = CERCA_AMMONIZIONI, query = "SELECT p FROM Partita p WHERE p.ammonizioni = ?1"),
    @NamedQuery(name = CERCA_ESPULSIONI, query = "SELECT p FROM Partita p WHERE p.espulsioni = ?1"),
    @NamedQuery(name = GOAL_MAGGIORE, query = "SELECT p FROM Partita p WHERE (p.goalCasa + p.goalOspite) > ?1"),
    @NamedQuery(name = CERCA_GIOCATE, query = "SELECT p FROM Partita p WHERE p.giocata = 'SI'"),
})
public class Partita implements Serializable {

    @Id
    private int id;
    private String tipo;
    private String sqCasa;
    private String sqOspite;
    private int goalCasa;
    private int goalOspite;
    private int ammonizioni;
    private int espulsioni;
    private String giocata;
    
    public static final String TROVA_TUTTI = "Partita.trovaTutti";
    public static final String CERCA_PER_ID = "Partita.cercaPerId";
    public static final String CERCA_TIPO = "Partita.cercaTipo";
    public static final String CERCA_AMMONIZIONI = "Partita.cercaAmmonizioni";
    public static final String CERCA_ESPULSIONI = "Partita.cercaEspulsioni";
    public static final String GOAL_MAGGIORE = "Partita.goalMaggiore";
    public static final String CERCA_GIOCATE = "Partita.cercaGiocate";

    public Partita(int id, String tipo, String sqCasa, String sqOspite, int goalCasa, int goalOspite, int ammonizioni, int espulsioni, String giocata) {
        this.id = id;
        this.tipo = tipo;
        this.sqCasa = sqCasa;
        this.sqOspite = sqOspite;
        this.goalCasa = goalCasa;
        this.goalOspite = goalOspite;
        this.ammonizioni = ammonizioni;
        this.espulsioni = espulsioni;
        this.giocata = giocata;
    }

    public Partita() {
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

    public String getSqCasa() {
        return sqCasa;
    }

    public void setSqCasa(String sqCasa) {
        this.sqCasa = sqCasa;
    }

    public String getSqOspite() {
        return sqOspite;
    }

    public void setSqOspite(String sqOspite) {
        this.sqOspite = sqOspite;
    }

    public int getGoalCasa() {
        return goalCasa;
    }

    public void setGoalCasa(int goalCasa) {
        this.goalCasa = goalCasa;
    }

    public int getGoalOspite() {
        return goalOspite;
    }

    public void setGoalOspite(int goalOspite) {
        this.goalOspite = goalOspite;
    }

    public int getAmmonizioni() {
        return ammonizioni;
    }

    public void setAmmonizioni(int ammonizioni) {
        this.ammonizioni = ammonizioni;
    }

    public int getEspulsioni() {
        return espulsioni;
    }

    public void setEspulsioni(int espulsioni) {
        this.espulsioni = espulsioni;
    }

    public String getGiocata() {
        return giocata;
    }

    public void setGiocata(String giocata) {
        this.giocata = giocata;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Partita{id=").append(id);
        sb.append(", tipo=").append(tipo);
        sb.append(", sqCasa=").append(sqCasa);
        sb.append(", sqOspite=").append(sqOspite);
        sb.append(", goalCasa=").append(goalCasa);
        sb.append(", goalOspite=").append(goalOspite);
        sb.append(", ammonizioni=").append(ammonizioni);
        sb.append(", espulsioni=").append(espulsioni);
        sb.append(", giocata=").append(giocata);
        sb.append('}');
        return sb.toString();
    }
}
