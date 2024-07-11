package hr.apisit.arsen.model;

import hr.apisit.arsen.enumeration.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address extends Entity {

    private String street;
    private City city;
    private Integer houseNumber;
    private String houseNumberAddOn;

    public Address(Integer id, String street, City city, Integer houseNumber) {
        super(id);
        this.houseNumber = houseNumber;
        this.city = city;
        this.street = street;
    }

    public Address(String street, City city, Integer houseNumber) {
        this.houseNumber = houseNumber;
        this.city = city;
        this.street = street;
    }
}
