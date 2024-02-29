/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizzazione;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author amministratore
 */
@WebService
@Stateless
@LocalBean
public class OrganizzazioneEJB implements OrganizzazioneEJBRemote {
    
    @Inject
    private EntityManager em;

    @Override
    public void aggiungiOrganizzazione(Organizzazione o) {
        em.persist(o);
    }

    @Override
    public void eliminaOrganizzazione(Organizzazione o) {
        em.remove(em.merge(o));
    }

    @Override
    public Organizzazione modificaOrganizzazione(Organizzazione o) {
        em.merge(o);
        return o;
    }

    @Override
    public List<Organizzazione> getOrganizzazione() {
        TypedQuery<Organizzazione> query = em.createNamedQuery(Organizzazione.TROVA_TUTTI, Organizzazione.class);
        return query.getResultList();
    }

    @Override
    public Organizzazione trovaPerId(int id) {
        TypedQuery<Organizzazione> query = em.createNamedQuery(Organizzazione.TROVA_PER_ID, Organizzazione.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public List<Organizzazione> numeroProgettiMaggiore(int progetti) {
        TypedQuery<Organizzazione> query = em.createNamedQuery(Organizzazione.NUMERO_PROGETTI, Organizzazione.class);
        query.setParameter(1, progetti);
        return query.getResultList();
    }

    @Override
    @Counter
    public List<Organizzazione> stampaBilancioMaggiore() {
        TypedQuery<Organizzazione> query = em.createNamedQuery(Organizzazione.STAMPA_PER_BILANCIO, Organizzazione.class);
        return query.getResultList();
    }

    @Override
    public List<Organizzazione> getTrasparenzaCento() {
        TypedQuery<Organizzazione> query = em.createNamedQuery(Organizzazione.TRASPARENZA_CENTO, Organizzazione.class);
        return query.getResultList();
    }
}
