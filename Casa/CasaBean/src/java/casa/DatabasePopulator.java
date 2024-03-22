/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casa;

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
    private CasaEJB ejb;
    private Casa c1, c2, c3, c4;
    
    @PostConstruct
    public void populateDB(){
        c1 = new Casa(1, "Bilocale", "Piazza Portanova", "84121", 1000F, "Libero");
        c2 = new Casa(2, "Trilocale", "Via Posidonia", "84129", 800F, "Libero");
        c3 = new Casa(3, "Bilocale", "Lungomare Marconi", "84128", 1000F, "Locato");
        c4 = new Casa(4, "Monolocale", "Via Guercio", "84134", 600F, "Locato");
        
        ejb.aggiungiCasa(c1);
        ejb.aggiungiCasa(c2);
        ejb.aggiungiCasa(c3);
        ejb.aggiungiCasa(c4);
    }
    
    @PreDestroy
    public void clearDB(){
        ejb.eliminaCasa(c1);
        ejb.eliminaCasa(c2);
        ejb.eliminaCasa(c3);
        ejb.eliminaCasa(c4);
    }
}
