package hr.apisit.arsen.model;

import java.math.BigDecimal;
import java.util.List;

public abstract non-sealed class RealEstate implements Transferable {

    private Address address;
    private BigDecimal area;
    private BigDecimal price;
    private Integer numberOfRooms;
    private Integer numberOfBalconies;
    private List<Owner> ownerList;

    protected RealEstate(Address address, BigDecimal area, BigDecimal price,
                         Integer numberOfRooms, Integer numberOfBalconies,
                         List<Owner> ownerList)
    {
        this.address = address;
        this.area = area;
        this.price = price;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBalconies = numberOfBalconies;
        this.ownerList = ownerList;
    }



    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getNumberOfBalconies() {
        return numberOfBalconies;
    }

    public void setNumberOfBalconies(Integer numberOfBalconies) {
        this.numberOfBalconies = numberOfBalconies;
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    public void transferOwnership(List<Owner> newOwnersList) {
        this.ownerList.clear();
        this.ownerList.addAll(newOwnersList);
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "address=" + address +
                ", area=" + area +
                ", price=" + price +
                ", numberOfRooms=" + numberOfRooms +
                ", numberOfBalconies=" + numberOfBalconies +
                '}';
    }
}
