/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizzazione;

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
    private OrganizzazioneEJB ejb;
    private Organizzazione o1, o2, o3, o4;
    
    @PostConstruct
    public void populateDB(){
        o1 = new Organizzazione(1, "Save the Children Italia", "Roma", 291, 53, 408830, 113169865F, 50);
        o2 = new Organizzazione(2, "Medici senza Frontiere", "Roma", 50, 48, 286004, 61403682F, 50);
        o3 = new Organizzazione(3, "ActionAid", "Milano", 220, 33, 131920, 68097472F, 100);
        o4 = new Organizzazione(4, "Emergency", "Milano", 50, 7, 66311, 41842957F, 100);
    
        ejb.aggiungiOrganizzazione(o1);
        ejb.aggiungiOrganizzazione(o2);
        ejb.aggiungiOrganizzazione(o3);
        ejb.aggiungiOrganizzazione(o4);
    }

    @PreDestroy
    public void clearDB(){
        ejb.eliminaOrganizzazione(o1);
        ejb.eliminaOrganizzazione(o2);
        ejb.eliminaOrganizzazione(o3);
        ejb.eliminaOrganizzazione(o4);
    }
}

