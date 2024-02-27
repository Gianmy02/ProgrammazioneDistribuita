/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birra;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


@Stateless
@LocalBean
@WebService
public class NegozioEJB implements NegozioEJBRemote {

    @Inject
    private EntityManager em;
    @Override
    public void aggiungiNegozio(Negozio n) {
        em.persist(n);
    }

    @Override
    public void eliminaNegozio(Negozio n) {
        em.remove(em.merge(n));
    }

    @Override
    public Negozio modificaNegozio(Negozio n) {
        em.merge(n);
        return n;
    }

    @Override
    public List<Negozio> getNeogzi() {
        TypedQuery<Negozio> query = em.createNamedQuery(Negozio.TROVA_TUTTI, Negozio.class);
        return query.getResultList();
    }

    @Override
    public Negozio cercaPerId(int id) {
        TypedQuery<Negozio> query = em.createNamedQuery(Negozio.TROVA_PER_ID, Negozio.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    @Counter
    public List<Negozio> getByRegione(String regione) {
        TypedQuery<Negozio> query = em.createNamedQuery(Negozio.TROVA_REGIONE, Negozio.class);
        query.setParameter("regione", regione);
        return query.getResultList();
    }

    @Override
    public List<Negozio> getAlcolici() {
        TypedQuery<Negozio> query = em.createNamedQuery(Negozio.ALCOLICHE_MAGGIORE, Negozio.class);
        return query.getResultList();
    }
    
    @Inject
    Event<Negozio> event;
    
    public void updateDirector(int id, String director){
        Negozio n = cercaPerId(id);
        n.setDirettore(director);
        modificaNegozio(n);
        event.fire(n);
    }
}
