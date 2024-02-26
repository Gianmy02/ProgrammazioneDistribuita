/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arresto;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author amministratore
 */
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
    public ArrestoEJB ejb;
    public Arresto a1, a2, a3;
    
    @PostConstruct
    public void populateDB(){
        a1 = new Arresto(1, "Angeli", "Jack", "FBI", "QAnon", "Renzi", 3, true, 12);
        a2 = new Arresto(2, "Hope", "Bob", "CIA", "Proud Boys", "Gates", 2, false, 4);
        a3 = new Arresto(3, "Mack", "John", "FBI", "Boogaloo", "Lunn", 4, false, 2);
        
        ejb.aggiungiArresto(a1);
        ejb.aggiungiArresto(a2);
        ejb.aggiungiArresto(a3);
    }
    
    @PreDestroy
    public void clearDB(){
        ejb.eliminaArresto(a1);
        ejb.eliminaArresto(a2);
        ejb.eliminaArresto(a3);
    }
}
