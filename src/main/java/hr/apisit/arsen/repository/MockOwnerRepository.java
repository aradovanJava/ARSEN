package hr.apisit.arsen.repository;

import hr.apisit.arsen.model.Owner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MockOwnerRepository implements OwnerRepository {

  private static final List<Owner> owners = new ArrayList<>();

  static {
    owners.add(
        new Owner(
            "12345678903",
            "Ivo",
            "Ivić",
            LocalDate.now().minusYears(45),
            new HashSet<>()));

    owners.add(
        new Owner(
            "12345678911",
            "Martina",
            "Horvat",
            LocalDate.now().minusYears(27),
            new HashSet<>()));
  }

  MockOwnerRepository() {}

  @Override
  public List<Owner> findAll() {
    return owners;
  }
}
