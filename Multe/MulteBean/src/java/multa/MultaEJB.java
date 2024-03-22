/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multa;

import java.time.LocalDate;
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
public class MultaEJB implements MultaEJBRemote {
    
    @Inject
    private EntityManager em;

    @Override
    public void aggiungiMulta(Multa m) {
        em.persist(m);
    }

    @Override
    public void eliminaMulta(Multa m) {
        em.remove(em.merge(m));
    }

    @Override
    public Multa modificaMulta(Multa m) {
        em.merge(m);
        return m;
    }

    @Override
    public Multa cercaMulta(int id) {
        TypedQuery<Multa> query = em.createNamedQuery(Multa.CERCA_PER_ID, Multa.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public List<Multa> getMulte() {
        TypedQuery<Multa> query = em.createNamedQuery(Multa.TROVA_TUTTI, Multa.class);
        return query.getResultList();
    }

    @Override
    public List<Multa> getContestabili() {
        TypedQuery<Multa> query = em.createNamedQuery(Multa.CERCA_CONTESTABILI, Multa.class);
        query.setParameter("dataOggi", LocalDate.now());
        query.setParameter("data30", LocalDate.now().minusDays(30));
        return query.getResultList();
    }

    @Override
    public List<Multa> getByNomecognome(String nomeCognome) {
        TypedQuery<Multa> query = em.createNamedQuery(Multa.CERCA_NOMECOGNOME, Multa.class);
        query.setParameter("nomeCognome", nomeCognome);
        return query.getResultList();
    }

    @Override
    public List<Multa> getNonPagate() {
        TypedQuery<Multa> query = em.createNamedQuery(Multa.CERCA_NON_PAGATE, Multa.class);
        return query.getResultList();
    }

}
