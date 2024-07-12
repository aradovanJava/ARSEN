package hr.apisit.arsen.design.pattern;

import hr.apisit.arsen.enumeration.City;
import hr.apisit.arsen.enumeration.RealEstateType;
import hr.apisit.arsen.enumeration.StreetEnum;
import hr.apisit.arsen.model.Address;
import hr.apisit.arsen.model.Apartment;
import hr.apisit.arsen.model.Owner;
import hr.apisit.arsen.model.RealEstate;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ApartmentFactory extends AbstractRealEstateFactory {

  @Override
  public RealEstate createRealEstate() {

    SecureRandom random = new SecureRandom();

    Address randomAddress = new Address(
        StreetEnum.values()[random.nextInt(StreetEnum.values().length)].getName(),
        City.values()[random.nextInt(City.values().length)],
        random.nextInt(50) + 1
    );

    Owner randomOwner = Owner.builder().oib("12345678903")
            .firstName("Ivo")
                .lastName("Ivić")
                    .dateOfBirth(
                        LocalDate.now().minusYears(45)
                            .minusDays(10))
        .build();

    List<Owner> ownerList = new ArrayList<>();
    ownerList.add(randomOwner);

    return new Apartment(
        randomAddress,
        new BigDecimal(random.nextInt(10000))
            .divide(new BigDecimal(100), RoundingMode.HALF_UP).add(new BigDecimal(50)),
        new BigDecimal(random.nextInt(10000000))
            .divide(new BigDecimal(100), RoundingMode.HALF_UP).add(new BigDecimal(50000)),
        random.nextInt(10) + 1,
        random.nextInt(3),
        random.nextInt(20),
        ownerList
        );
  }
}
