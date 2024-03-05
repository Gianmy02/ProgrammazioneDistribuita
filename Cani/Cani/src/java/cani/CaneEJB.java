/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cani;

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
@Counter
public class CaneEJB implements CaneEJBRemote {
    @Inject
    private EntityManager em;

    @Override
    public void aggiungiCane(Cane c) {
        em.persist(c);
    }

    @Override
    public void eliminaCane(Cane c) {
        em.remove(em.merge(c));
    }

    @Override
    public Cane modificaCane(Cane c) {
        em.merge(c);
        return c;
    }

    @Override
    public Cane getCaneById(int id) {
        TypedQuery<Cane> query = em.createNamedQuery(Cane.CERCA_PER_ID, Cane.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public List<Cane> getCani() {
        TypedQuery<Cane> query = em.createNamedQuery(Cane.TROVA_TUTTI, Cane.class);
        return query.getResultList();
    }

    @Override
    public List<Cane> getByRazza(String razza) {
        TypedQuery<Cane> query = em.createNamedQuery(Cane.TROVA_RAZZA, Cane.class);
        query.setParameter("razza", razza);
        return query.getResultList();
    }

    @Override
    public List<Cane> getByNome(String nome) {
        TypedQuery<Cane> query = em.createNamedQuery(Cane.TROVA_NOME, Cane.class);
        query.setParameter("nome", nome);
        return query.getResultList();
    }

    @Override
    public List<Cane> getByTaglia(String taglia) {
        TypedQuery<Cane> query = em.createNamedQuery(Cane.TROVA_TAGLIA, Cane.class);
        query.setParameter("taglia", taglia);
        return query.getResultList();
    }

    @Override
    public List<Cane> getByEta(String eta) {
        TypedQuery<Cane> query = em.createNamedQuery(Cane.TROVA_ETA, Cane.class);
        query.setParameter("fasciaEta", eta);
        return query.getResultList();
    }

    @Override
    public List<Cane> getByStatus(boolean status) {
        TypedQuery<Cane> query = em.createNamedQuery(Cane.TROVA_ADOTTATI, Cane.class);
        query.setParameter("status", status);
        return query.getResultList();
    }

    @Override
    public List<Cane> getByTagliaPiccola(String eta) {
        TypedQuery<Cane> query = em.createNamedQuery(Cane.TROVA_PICCOLI, Cane.class);
        query.setParameter("fasciaEta", eta);
        return query.getResultList();
    }

    @Override
    @CheckParameters
    public void adotta(int id) {
        Cane c = this.getCaneById(id);
        c.setStatus(true);
        modificaCane(c);
    }
}
