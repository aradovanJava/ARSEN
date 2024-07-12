package hr.apisit.arsen.design.pattern;

import hr.apisit.arsen.enumeration.RealEstateType;
import hr.apisit.arsen.model.Apartment;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RealEstateProvider {

  public static AbstractRealEstateFactory getRealEstateFactory(RealEstateType realEstateType) {
    return switch (realEstateType) {
      case RealEstateType.APARTMENT -> new ApartmentFactory();
      case RealEstateType.HOUSE -> new ApartmentFactory();
      case RealEstateType.COTTAGE -> new ApartmentFactory();
      default -> throw new IllegalArgumentException("Invalid RealEstateType: " + realEstateType);
    };
  }

}
