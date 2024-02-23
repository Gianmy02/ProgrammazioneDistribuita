package canzoni;

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
    public CanzoneEJB canzoneEJB;
    public Canzone c1, c2, c3;
    
    @PostConstruct
    public void populateDB(){
        c1 = new Canzone(1, "Diodato", "Pop", "Sai che cosa penso, Che non dovrei pensare", false, 1000F);
        c2 = new Canzone(2, "Pelu", "Rock", "Spingi forte spingi forte salta fuori da quel buio", false, 13F);
        c3 = new Canzone(3, "Bugo e Morgan", "Pop","Le buone intenzioni, l'educazione", false, 5000F);

        canzoneEJB.aggiungiCanzone(c1);
        canzoneEJB.aggiungiCanzone(c2);
        canzoneEJB.aggiungiCanzone(c3);
    }
    
    @PreDestroy
    public void clearDB(){
       canzoneEJB.eliminaCanzone(c1);
       canzoneEJB.eliminaCanzone(c2);
       canzoneEJB.eliminaCanzone(c3);
    }
}

