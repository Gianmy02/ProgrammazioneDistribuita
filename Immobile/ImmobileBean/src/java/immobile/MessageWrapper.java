package immobile;

import java.io.Serializable;
import java.time.LocalDate;

public class MessageWrapper implements Serializable{
  private int id;
  private String indirizzo;
  private int valore;
  private LocalDate modifica;
  private LocalDate caricamento;
  private String stato;

    public MessageWrapper(int id, String indirizzo, int valore, String stato) {
        this.id = id;
        this.indirizzo = indirizzo;
        this.valore = valore;
        this.stato = stato;
        this.caricamento = LocalDate.now();
        this.modifica = LocalDate.now();
    }

    public MessageWrapper(int id, String stato) {
        this.id = id;
        this.modifica = LocalDate.now();
        this.stato = stato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    public LocalDate getModifica() {
        return modifica;
    }

    public void setModifica(LocalDate modifica) {
        this.modifica = modifica;
    }

    public LocalDate getCaricamento() {
        return caricamento;
    }

    public void setCaricamento(LocalDate caricamento) {
        this.caricamento = caricamento;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }    
  
}
