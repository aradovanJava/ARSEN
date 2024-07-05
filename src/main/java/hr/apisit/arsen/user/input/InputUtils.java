package hr.apisit.arsen.user.input;

import hr.apisit.arsen.model.Address;
import java.util.List;
import java.util.Scanner;

public class InputUtils {

  public static Address chooseAddress(int i, List<Address> addressList, Scanner input) {
    Integer cottageOrdinalNumber;
    while(true) {
      System.out.println("Odaberite adresu " + (i + 1) + ". vikendice: ");

      for (int j = 0; j < addressList.size(); j++) {
        System.out.println((j + 1) + ") " + addressList.get(j).getStreet()
            + " " + addressList.get(j).getCity());
      }

      System.out.print("Odabir >> ");
      cottageOrdinalNumber = input.nextInt();

      if (cottageOrdinalNumber < 1 || cottageOrdinalNumber > addressList.size()) {
        System.out.println("Neispravan unos, moguće je upisati samo vrijednosti između "
            + "1 i " + addressList.size());
      }
      else {
        break;
      }
    }

    Address cottageAddress = addressList.get(cottageOrdinalNumber - 1);
    return cottageAddress;
  }
}
