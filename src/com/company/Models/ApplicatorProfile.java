package com.company.Models;

import javax.persistence.*;

/**
 * Created by garrettcoggon on 6/22/15.
 */

@Entity
@Table(name = "applicator_profile")
public class ApplicatorProfile {

    @Id
    @Column(name= "app_number", unique = true, nullable = false)
    private String appNumber;
    @Column(name="app_name")
    private String appName;
    @Column(name = "street_address")
    private String appStreetAddress;
    @Column(name = "state_code")
    private String stateCode;
    @Column(name = "zipcode")
    private String zipCode;

    public String getAppNumber() {
        return appNumber;
    }

    public void setAppNumber(String appNumber) {
        this.appNumber = appNumber;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppStreetAddress() {
        return appStreetAddress;
    }

    public void setAppStreetAddress(String appStreetAddress) {
        this.appStreetAddress = appStreetAddress;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
