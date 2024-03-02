/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchi;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@WebService
@Stateless
@LocalBean
public class PartitaEJB implements PartitaEJBRemote {
    
    @Inject
    private EntityManager em;

    @Override
    public void aggiungiPartita(Partita p) {
        em.persist(p);
    }

    @Override
    public void eliminaPartita(Partita p) {
        em.remove(em.merge(p));
    }

    @Override
    public Partita modificaPartita(Partita p) {
        em.merge(p);
        return p;
    }

    @Override
    public List<Partita> getPartite() {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.TROVA_TUTTI, Partita.class);
        return query.getResultList();
    }

    @Override
    public Partita getById(int id) {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.CERCA_PER_ID, Partita.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public List<Partita> partiteByTipo(String tipo) {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.CERCA_TIPO, Partita.class);
        query.setParameter("tipo", tipo);
        return query.getResultList();
    }

    @Override
    public List<Partita> partiteByGiocatore(String g1, String g2) {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.CERCA_GIOCATORI, Partita.class);
        query.setParameter("giocatore1", g1);
        query.setParameter("giocatore2", g2);
        return query.getResultList();
    }

    @Override
    public List<Partita> partiteByRisultato(String risultato) {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.CERCA_RISULTATO, Partita.class);
        query.setParameter("risultato", risultato);
        return query.getResultList();
    }

    @Override
    public List<Partita> partiteByMosse(String mosse) {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.TROVA_MOSSE, Partita.class);
        query.setParameter("mosse", mosse);
        return query.getResultList();
    }

    @Override
    public List<Partita> partiteRatingMaggiore() {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.PARTITA_RATING, Partita.class);
        return query.getResultList();
    }


}
