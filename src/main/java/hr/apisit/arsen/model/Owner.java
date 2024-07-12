package hr.apisit.arsen.model;

import java.time.LocalDate;
import java.util.Set;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Owner extends Person {

    private Set<RealEstate> realEstates;

    public Owner(String oib, String firstName, String lastName,
                 LocalDate dateOfBirth,
                 Set<RealEstate> realEstateList)
    {
        super(oib, firstName, lastName, dateOfBirth);
        this.realEstates = realEstateList;
    }

    public Set<RealEstate> getRealEstates() {
        return realEstates;
    }

    public void setRealEstateList(Set<RealEstate> realEstates) {
        this.realEstates = realEstates;
    }
}
