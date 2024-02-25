/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correntisti;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@WebService
@Stateless
@Counter
@LocalBean
public class CorrentistaEJB implements CorrentistaEJBRemote {
    
    @Inject 
    private EntityManager em;

    @Override
    public void aggiungiCorrentista(Correntista c) {
        em.persist(c);
    }

    @Override
    public void eliminaCorrentista(Correntista c) {
        em.remove(em.merge(c));
    }

    @Override
    public Correntista modificaCorrentista(Correntista c) {
        em.merge(c);
        return c;
    }

    @Override
    public List<Correntista> getCorrentisti() {
        TypedQuery<Correntista> query = em.createNamedQuery(Correntista.TROVA_TUTTI, Correntista.class);
        return query.getResultList();
    }

    @Override
    public List<Correntista> getCorrentistiByCognome(String cognome) {
        TypedQuery<Correntista> query = em.createNamedQuery(Correntista.TROVA_COGNOME, Correntista.class);
        query.setParameter("cognome", cognome);
        return query.getResultList();
    }

    @Override
    public List<Correntista> getCorrentistiByImpiego(String impiego) {
        TypedQuery<Correntista> query = em.createNamedQuery(Correntista.TROVA_IMPIEGO, Correntista.class);
        query.setParameter("impiego", impiego);
        return query.getResultList();
    }

    @Override
    public List<Correntista> getCorrentistiInsolventi() {
        TypedQuery<Correntista> query = em.createNamedQuery(Correntista.CERCA_INSOLVENTI, Correntista.class);
        return query.getResultList();
    }

    @Override
    public List<Correntista> getCorrenistiOperazioni(int totale) {
        TypedQuery<Correntista> query = em.createNamedQuery(Correntista.TOTALE_OPERAZIONI, Correntista.class);
        query.setParameter(1, totale);
        return query.getResultList();
    }
    
    @Override
    public List<Correntista> getBonificiIngresso(int totale) {
        TypedQuery<Correntista> query = em.createNamedQuery(Correntista.NUMERO_BONIFICI_INGRESSO, Correntista.class);
        query.setParameter(1, totale);
        return query.getResultList();
    }
    
    @Override
    public Correntista cercaPerId(int id){
        TypedQuery<Correntista> query = em.createNamedQuery(Correntista.CERCA_PER_ID, Correntista.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }
    
    @Override
    @CheckParameters
    public boolean effettuaBonifico(int id, int bonifico){
        Correntista c = cercaPerId(id);
        c.setBonUsc(c.getBonUsc()+1);
        c.setUscTot(c.getUscTot()+1);
        c.setUscita(c.getUscita()+bonifico);
        return true;
    }
    
}
