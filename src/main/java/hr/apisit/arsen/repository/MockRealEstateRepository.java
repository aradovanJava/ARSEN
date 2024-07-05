package hr.apisit.arsen.repository;

import hr.apisit.arsen.model.Address;
import hr.apisit.arsen.model.Apartment;
import hr.apisit.arsen.model.House;
import hr.apisit.arsen.model.Owner;
import hr.apisit.arsen.model.RealEstate;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class MockRealEstateRepository implements  RealEstateRepository {

  private static final List<RealEstate> myRealEstates = new LinkedList<>();

  static {

    List<Address> addressList = RepositoryGenerator.getAddressRepository().findAll();
    List<Owner> ownerList = RepositoryGenerator.getOwnerRepository().findAll();

    House myFirstHouse = new House(
        addressList.get(3),
        new BigDecimal(200),
        new BigDecimal(120000),
        4,
        2,
        new BigDecimal(500),
        2,
        ownerList
    );

    House mySecondHouse = new House(
        addressList.getFirst(),
        new BigDecimal(300),
        new BigDecimal(220000),
        6,
        1,
        new BigDecimal(1500),
        3,
        ownerList
    );

    Apartment myFirstApartment = new Apartment(
        addressList.get(1),
        new BigDecimal(60),
        new BigDecimal(100000),
        2,
        0,
        5,
        ownerList
    );

    Apartment mySecondApartment = new Apartment(
        addressList.get(2),
        new BigDecimal(70),
        new BigDecimal(140000),
        3,
        1,
        15,
        ownerList
    );


    myRealEstates.add(myFirstHouse);
    myRealEstates.add(mySecondHouse);
    myRealEstates.add(myFirstApartment);
    myRealEstates.add(mySecondApartment);
  }

  MockRealEstateRepository() {}

  @Override
  public List<RealEstate> findAll() {
    return myRealEstates;
  }

  @Override
  public Optional<RealEstate> findTheMostExpensiveRealEstate() {
    return myRealEstates.stream()
        .max((re1, re2) -> re1.getPrice().compareTo(re2.getPrice()));
  }
}
