/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multa;

import java.time.LocalDate;
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
    public MultaEJB ejb;
    public Multa m1, m2, m3, m4;
    
    @PostConstruct
    public void populateDB(){
        m1 = new Multa(1, "Numa Pompilio", "divieto di sosta", 50, LocalDate.of(2024, 11, 01), LocalDate.now(), "non pagata");
        m2 = new Multa(2, "Tullio Ostilio", "eccesso di velocita", 140, LocalDate.of(2024, 11, 1), LocalDate.now(), "non pagata");
        m3 = new Multa(3, "Anco Marzio", "divieto di sosta", 60, LocalDate.of(2023, 11, 01), LocalDate.of(2023, 01, 01), "pagata");
        m4 = new Multa(4, "Tarquinio Prisco", "semaforo rosso", 200, LocalDate.of(2022, 11, 01), LocalDate.of(2022, 01, 01), "annullata");
        
        ejb.aggiungiMulta(m1);
        ejb.aggiungiMulta(m2);
        ejb.aggiungiMulta(m3);
        ejb.aggiungiMulta(m4);
    }
    
    @PreDestroy
    public void clearDB(){
        ejb.eliminaMulta(m1);
        ejb.eliminaMulta(m2);
        ejb.eliminaMulta(m3);
        ejb.eliminaMulta(m4);
    }
}
