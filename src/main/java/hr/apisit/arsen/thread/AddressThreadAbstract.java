package hr.apisit.arsen.thread;

import hr.apisit.arsen.model.Address;
import hr.apisit.arsen.repository.AddressRepository;
import hr.apisit.arsen.repository.RepositoryGenerator;
import java.util.Optional;

public abstract class AddressThreadAbstract {

  private volatile Boolean fileAccessInProgress = false;

  synchronized void saveNewAddressToFile(Address address) {
    while(fileAccessInProgress) {
      try {
        wait();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    fileAccessInProgress = true;

    AddressRepository addressRepository =
        RepositoryGenerator.getAddressRepository();

      Address savedAddress = addressRepository.save(address);

      try {
        Thread.sleep(5000);
        System.out.println(savedAddress);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      fileAccessInProgress = false;

      notifyAll();
  }

  synchronized void fetchAddressWithTheHighestHouseNumber() {
    while(fileAccessInProgress) {
      try {
        wait();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    fileAccessInProgress = true;

    Optional<Address> theAddressWithTheHighestHouseNumber
        = RepositoryGenerator.getAddressRepository().findByHighestHouseNumber();;

      try {
        Thread.sleep(5000);
        theAddressWithTheHighestHouseNumber.ifPresent(System.out::println);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

    fileAccessInProgress = false;

    notifyAll();
  }

}
