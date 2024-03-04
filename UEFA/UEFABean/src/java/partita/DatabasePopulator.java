/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partita;

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
    public PartitaEJB ejb;
    public Partita p1, p2, p3, p4;
    
    @PostConstruct
    public void populateDB(){
       p1 = new Partita(1, "Girone 1", "Turchia", "Italia", 0, 3, 0, 0, "SI");
       p2 = new Partita(2, "Girone 2", "Italia", "Svizzera", 3, 0, 1, 1, "SI");
       p3 = new Partita(3, "Ottavi", "Inghilterra", "Germania", 2, 0, 3, 1, "SI");
       p4 = new Partita(4, "Quarti", "Belgio", "Italia", 0, 0, 0, 0, "NO");
       
       ejb.aggiungiPartita(p1);
       ejb.aggiungiPartita(p2);
       ejb.aggiungiPartita(p3);
       ejb.aggiungiPartita(p4);
    } 
    
    @PreDestroy
    public void clearDB(){
        ejb.eliminaPartita(p1);
        ejb.eliminaPartita(p2);
        ejb.eliminaPartita(p3);
        ejb.eliminaPartita(p4);
    }
}
