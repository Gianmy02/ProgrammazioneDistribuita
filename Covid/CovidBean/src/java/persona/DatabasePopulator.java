/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

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
    private PersonaEJB ejb;
    private Persona p1, p2, p3;
    
    @PostConstruct
    public void populateDB(){
        p1 = new Persona(1, "Rossi", "Luigi", "Pensionato", 65, "Maschio", 2, true, "no", "media");
        p2 = new Persona(2, "Bianchi", "Maria", "Docente", 45, "Femmina", 0, false, "no", "bassa");
        p3 = new Persona(3, "Verdi", "Giovanni", "Pensionato", 67, "Maschio", 1, false, "si", "alta");
        
        ejb.aggiungiPersona(p1);
        ejb.aggiungiPersona(p2);
        ejb.aggiungiPersona(p3);
    }
    
    @PreDestroy
    public void clearDB(){
        ejb.eliminaPersona(p1);
        ejb.eliminaPersona(p2);
        ejb.eliminaPersona(p3);
    }
}
