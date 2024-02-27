/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birra;

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
    private NegozioEJB ejb;
    private Negozio n1, n2, n3;
    
    @PostConstruct
    public void populatorDB(){
        n1 = new Negozio(1, "BeviBene", "John Budweiser", 430015, 132210, "Napoli", "Napoli", "Campania");
        n2 = new Negozio(2, "BirraESaiCosaBevi", "Nanni Moretti", 640000, 212133, "Roma", "Roma", "Lazio");
        n3 = new Negozio(3, "BirreOggi", "Pasquale Poretti", 345941, 615231, "Cernusco", "Milano", "Lombardia");
        
        ejb.aggiungiNegozio(n1);
        ejb.aggiungiNegozio(n2);
        ejb.aggiungiNegozio(n3);
    }
    
    @PreDestroy
    public void clearDB(){
        ejb.eliminaNegozio(n1);
        ejb.eliminaNegozio(n2);
        ejb.eliminaNegozio(n3);
    }
}
