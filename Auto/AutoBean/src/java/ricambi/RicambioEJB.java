package ricambi;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@WebService
@Stateless
@Counter
@LocalBean
public class RicambioEJB implements RicambioEJBRemote {
    
    @Inject
    private EntityManager em;

    @Override
    public void aggiungiRicambio(Ricambio r) {
        em.persist(r);
    }

    @Override
    public void eliminaRicambio(Ricambio r) {
       em.remove(em.merge(r));
    }

    @Override
    public Ricambio modificaRicambio(Ricambio r) {
       em.merge(r);
       return r;
    }

    @Override
    public List<Ricambio> getRicambi() {
        TypedQuery<Ricambio> query = em.createNamedQuery(Ricambio.TROVA_TUTTI, Ricambio.class);
        return query.getResultList();
    }

    @Override
    public Ricambio cercaPerId(int id) {
        TypedQuery<Ricambio> query = em.createNamedQuery(Ricambio.TROVA_PER_ID, Ricambio.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public List<Ricambio> getRicambiPocoDisponibili() {
        TypedQuery<Ricambio> query = em.createNamedQuery(Ricambio.TROVA_DISPONIBILITA_BASSA, Ricambio.class);
        return query.getResultList();
    }

    @Override
    public List<Ricambio> getRicambiPerCategoria(String categoria) {
        TypedQuery<Ricambio> query = em.createNamedQuery(Ricambio.TROVA_CATEGORIA, Ricambio.class);
        query.setParameter("categoria", categoria);
        return query.getResultList();
    }
    
    
}
