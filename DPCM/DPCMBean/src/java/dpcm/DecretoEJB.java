package dpcm;

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
public class DecretoEJB implements DecretoEJBRemote {

    @Inject
    public EntityManager em;
    
    @Override
    public void aggiungiDecreto(Decreto d) {
        em.persist(d);
    }

    @Override
    public void eliminaDecreto(Decreto d) {
        em.remove(em.merge(d));
    }

    @Override
    public Decreto modificaDecreto(Decreto d) {
        em.merge(d);
        return d;
    }

    @Override
    public List<Decreto> getDecreti() {
        TypedQuery<Decreto> query = em.createNamedQuery(Decreto.TROVA_TUTTI, Decreto.class);
        return query.getResultList();
    }

    @Override
    public Decreto cercaPerId(int id) {
        TypedQuery<Decreto> query = em.createNamedQuery(Decreto.CERCA_PER_ID, Decreto.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public List<Decreto> cercaPerEmergenza(String emergenza) {
        TypedQuery<Decreto> query = em.createNamedQuery(Decreto.CERCA_PER_EMERGENZA, Decreto.class);
        query.setParameter("emergenza", emergenza);
        return query.getResultList();
    }

    @Override
    public List<Decreto> cercaPiuPresentazioni(int presentazioni) {
        TypedQuery<Decreto> query = em.createNamedQuery(Decreto.PIU_PRESENTAZIONI, Decreto.class);
        query.setParameter(1, presentazioni);
        return query.getResultList();
    }
    
    @Override
    public List<Decreto> cercaPerCategoria(String categoria)
    {
        TypedQuery<Decreto> query = em.createNamedQuery(Decreto.CERCA_PER_TIPO, Decreto.class);
        query.setParameter(1, categoria);
        return query.getResultList();
    }
    
}
