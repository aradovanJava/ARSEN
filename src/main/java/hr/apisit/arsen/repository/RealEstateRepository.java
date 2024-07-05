package hr.apisit.arsen.repository;

import hr.apisit.arsen.model.RealEstate;
import java.util.List;
import java.util.Optional;

public interface RealEstateRepository {
  List<RealEstate> findAll();
  Optional<RealEstate> findTheMostExpensiveRealEstate();
}
