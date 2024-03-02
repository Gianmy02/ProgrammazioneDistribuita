/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchi;

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
    private PartitaEJB ejb;
    Partita p1, p2, p3, p4;
    
    @PostConstruct
    public void populateDB(){
        p1 = new Partita(1, "Classic", "Pap", "Furman", 2431, 2114, "e4 c5 Nf3 Nc6 N16 e5 Nd5 Bc4 Nb6 Bb3 d5", "G1", true);
        p2 = new Partita(2, "Rapid", "Caruana", "Nepomniachtchi", 2770, 2798, "e4 c5 Nf3 Nf6 Nc3 Nc6 Bb5 Nd4 Nxd4 exd4 e5 dxc5", "Patta", true);
        p3 = new Partita(3, "Classic", "Carlsen", "Maghsoodioo", 2892, 2655, "e4 e6 d4 d5 e5 c5 c3 Qb6 Nf3", "In corso", false);
        p4 = new Partita(4, "Blitz", "Nepomniachtchi", "Nakamura", 2798, 2836, "e4 e5 Nf3 Nc6 Bb5 Nf6 0-0 Nxe4 Re1 Nd6 Nxe5 Be7 Bf1 Nf5 Nf3 d5 d4 0-0 Nc3 Bb4 h3 Nd6 a3 Bxc3 bxc3 Re8 Rxe8+", "Patta", true);
        
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
