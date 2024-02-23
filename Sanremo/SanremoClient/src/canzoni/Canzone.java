package canzoni;

import static canzoni.Canzone.cercaPerId;
import static canzoni.Canzone.printByCategory;
import static canzoni.Canzone.printByVotes;
import static canzoni.Canzone.printall;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries ({
    @NamedQuery (name = printall, query = "SELECT c FROM Canzone c"),
    @NamedQuery (name = printByCategory, query = "SELECT c FROM Canzone c WHERE c.categoria = :categoria"),
    @NamedQuery (name = cercaPerId, query = "SELECT c FROM Canzone c WHERE c.id = ?1"),
    @NamedQuery (name = printByVotes, query = "SELECT c FROM Canzone c WHERE c.voto > ?1")
})
@XmlRootElement
public class Canzone implements Serializable {
    
    public static final String printall = "Canzone.printall";
    public static final String printByCategory = "Canzone.printByCategory";
    public static final String cercaPerId = "Canzone.cercaPerId";
    public static final String printByVotes = "Canzone.printByVotes";

   @Id
   private int id;
   private String cantante;
   private String categoria;
   private String incipit;
   private boolean cantato;
   private Float voto;

    public Canzone(int id, String cantante, String categoria, String incipit, boolean cantato, Float voto) {
        this.id = id;
        this.cantante = cantante;
        this.categoria = categoria;
        this.incipit = incipit;
        this.cantato = cantato;
        this.voto = voto;
    }

    public boolean isCantato() {
        return cantato;
    }

    public void setCantato(boolean cantato) {
        this.cantato = cantato;
    }

    public Float getVoto() {
        return voto;
    }

    public void setVoto(Float voto) {
        this.voto = voto;
    }

    public Canzone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIncipit() {
        return incipit;
    }

    public void setIncipit(String incipit) {
        this.incipit = incipit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Canzone{id=").append(id);
        sb.append(", cantante=").append(cantante);
        sb.append(", categoria=").append(categoria);
        sb.append(", incipit=").append(incipit);
        sb.append(", cantato=").append(cantato);
        sb.append(", voto=").append(voto);
        sb.append('}');
        return sb.toString();
    }


 
   
   
    
}
