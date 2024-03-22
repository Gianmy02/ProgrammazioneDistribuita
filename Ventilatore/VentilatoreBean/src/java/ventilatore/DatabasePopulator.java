package ventilatore;

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
        name = "jdbc/EsameDS",
        user = "app",
        password = "app",
        databaseName = "EsameDB",
        properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {

    @Inject
    private VentilatoreEJB ejb;
    private Ventilatore v1, v2, v3;
    
    @PostConstruct
    public void populateDB(){
        v1 = new Ventilatore(1, "SoffioFresco", "VentilatorePerTutti", 1500, 4, 10, "Italia");
        v2 = new Ventilatore(2, "Wind 3000", "Sturm", 2200, 6, 12, "Germania");
        v3 = new Ventilatore(3, "BrezzaLeggera", "Frescura", 1000, 5, 11, "Francia");
        
        ejb.aggiungiVentilatore(v1);
        ejb.aggiungiVentilatore(v2);
        ejb.aggiungiVentilatore(v3);
    }
    
    @PreDestroy
    public void clearDB(){
        ejb.eliminaVentilatore(v1);
        ejb.eliminaVentilatore(v2);
        ejb.eliminaVentilatore(v3);
    }
}
