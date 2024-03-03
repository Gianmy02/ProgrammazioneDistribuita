/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viaggi;

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
public class ViaggioEJB implements ViaggioEJBRemote {

    @Inject
    private EntityManager em;
    
    @Override
    public void aggiungiViaggio(Viaggio v) {
        em.persist(v);
    }

    @Override
    public void eliminaViaggio(Viaggio v) {
        em.remove(em.merge(v));
    }

    @Override
    public Viaggio modificaViaggio(Viaggio v) {
        em.merge(v);
        return v;
    }

    @Override
    public Viaggio getById(int id) {
        TypedQuery<Viaggio> query = em.createNamedQuery(Viaggio.CERCA_PER_ID, Viaggio.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public List<Viaggio> getViaggi() {
        TypedQuery<Viaggio> query = em.createNamedQuery(Viaggio.TROVA_TUTTI, Viaggio.class);
        return query.getResultList();
    }

    @Override
    public List<Viaggio> getByDestinazione(String destinazione) {
        TypedQuery<Viaggio> query = em.createNamedQuery(Viaggio.CERCA_DESTINAZIONE, Viaggio.class);
        query.setParameter("destinazione", destinazione);
        return query.getResultList();
    }

    @Override
    public List<Viaggio> getByCategoria(String categoria) {
        TypedQuery<Viaggio> query = em.createNamedQuery(Viaggio.CERCA_CATEGORIA, Viaggio.class);
        query.setParameter("categoria", categoria);
        return query.getResultList();
    }

    @Override
    public List<Viaggio> getDisponibili() {
        TypedQuery<Viaggio> query = em.createNamedQuery(Viaggio.CERCA_DISPONIBILI, Viaggio.class);
        return query.getResultList();
    }

    @Override
    public List<Viaggio> getViaggiPrezzoInf(int prezzo) {
        TypedQuery<Viaggio> query = em.createNamedQuery(Viaggio.PREZZO_INFERIORE, Viaggio.class);
        query.setParameter(1, prezzo);
        return query.getResultList();
    }

}
