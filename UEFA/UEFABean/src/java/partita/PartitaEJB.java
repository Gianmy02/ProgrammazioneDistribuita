/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partita;

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
    public Partita cercaPerId(int id) {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.CERCA_PER_ID, Partita.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public List<Partita> getPartite() {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.TROVA_TUTTI, Partita.class);
        return query.getResultList();
    }

    @Override
    public List<Partita> getByTipo(String tipo) {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.CERCA_TIPO, Partita.class);
        query.setParameter("tipo", tipo);
        return query.getResultList();
    }

    @Override
    public List<Partita> getPartiteByAmmonizioni(int ammonizioni) {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.CERCA_AMMONIZIONI, Partita.class);
        query.setParameter(1, ammonizioni);
        return query.getResultList();
    }

    @Override
    public List<Partita> getPartiteByEspulsioni(int espulsioni) {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.CERCA_ESPULSIONI, Partita.class);
        query.setParameter(1, espulsioni);
        return query.getResultList();
    }

    @Override
    public List<Partita> getPartiteGoalMaggiori(int goal) {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.GOAL_MAGGIORE, Partita.class);
        query.setParameter(1, goal);
        return query.getResultList();
    }

    @Override
    public List<Partita> getGiocate() {
        TypedQuery<Partita> query = em.createNamedQuery(Partita.CERCA_GIOCATE, Partita.class);
        return query.getResultList();
    }
    
    
}
