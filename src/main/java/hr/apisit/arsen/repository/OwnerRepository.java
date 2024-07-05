package hr.apisit.arsen.repository;

import hr.apisit.arsen.model.Owner;
import java.util.List;

public interface OwnerRepository {
  List<Owner> findAll();
}
