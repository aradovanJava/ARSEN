package hr.apisit.arsen.repository;

import hr.apisit.arsen.model.Address;
import java.util.List;

public interface AddressRepository {
  List<Address> findAll();
  List<Address> filterByCity(String city);
  List<Address> filterByStreet(String street);
}
