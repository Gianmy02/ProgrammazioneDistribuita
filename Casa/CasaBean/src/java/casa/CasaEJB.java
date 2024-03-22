/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casa;

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
public class CasaEJB implements CasaEJBRemote {

    @Inject
    private EntityManager em;
    
    @Override
    public void aggiungiCasa(Casa c) {
        em.persist(c);
    }

    @Override
    public void eliminaCasa(Casa c) {
        em.remove(em.merge(c));
    }

    @Override
    public Casa modificaCasa(Casa c) {
        em.merge(c);
        return c;
    }

    @Override
    public Casa cercaPerId(int id) {
        TypedQuery<Casa> query = em.createNamedQuery(Casa.CERCA_PER_ID , Casa.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public List<Casa> getCase() {
        TypedQuery<Casa> query = em.createNamedQuery(Casa.TROVA_TUTTI , Casa.class);
        return query.getResultList();
    }

    @Override
    public List<Casa> getByTipo(String tipo) {
        TypedQuery<Casa> query = em.createNamedQuery(Casa.CERCA_TIPO , Casa.class);
        query.setParameter("tipo", tipo);
        return query.getResultList();
    }

    @Override
    public List<Casa> getByCap(String cap) {
        TypedQuery<Casa> query = em.createNamedQuery(Casa.CERCA_CAP , Casa.class);
        query.setParameter("cap", cap);
        return query.getResultList();
    }

    @Override
    public List<Casa> getByPrezzoInferiore(float prezzo) {
        TypedQuery<Casa> query = em.createNamedQuery(Casa.CERCA_PREZZO_INF , Casa.class);
        query.setParameter(1, prezzo);
        return query.getResultList();
    }

    @Override
    public List<Casa> getByPrezzoZona(float minimo, float massimo, String cap) {
        TypedQuery<Casa> query = em.createNamedQuery(Casa.CERCA_INTERVALLO_ZONA , Casa.class);
        query.setParameter(1, minimo);
        query.setParameter(2, massimo);
        query.setParameter(3, cap);
        return query.getResultList();
    }

    @Override
    public List<Casa> getLibera() {
        TypedQuery<Casa> query = em.createNamedQuery(Casa.CERCA_LIBERO , Casa.class);
        query.setParameter(1, "Libero");
        return query.getResultList();
    }

}
