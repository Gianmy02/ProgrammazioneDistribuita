/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import javax.enterprise.event.Observes;


public class PensionatoUpdate {
    public void notify(@Observes @QualifierPensionato Persona p){
        System.out.println(p.getId()+" Ecco un altro individuo che ha la precedenza dul piano vaccinale");
    }
}
