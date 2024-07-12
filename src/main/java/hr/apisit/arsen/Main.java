package hr.apisit.arsen;

import hr.apisit.arsen.design.pattern.AbstractRealEstateFactory;
import hr.apisit.arsen.design.pattern.RealEstateProvider;
import hr.apisit.arsen.enumeration.City;
import hr.apisit.arsen.enumeration.RealEstateType;
import hr.apisit.arsen.model.Address;
import hr.apisit.arsen.model.Apartment;
import hr.apisit.arsen.model.Owner;
import hr.apisit.arsen.model.RealEstate;
import hr.apisit.arsen.repository.RepositoryGenerator;
import hr.apisit.arsen.thread.TheMostExpensiveRealEstateThread;
import hr.apisit.arsen.user.input.InputUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

  private static final Logger log = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {

    log.info("Pokrenula se aplikacija!");

    AbstractRealEstateFactory abstractRealEstateFactory =
        RealEstateProvider.getRealEstateFactory(RealEstateType.APARTMENT);

    List<RealEstate> realEstates = new ArrayList<>();

    for (int i = 0; i < 100; i++) {

      RealEstate realEstate = abstractRealEstateFactory.createRealEstate();

      if (realEstate instanceof Apartment apartment) {
        System.out.println(apartment);
      }

      realEstates.add(realEstate);
    }

    List<Address> addressList = RepositoryGenerator.getAddressRepository().findAll();

    Address newAddress =
        new Address("Ilica",
            City.ZAGREB,
            1);

    RepositoryGenerator.getAddressRepository().save(newAddress);

    List<Address> updatedAddressList = RepositoryGenerator.getAddressRepository().findAll();

    Thread thread = new Thread(new TheMostExpensiveRealEstateThread());
    thread.start();

    List<Owner> ownerList =
        RepositoryGenerator.getOwnerRepository().findAll();

        /*
        List<Address> addressList =
            RepositoryGenerator.getAddressRepository().findAll();

         */

    List<RealEstate> myRealEstates =
        RepositoryGenerator.getRealEstateRepository().findAll();

    RealEstate theMostExpensiveRealEstate = myRealEstates.stream()
        .max((re1, re2) -> re1.getPrice().compareTo(re2.getPrice()))
        .get();

    log.info("The most expensive real estate is " + theMostExpensiveRealEstate);

    Optional<RealEstate> theCheapestRealEstateOptional = myRealEstates.stream()
        .min((re1, re2) -> re1.getPrice().compareTo(re2.getPrice()));

    if (theCheapestRealEstateOptional.isPresent()) {
      RealEstate theCheapestRealEstate = theCheapestRealEstateOptional.get();
      System.out.println("The cheapest real estate is " + theCheapestRealEstate);
    }

    myRealEstates.stream()
        .map(rs -> rs.getAddress().getStreet())
        .sorted()
        .forEach(System.out::println);

    // unos nove vikendice

    Scanner input = new Scanner(System.in);

    System.out.print("Unesite broj vikendica koje želite unijeti: ");
    Integer cottageCount = input.nextInt();

    for (int i = 0; i < cottageCount; i++) {
      Address cottageAddress = InputUtils.chooseAddress(i, addressList, input);
      System.out.println("Odabrana je: " + cottageAddress);
    }


  }
}