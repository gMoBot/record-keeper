package com.company.Models;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * Created by garrettcoggon on 6/9/15.
 */

@Entity
@Table(name="farm_profile")
public class FarmProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull
    @Column(name= "farm_id", unique = true, nullable = false)
    private int id;

    @Column(name="farm_name")
    private String farmName;
    @Column(name="owner_name")
    private String ownerName;
    @Column(name="street_address")
    private String streetAddress;
    @Column(name="state_code")
    private String stateCode;
    @Column(name="zipcode")
    private String zipcode;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getFarmName(){
        return farmName;
    }
    public void setFarmName(String farmName){
        this.farmName = farmName;
    }

    public String getOwnerName(){
        return ownerName;
    }
    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }

    public String getStreetAddress(){
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress){
        this.streetAddress = streetAddress;
    }

    public String getStateCode(){
        return stateCode;
    }
    public void setStateCode(String stateCode){
        this.stateCode = stateCode;
    }

    public String getZipcode(){
        return zipcode;
    }
    public void setZipcode(String zipcode){
        this.zipcode = zipcode;
    }
}
