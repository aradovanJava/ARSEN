package hr.apisit.arsen.model;

import hr.apisit.arsen.enumeration.City;

public class Address {

    private String street;
    private City city;
    private Integer houseNumber;
    private String houseNumberAddOn;

    public Address(String street, City city, Integer houseNumber, String houseNumberAddOn) {
        this.street = street;
        this.city = city;
        this.houseNumber = houseNumber;
        this.houseNumberAddOn = houseNumberAddOn;
    }

    public Address(String street, City city, Integer houseNumber) {
        this.houseNumber = houseNumber;
        this.city = city;
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseNumberAddOn() {
        return houseNumberAddOn;
    }

    public void setHouseNumberAddOn(String houseNumberAddOn) {
        this.houseNumberAddOn = houseNumberAddOn;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", houseNumber=" + houseNumber +
                ", houseNumberAddOn='" + houseNumberAddOn + '\'' +
                '}';
    }
}
