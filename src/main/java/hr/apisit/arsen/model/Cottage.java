package hr.apisit.arsen.model;

import java.math.BigDecimal;
import java.util.List;

public class Cottage extends House {

  private List<EntertainmentOption> entertainmentOptions;

  public Cottage(Address address, BigDecimal area, BigDecimal price,
      Integer numberOfRooms, Integer numberOfBalconies, BigDecimal yardArea,
      Integer numberOfFloors, List<Owner> ownerList,
      List<EntertainmentOption> entertainmentOptions)
  {
    super(address, area, price, numberOfRooms, numberOfBalconies, yardArea, numberOfFloors,
        ownerList);
    this.entertainmentOptions = entertainmentOptions;
  }

  public List<EntertainmentOption> getEntertainmentOptions() {
    return entertainmentOptions;
  }

  public void setEntertainmentOptions(
      List<EntertainmentOption> entertainmentOptions) {
    this.entertainmentOptions = entertainmentOptions;
  }
}
