package hr.apisit.arsen;

import hr.apisit.arsen.enumeration.City;
import hr.apisit.arsen.model.Address;
import hr.apisit.arsen.thread.SaveNewAddressThread;
import hr.apisit.arsen.thread.TheMostExpensiveRealEstateThread;

public class ThreadSyncTest {

  public static void main(String[] args) {
    Thread thread = new Thread(new TheMostExpensiveRealEstateThread());
    thread.start();

    Address newAddress =
        new Address("Ilica",
            City.ZAGREB,
            1000);

    Thread saveNewAddressThread = new Thread(new SaveNewAddressThread(newAddress));
    saveNewAddressThread.start();
  }

}
