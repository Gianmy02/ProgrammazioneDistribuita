package ricambi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup

@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/EsameDS",
        user = "app",
        password = "app",
        databaseName = "EsameDB",
        properties = {"connectionAttributes=;create=true"}
)

public class DatabasePopulator {
    @Inject
    private RicambioEJB ricambioEJB;
    private Ricambio ricambio1, r2, r3;
    
    @PostConstruct
    public void populateDB(){
       ricambio1 = new Ricambio(1, "Sensore Temperatura", "Motore", 18.22F, 100, 1000);
       r2 = new Ricambio(2, "FAP", "Filtri", 188.47F, 9, 1);
       r3 = new Ricambio(3, "Dischi Freni", "Freni", 18.15F, 2000, 5000);
   
       ricambioEJB.aggiungiRicambio(ricambio1);
       ricambioEJB.aggiungiRicambio(r2);
       ricambioEJB.aggiungiRicambio(r3);
    }
    
    @PreDestroy
    public void clearDB(){
        ricambioEJB.eliminaRicambio(ricambio1);
        ricambioEJB.eliminaRicambio(r2);
        ricambioEJB.eliminaRicambio(r3);
    }
    
}
