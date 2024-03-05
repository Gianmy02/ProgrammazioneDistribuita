/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cani;

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
    private CaneEJB ejb;
    private Cane c1, c2, c3, c4;
    
    @PostConstruct
    public void populateDB(){
        c1 = new Cane(1, "Meticcio", "Leo", "Piccola", "0-2", "M", "941000001156168", true);
        c2 = new Cane(2, "Meticcio", "Luna", "Piccola", "8+", "F", "380260041762325", true);
        c3 = new Cane(3, "Boston terrier", "Eros", "Media", "8+", "M", "941000001156168", false);
        c4 = new Cane(4, "Pastore tedesco", "Pan", "Grande", "3-7", "F", "981100000297746", true);
        
        ejb.aggiungiCane(c1);
        ejb.aggiungiCane(c2);
        ejb.aggiungiCane(c3);
        ejb.aggiungiCane(c4);
    }
    
    @PreDestroy
    public void clearDB(){
        ejb.eliminaCane(c1);
        ejb.eliminaCane(c2);
        ejb.eliminaCane(c3);
        ejb.eliminaCane(c4);
    }
}
