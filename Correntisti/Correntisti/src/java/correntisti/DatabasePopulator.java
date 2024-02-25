/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correntisti;

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
    CorrentistaEJB ejb;
    Correntista c1, c2, c3;
    
    @PostConstruct
    public void populateDB(){
        c1 = new Correntista(1, "Renzi", "Matteo", "Politico", "SI", 5000, 3, 7000, 10, 900000, 3000);
        c2 = new Correntista(2, "Briatore", "Flavio", "Imprenditore", "NO", 10, 200, 500, 1000, 5000, 100000);
        c3 = new Correntista(3, "Bergoglio", "Francesco", "Papa", "NO", 10, 10, 10, 10, 500, 500);
        
        ejb.aggiungiCorrentista(c1);
        ejb.aggiungiCorrentista(c2);
        ejb.aggiungiCorrentista(c3);
    }
    
    @PreDestroy
    public void clearDB(){
        ejb.eliminaCorrentista(c1);
        ejb.eliminaCorrentista(c2);
        ejb.eliminaCorrentista(c3);
    }
}
