package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import com.goldenconsultingci.erp.common.AssertionConcern;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class GeographicalAddress extends AssertionConcern implements Serializable {

    private static final long serialVersionUID = 1L;
    private String street;
    private String city;
    private String country;

    private GeographicalAddress() {
        super();
    }
    public GeographicalAddress(String aStreet, String aCity, String aCountry) {
        this();
        this.setStreet(aStreet);
        this.setCity(aCity);
        this.setCountry(aCountry);
    }

    public GeographicalAddress(@NotNull GeographicalAddress aGeographicalAddress) {
        this(
                aGeographicalAddress.street(),
                aGeographicalAddress.city(),
                aGeographicalAddress.country());
    }

    private void setStreet(String aStreet) {
        this.assertArgumentNotEmpty(aStreet, "La rue est réquis.");
        this.assertArgumentLength(aStreet, 1, 50, "La rue doit comporter 50 caratère ou moins.");
        this.street = aStreet;
    }

    private void setCity(String aCity) {
        this.assertArgumentNotEmpty(aCity, "La ville est réquis.");
        this.assertArgumentLength(aCity, 1, 50, "La ville doit comporter 50 caratère ou moins.");
        this.city = aCity;
    }

    private void setCountry(String aCountry) {
        this.assertArgumentNotEmpty(aCountry, "Le pays est réquis.");
        this.assertArgumentLength(aCountry, 1, 50, "Le pays doit comporter 50 caratère ou moins.");
        this.country = aCountry;
    }

    public String street() {
        return street;
    }

    public String city() {
        return city;
    }

    public String country() {
        return country;
    }
}
