package hr.apisit.arsen.thread;

import hr.apisit.arsen.model.RealEstate;
import hr.apisit.arsen.repository.RepositoryGenerator;
import java.util.Optional;

public class TheMostExpensiveRealEstateThread implements Runnable {

  @Override
  public void run() {
    Optional<RealEstate> theMostExpensiveRealEstate
        = RepositoryGenerator.getRealEstateRepository().findTheMostExpensiveRealEstate();

    while(true) {
      try {
        Thread.sleep(5000);
        theMostExpensiveRealEstate.ifPresent(System.out::println);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
