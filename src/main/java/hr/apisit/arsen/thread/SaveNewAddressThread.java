package hr.apisit.arsen.thread;

import hr.apisit.arsen.model.Address;
import hr.apisit.arsen.repository.AddressRepository;
import hr.apisit.arsen.repository.FileAddressRepository;
import hr.apisit.arsen.repository.RepositoryGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SaveNewAddressThread extends AddressThreadAbstract implements Runnable {

  private final Address address;

  @Override
  public void run() {
    while(true) {
      saveNewAddressToFile(address);
    }
  }
}
