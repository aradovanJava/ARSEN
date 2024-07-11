package hr.apisit.arsen.repository;

import hr.apisit.arsen.model.Address;
import java.util.List;
import java.util.Optional;

public interface AddressRepository {
  List<Address> findAll();
  List<Address> filterByCity(String city);
  List<Address> filterByStreet(String street);
  Address save(Address address);
  Optional<Address> findByHighestHouseNumber();
}
