/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiori;

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
public class FioreEJB implements FioreEJBRemote {

    @Inject
    private EntityManager em;
    
    @Override
    public void aggiungiFiore(Fiore f) {
        em.persist(f);
    }

    @Override
    public void eliminaFiore(Fiore f) {
        em.remove(em.merge(f));
    }

    @Override
    public Fiore modificaFiore(Fiore f) {
        em.merge(f);
        return f;
    }

    @Override
    public List<Fiore> getFiori() {
        TypedQuery<Fiore> query = em.createNamedQuery(Fiore.TROVA_TUTTI, Fiore.class);
        return query.getResultList();
    }

    @Override
    public Fiore getFioreById(int id) {
        TypedQuery<Fiore> query = em.createNamedQuery(Fiore.TROVA_PER_ID, Fiore.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public List<Fiore> getbyCiclo(String cicloBiologico) {
        TypedQuery<Fiore> query = em.createNamedQuery(Fiore.TROVA_CICLO, Fiore.class);
        query.setParameter("cicloBiologico", cicloBiologico);
        return query.getResultList();
    }

    @Override
    public List<Fiore> getByColore(String colore) {
        TypedQuery<Fiore> query = em.createNamedQuery(Fiore.TROVA_COLORE, Fiore.class);
        query.setParameter("colore", colore);
        return query.getResultList();
    }

    @Override
    public List<Fiore> getByParassiti(String parassiti) {
        TypedQuery<Fiore> query = em.createNamedQuery(Fiore.TROVA_PARASSITI, Fiore.class);   
        query.setParameter("parassiti", parassiti);
        return query.getResultList();
    }
    
    @Override
    public List<Fiore> getByUso(String uso) {
        TypedQuery<Fiore> query = em.createNamedQuery(Fiore.TROVA_USO, Fiore.class);    
        query.setParameter("uso", uso);
        return query.getResultList();
    }
  
    @Override
    public List<Fiore> getByProprieta(String proprieta){
        TypedQuery<Fiore> query = em.createNamedQuery(Fiore.TROVA_PROPRIETA, Fiore.class);
        query.setParameter("proprieta", proprieta);
        return query.getResultList();
    }
}
