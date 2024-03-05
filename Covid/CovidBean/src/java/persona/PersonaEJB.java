/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


@Stateless
@LocalBean
public class PersonaEJB implements PersonaEJBRemote {
    @Inject
    private EntityManager em;

    @Override
    public void aggiungiPersona(Persona p) {
        em.persist(p);
    }

    @Override
    public void eliminaPersona(Persona p) {
        em.remove(em.merge(p));
    }

    @Override
    public Persona modificaPersona(Persona p) {
        em.merge(p);
        return p;
    }

    @Override
    public Persona getById(int id) {
        TypedQuery<Persona> query = em.createNamedQuery(Persona.CERCA_PER_ID, Persona.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public List<Persona> getPersone() {
        TypedQuery<Persona> query = em.createNamedQuery(Persona.TROVA_TUTTI, Persona.class);
        return query.getResultList();
    }

    @Override
    public List<Persona> getByCategoria(String categoria) {
        TypedQuery<Persona> query = em.createNamedQuery(Persona.CERCA_CATEGORIA, Persona.class);
        query.setParameter("categoria", categoria);
        return query.getResultList();
    }

    @Override
    public List<Persona> getByEta(int eta) {
        TypedQuery<Persona> query = em.createNamedQuery(Persona.CERCA_ETA, Persona.class);
        query.setParameter(1, eta);
        return query.getResultList();
    }

    @Override
    public List<Persona> getByContratti() {
        TypedQuery<Persona> query = em.createNamedQuery(Persona.CERCA_COVID, Persona.class);
        return query.getResultList();
    }

    @Override
    public List<Persona> getDocentiGiovani() {
        TypedQuery<Persona> query = em.createNamedQuery(Persona.CERCA_DOCENTI_GIOVANI, Persona.class);
        return query.getResultList();
    }

    @Override
    public List<Persona> getPensionatiInteressati() {
        TypedQuery<Persona> query = em.createNamedQuery(Persona.PENSIONATI_INTERESSATI, Persona.class);
        return query.getResultList();
    }
    
    
}
