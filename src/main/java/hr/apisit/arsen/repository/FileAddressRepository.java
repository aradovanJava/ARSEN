package hr.apisit.arsen.repository;

import hr.apisit.arsen.enumeration.City;
import hr.apisit.arsen.exception.FileException;
import hr.apisit.arsen.model.Address;
import hr.apisit.arsen.model.Entity;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileAddressRepository implements AddressRepository {

  private static final String FILE_PATH = "dat/address.txt";

  private static final Integer NUMBER_OF_LINES = 5;

  @Override
  public List<Address> findAll() throws FileException {

    final List<Address> addresses = new ArrayList<>();


    try {
      List<String> addressFileLines = Files.readAllLines(Path.of(FILE_PATH));

      if(addressFileLines.size() % NUMBER_OF_LINES != 0) {
        throw new FileException("The number of lines is not a multiple of " + NUMBER_OF_LINES);
      }

      for(int i = 0; i < addressFileLines.size()/NUMBER_OF_LINES; i += 1) {
        Integer id = Integer.parseInt(addressFileLines.get(i * NUMBER_OF_LINES));
        String street = addressFileLines.get((i * NUMBER_OF_LINES) + 1);
        City city = City.valueOf(addressFileLines.get((i * NUMBER_OF_LINES) + 2));
        Integer houseNumber = Integer.parseInt(addressFileLines.get((i * NUMBER_OF_LINES) + 3));
        String houseNumberAddOn = addressFileLines.get((i * NUMBER_OF_LINES) + 4);

        Address newAddress = new Address(id, street, city, houseNumber);

        if(!houseNumberAddOn.isBlank()) {
          newAddress.setHouseNumberAddOn(houseNumberAddOn);
        }

        addresses.add(newAddress);
      }

    } catch (IOException e) {
      String message = "There was a IO problem reading the file '" + FILE_PATH + "'";
      log.error(message, e);
      throw new FileException(message, e);
    }

    return addresses;
  }

  @Override
  public List<Address> filterByCity(String city) {
    return findAll().stream()
        .filter(a -> a.getCity().name().contains(city.toUpperCase()))
        .collect(Collectors.toList());
  }

  @Override
  public List<Address> filterByStreet(String street) {
    return findAll().stream()
        .filter(a -> a.getStreet().toUpperCase().contains(street.toUpperCase()))
        .collect(Collectors.toList());
  }

  @Override
  public Address save(Address address) {
    List<Address> addresses = findAll();

    Integer nextId = addresses.stream()
        .map(Entity::getId)
        .reduce(0, Integer::max);

    address.setId(nextId + 1);

    addresses.add(address);

    try(PrintWriter pw = new PrintWriter(FILE_PATH)) {

      for(Address tempAddress : addresses) {
        pw.println(tempAddress.getId());
        pw.println(tempAddress.getStreet());
        pw.println(tempAddress.getCity());
        pw.println(tempAddress.getHouseNumber());
        if(Optional.ofNullable(tempAddress.getHouseNumberAddOn()).isEmpty()) {
          pw.println("");
        }
        else {
          pw.println(tempAddress.getHouseNumberAddOn());
        }
      }
    }
    catch(FileNotFoundException e) {
      String message = "There was a IO problem writing to the file '" + FILE_PATH + "'";
      log.error(message, e);
      throw new FileException(message, e);
    }

    return address;
  }

  @Override
  public Optional<Address> findByHighestHouseNumber() {
    return findAll().stream()
        .max((a1, a2) -> a1.getHouseNumber().compareTo(a2.getHouseNumber()));

  }
}
