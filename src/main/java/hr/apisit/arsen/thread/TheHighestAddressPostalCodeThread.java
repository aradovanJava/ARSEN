package hr.apisit.arsen.thread;

import hr.apisit.arsen.model.Address;
import hr.apisit.arsen.model.RealEstate;
import hr.apisit.arsen.repository.RepositoryGenerator;
import java.util.Optional;

public class TheHighestAddressPostalCodeThread extends AddressThreadAbstract implements Runnable {

  @Override
  public void run() {
    while(true) {
      fetchAddressWithTheHighestHouseNumber();
    }
  }
}
