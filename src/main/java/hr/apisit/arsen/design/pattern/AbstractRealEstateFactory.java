package hr.apisit.arsen.design.pattern;

import hr.apisit.arsen.enumeration.RealEstateType;
import hr.apisit.arsen.model.RealEstate;

public abstract class AbstractRealEstateFactory {
  public abstract RealEstate createRealEstate();
}
