/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpcm;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
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
    DecretoEJB ejb;
    Decreto d1, d2, d3;

    
    @PostConstruct
    public void populateDB(){
        d1 = new Decreto(1, "Decreto CoronaVirus", "Covid", "Sanitaria", 1, 12);
        d2 = new Decreto(2, "E' arrivata la fine del mondo", "Diluvio", "Fine del mondo", 1, 1);
        d3 = new Decreto(3, "La peste nera è qui", "Peste", "Sanitaria", 2, 8);
    
        ejb.aggiungiDecreto(d1);
        ejb.aggiungiDecreto(d2);
        ejb.aggiungiDecreto(d3);
    }
    
    @PreDestroy
    public void clearDB(){
        ejb.eliminaDecreto(d1);
        ejb.eliminaDecreto(d2);
        ejb.eliminaDecreto(d3);
    }
}
