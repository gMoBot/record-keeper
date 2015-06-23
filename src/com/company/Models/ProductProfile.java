package com.company.Models;

import javax.persistence.*;

/**
 * Created by garrettcoggon on 6/22/15.
 */

@Entity
@Table(name = "product_profile")
public class ProductProfile {

    @Column(name= "product_name")
    private String productName;
    @Id
    @Column(name = "epa_number", unique = true, nullable = false)
    private String epaNumber;
    @Column(name = "rei_hrs")
    private String reiHrs;
    @Column(name = "phi_days")
    private String phiDays;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getEpaNumber() {
        return epaNumber;
    }

    public void setEpaNumber(String epaNumber) {
        this.epaNumber = epaNumber;
    }

    public String getReiHrs() {
        return reiHrs;
    }

    public void setReiHrs(String reiHrs) {
        this.reiHrs = reiHrs;
    }

    public String getPhiDays() {
        return phiDays;
    }

    public void setPhiDays(String phiDays) {
        this.phiDays = phiDays;
    }

}