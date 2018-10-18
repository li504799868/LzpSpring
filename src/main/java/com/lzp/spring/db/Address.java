package com.lzp.spring.db;

public class Address {

    private String addressId;

    private String location;

    public Address() {
    }

    public Address(String addressId, String location) {
        super();
        this.addressId = addressId;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
}
