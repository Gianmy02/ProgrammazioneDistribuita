/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arresto;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class ArrestoEJB implements ArrestoEJBRemote {
    
    @Inject
    private EntityManager em;

    @Override
    public void aggiungiArresto(Arresto a) {
        em.persist(a);
    }

    @Override
    public void eliminaArresto(Arresto a) {
        em.remove(em.merge(a));
    }

    @Override
    public Arresto modificaArresto(Arresto a) {
        em.merge(a);
        return a;
    }
    
    @Override
    public Arresto cercaPerId(int id){
        TypedQuery<Arresto> query = em.createNamedQuery(Arresto.CERCA_PER_ID, Arresto.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public List<Arresto> getArresti(Arresto a) {
        TypedQuery<Arresto> query = em.createNamedQuery(Arresto.TUTTI_ARRESTI, Arresto.class);
        return query.getResultList();
    }

    @Override
    public List<Arresto> getByCognome(String cognome) {
        TypedQuery<Arresto> query = em.createNamedQuery(Arresto.CERCA_PER_COGNOME, Arresto.class);
        query.setParameter("cognome", cognome);
        return query.getResultList();
    }

    @Override
    public List<Arresto> getByOrganizzazione(String organizzazione) {
        TypedQuery<Arresto> query = em.createNamedQuery(Arresto.CERCA_PER_ORGANIZZAZIONE, Arresto.class);
        query.setParameter("organizzazione", organizzazione);
        return query.getResultList();
    }

    @Override
    public List<Arresto> getByForzaPolizia(String forzaPolizia) {
        TypedQuery<Arresto> query = em.createNamedQuery(Arresto.CERCA_PER_FORZAPOLIZIA, Arresto.class);
        query.setParameter("forzaDiPolizia", forzaPolizia);
        return query.getResultList();
    }

    @Override
    public List<Arresto> getByTeoria(String teoria) {
        TypedQuery<Arresto> query = em.createNamedQuery(Arresto.CERCA_PER_TEORIA, Arresto.class);
        query.setParameter("teoria", teoria);
        return query.getResultList();
    }

    @Override
    public List<Arresto> getSciamani() {
        TypedQuery<Arresto> query = em.createNamedQuery(Arresto.CERCA_SCIAMANI, Arresto.class);
        return query.getResultList();
    }

    @Override
    public List<Arresto> getTatuati(int min) {
        TypedQuery<Arresto> query = em.createNamedQuery(Arresto.CERCA_MINIMO_TATUAGGI, Arresto.class);
        query.setParameter(1, min);
        return query.getResultList();
    }
    
}
