package hr.apisit.arsen.repository;

import java.util.Optional;

public class RepositoryGenerator {

  private static AddressRepository addressRepository;
  private static OwnerRepository ownerRepository;
  private static RealEstateRepository realEstateRepository;

  public static AddressRepository getAddressRepository() {
    if(Optional.ofNullable(addressRepository).isEmpty()) {
      addressRepository = new FileAddressRepository();
    }
    return addressRepository;
  }

  public static OwnerRepository getOwnerRepository() {
    if(Optional.ofNullable(ownerRepository).isEmpty()) {
      ownerRepository = new MockOwnerRepository();
    }
    return ownerRepository;
  }

  public static RealEstateRepository getRealEstateRepository() {
    if(Optional.ofNullable(realEstateRepository).isEmpty()) {
      realEstateRepository = new MockRealEstateRepository();
    }
    return realEstateRepository;
  }

}
