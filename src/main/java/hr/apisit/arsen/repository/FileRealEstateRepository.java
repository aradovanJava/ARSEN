package hr.apisit.arsen.repository;

import hr.apisit.arsen.model.RealEstate;
import java.util.List;
import java.util.Optional;

public class FileRealEstateRepository implements RealEstateRepository {

  private static final String FILE_PATH = "dat/realestates.txt";

  @Override
  public List<RealEstate> findAll() {
    return List.of();
  }

  @Override
  public Optional<RealEstate> findTheMostExpensiveRealEstate() {
    return Optional.empty();
  }
}
