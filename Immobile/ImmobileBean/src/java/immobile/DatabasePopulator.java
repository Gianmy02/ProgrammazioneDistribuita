package immobile;

import java.time.LocalDate;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
    
@Startup
@Singleton
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/EsameDS",
        user = "app",
        password = "app",
        databaseName = "EsameDB",
        properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator{
  @Inject
  public ImmobileEJB ejb;
  public Immobile i1, i2, i3, i4;

  @PostConstruct
  public void populateDB(){
    i1 = new Immobile(1, "Via Garibaldi, Salerno", 600000, LocalDate.of(2024,03,01), LocalDate.now(), "in vendita");  
    i2 = new Immobile(2, "Via Posidonia, Salerno", 400000, LocalDate.of(2024, 11, 01), LocalDate.now(), "in vendita");
    i3 = new Immobile(3, "Via dei Greci, Salerno", 200000, LocalDate.of(2023, 11, 01), LocalDate.now(), "venduta");
    i4 = new Immobile(4, "Via Porto, Salerno", 300000, LocalDate.of(2023, 11, 01), LocalDate.now(), "in trattativa");
    
    ejb.aggiungiImmobile(i1);
    ejb.aggiungiImmobile(i2);
    ejb.aggiungiImmobile(i3);
    ejb.aggiungiImmobile(i4);
  }

  @PreDestroy
  public void clearDB(){
    ejb.eliminaImmobile(i1);
    ejb.eliminaImmobile(i2);
    ejb.eliminaImmobile(i3);
    ejb.eliminaImmobile(i4);
  }
}

