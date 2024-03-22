package immobile;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
@WebService
public class ImmobileEJB implements ImmobileEJBRemote{
  @Inject
  private EntityManager em;
  
  //aggiungiImmoBile è cambiato si è aggiunta una B da aggiungiImmoile
  @Override
  public void aggiungiImmobile(Immobile i){
     em.persist(i);
  }

  @Override
  public void eliminaImmobile(Immobile i){
     em.remove(em.merge(i));
  }

  @Override
  public Immobile modificaImmobile(Immobile i){
     em.merge(i);
     //adesso ritorna i, l'oggetto della classe immobile
     return i;
  }

  @Override
  public Immobile getById(int id){
     TypedQuery<Immobile> query = em.createNamedQuery(Immobile.CERCA_PER_ID , Immobile.class);
     query.setParameter(1, id);
     return query.getSingleResult();
  }

  @Override
  public List<Immobile> getImmobili(){
     TypedQuery<Immobile> query = em.createNamedQuery(Immobile.TROVA_TUTTI , Immobile.class); 
     return query.getResultList();   
  }

  @Override
  public List<Immobile> getByIndirizzo(String indirizzo){
     TypedQuery<Immobile> query = em.createNamedQuery(Immobile.TROVA_INDIRIZZO , Immobile.class);
     query.setParameter("indirizzo", indirizzo);
     return query.getResultList();
  }

  @Override
  public List<Immobile> getByStato(String stato){
     TypedQuery<Immobile> query = em.createNamedQuery(Immobile.TROVA_STATO , Immobile.class);
     query.setParameter("stato", stato);
     return query.getResultList();
  }

  @Override
  public List<Immobile> getVenditaDueMesi(){
     TypedQuery<Immobile> query = em.createNamedQuery(Immobile.TROVA_VENDITA_DUE_MESI , Immobile.class);
     LocalDate oggi = LocalDate.now();
     LocalDate meno = oggi.minusMonths(2);
     query.setParameter("data1", meno);
     query.setParameter("data2", oggi);
     query.setParameter("stato", "in vendita");
     return query.getResultList();
  }

}
