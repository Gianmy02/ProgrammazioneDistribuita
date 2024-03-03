/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiori;

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
    private FioreEJB ejb;
    private Fiore f1, f2, f3;
    
    @PostConstruct
    public void populateDB(){
        f1 = new Fiore(1, "Petunia", "Solanacae", "Annuale", "South America", "Antiossidante", "Rosa", "Acari", "Dolci", 12);
        f2 = new Fiore(2, "Calendula", "Asteracae", "Perenne", "South Europe", "Antinfiammatorie", "Arancio", "Oidio", "Infusi", 34);
        f3 = new Fiore(3, "Viola del pensiero", "Violaceae", "Annuale", "Europe", "Antinfiammatorie", "Viola", "Afidi neri", "Insalate", 15);
        ejb.aggiungiFiore(f1);
        ejb.aggiungiFiore(f2);
        ejb.aggiungiFiore(f3);
    }
    
    @PreDestroy
    public void clearDB(){
        ejb.eliminaFiore(f1);
        ejb.eliminaFiore(f2);
        ejb.eliminaFiore(f3);
    }
}
