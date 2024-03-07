/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilatore;

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
public class VentilatoreEJB implements VentilatoreEJBRemote {
    @Inject
    private EntityManager em;

    @Override
    public void aggiungiVentilatore(Ventilatore v) {
        em.persist(v);
    }

    @Override
    public void eliminaVentilatore(Ventilatore v) {
        em.remove(em.merge(v));
    }

    @Override
    public Ventilatore modificaVentilatore(Ventilatore v) {
        em.merge(v);
        return v;
    }

    @Override
    public Ventilatore getById(int id) {
        TypedQuery<Ventilatore> query = em.createNamedQuery(Ventilatore.CERCA_PER_ID, Ventilatore.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public List<Ventilatore> getVentilatori() {
        TypedQuery<Ventilatore> query = em.createNamedQuery(Ventilatore.TROVA_TUTTI, Ventilatore.class);
        return query.getResultList();
    }

    @Override
    @Counter
    public List<Ventilatore> printByCountry(String nazione) {
        TypedQuery<Ventilatore> query = em.createNamedQuery(Ventilatore.CERCA_NAZIONE, Ventilatore.class);
        query.setParameter("nazione", nazione);
        return query.getResultList();
    }

    @Override
    public List<Ventilatore> printQuickFan() {
        TypedQuery<Ventilatore> query = em.createNamedQuery(Ventilatore.VELOCITA_SUPERIORE, Ventilatore.class);
        return query.getResultList();
    }
 
    
}
