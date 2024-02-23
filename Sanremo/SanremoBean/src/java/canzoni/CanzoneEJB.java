package canzoni;

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
public class CanzoneEJB implements CanzoneEJBRemote {
    
    @Inject
    EntityManager em;

    @Override
    public void aggiungiCanzone(Canzone c) {
        em.persist(c);
    }

    @Override
    public void eliminaCanzone(Canzone c) {
        em.remove(em.merge(c));
    }

    @Override
    public Canzone modificaCanzone(Canzone c) {
        em.merge(c);
        return c;
    }

    @Override
    @Counter
    public List<Canzone> getCanzoni() {
        TypedQuery<Canzone> query = em.createNamedQuery(Canzone.printall, Canzone.class);
        return query.getResultList();
    }

    @Override
    public Canzone cercaPerId(int id) {
        TypedQuery<Canzone> query = em.createNamedQuery(Canzone.cercaPerId, Canzone.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    @CheckParameters
    public List<Canzone> printByVotes(float voto) {
        TypedQuery<Canzone> query = em.createNamedQuery(Canzone.printByVotes, Canzone.class);
        query.setParameter(1, voto);
        return query.getResultList();
    }

    @Override
    @Counter
    public List<Canzone> printByCategory(String categoria) {
        TypedQuery<Canzone> query = em.createNamedQuery(Canzone.printByCategory, Canzone.class);
        query.setParameter("categoria", categoria);
        return query.getResultList();
    }

}
