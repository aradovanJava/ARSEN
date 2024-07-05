package hr.apisit.arsen.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Customer extends Person {

    private BigDecimal budget;
    private List<RealEstate> favoriteRealEstates;

    public Customer(String oib, String firstName, String lastName, LocalDate dateOfBirth,
                    BigDecimal budget, List<RealEstate> favoriteRealEstates) {
        super(oib, firstName, lastName, dateOfBirth);
        this.budget = budget;
        this.favoriteRealEstates = favoriteRealEstates;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public List<RealEstate> getFavoriteRealEstates() {
        return favoriteRealEstates;
    }

    public void setFavoriteRealEstates(List<RealEstate> favoriteRealEstates) {
        this.favoriteRealEstates = favoriteRealEstates;
    }
}
