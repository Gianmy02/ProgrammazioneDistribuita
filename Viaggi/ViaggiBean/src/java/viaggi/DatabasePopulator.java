package viaggi;

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
public class DatabasePopulator {

    @Inject
    public ViaggioEJB ejb;
    public Viaggio v1, v2, v3;
    
    @PostConstruct
    public void populateDB(){
        v1 = new Viaggio(1, "Mare", "Seychelles", 500, 10, 10);
        v2 = new Viaggio(2, "Mare", "Corfù", 200, 0, 20);
        v3 = new Viaggio(3, "Montagna", "Cortina", 700, 20, 30);
        
        ejb.aggiungiViaggio(v1);
        ejb.aggiungiViaggio(v2);
        ejb.aggiungiViaggio(v3);
    }
    
    @PreDestroy
    public void clearDB(){
        ejb.eliminaViaggio(v1);
        ejb.eliminaViaggio(v2);
        ejb.eliminaViaggio(v3);
    }
}
