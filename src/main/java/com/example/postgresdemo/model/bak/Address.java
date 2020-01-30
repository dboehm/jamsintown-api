package com.example.postgresdemo.model.bak;

import javax.persistence.*;

//@Entity
public class Address {
    private Integer addressId;
    private String name;
    private String street;
    private String zipcode;
    private String town;
    private String country;
    private String countrycode;
    private Double googleLatitude;
    private Double googleLongitude;
    private Integer jamlocationIdJamlocation;
    private Jamlocation jamlocationByJamlocationIdJamlocation;

    @Id
    @Column(name = "address_id", nullable = false)
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "street", nullable = true, length = -1)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "zipcode", nullable = true, length = -1)
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "town", nullable = true, length = -1)
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Basic
    @Column(name = "country", nullable = true, length = -1)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "countrycode", nullable = true, length = -1)
    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    @Basic
    @Column(name = "google_latitude", nullable = true, precision = 0)
    public Double getGoogleLatitude() {
        return googleLatitude;
    }

    public void setGoogleLatitude(Double googleLatitude) {
        this.googleLatitude = googleLatitude;
    }

    @Basic
    @Column(name = "google_longitude", nullable = true, precision = 0)
    public Double getGoogleLongitude() {
        return googleLongitude;
    }

    public void setGoogleLongitude(Double googleLongitude) {
        this.googleLongitude = googleLongitude;
    }

    @Basic
    @Column(name = "jamlocation_id_jamlocation", nullable = true)
    public Integer getJamlocationIdJamlocation() {
        return jamlocationIdJamlocation;
    }

    public void setJamlocationIdJamlocation(Integer jamlocationIdJamlocation) {
        this.jamlocationIdJamlocation = jamlocationIdJamlocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (addressId != null ? !addressId.equals(address.addressId) : address.addressId != null) return false;
        if (name != null ? !name.equals(address.name) : address.name != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (zipcode != null ? !zipcode.equals(address.zipcode) : address.zipcode != null) return false;
        if (town != null ? !town.equals(address.town) : address.town != null) return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (countrycode != null ? !countrycode.equals(address.countrycode) : address.countrycode != null) return false;
        if (googleLatitude != null ? !googleLatitude.equals(address.googleLatitude) : address.googleLatitude != null)
            return false;
        if (googleLongitude != null ? !googleLongitude.equals(address.googleLongitude) : address.googleLongitude != null)
            return false;
        if (jamlocationIdJamlocation != null ? !jamlocationIdJamlocation.equals(address.jamlocationIdJamlocation) : address.jamlocationIdJamlocation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressId != null ? addressId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (town != null ? town.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (countrycode != null ? countrycode.hashCode() : 0);
        result = 31 * result + (googleLatitude != null ? googleLatitude.hashCode() : 0);
        result = 31 * result + (googleLongitude != null ? googleLongitude.hashCode() : 0);
        result = 31 * result + (jamlocationIdJamlocation != null ? jamlocationIdJamlocation.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "jamlocation_id_jamlocation", referencedColumnName = "jamlocation_id")
    public Jamlocation getJamlocationByJamlocationIdJamlocation() {
        return jamlocationByJamlocationIdJamlocation;
    }

    public void setJamlocationByJamlocationIdJamlocation(Jamlocation jamlocationByJamlocationIdJamlocation) {
        this.jamlocationByJamlocationIdJamlocation = jamlocationByJamlocationIdJamlocation;
    }
}
