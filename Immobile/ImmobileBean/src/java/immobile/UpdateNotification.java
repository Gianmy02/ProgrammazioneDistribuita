package immobile;

import javax.enterprise.event.Observes;


public class UpdateNotification{
  public void notify(@Observes Immobile i){
    System.out.println("Immobile Venduto");
  }
}