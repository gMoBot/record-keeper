package com.company.Models;

import javax.persistence.*;

/**
 * Created by garrettcoggon on 6/22/15.
 */

@Entity
@Table(name = "block_profile")
public class BlockProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "block_id", unique = true, nullable = false)
    private int id;
    @Column(name="farm_id")
    private String farmId;
    @Column(name="block_name")
    private String blockName;
    @Column(name="block_street_address")
    private String blockStreetAddress;
    @Column(name="block_state_code")
    private String blockStateCode;
    @Column(name="block_zipcode")
    private String blockZipcode;
    @Column(name = "block_size")
    private float blockSize;
    @Column(name = "block_crop")
    private String blockCrop;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFarmId() {
        return farmId;
    }

    public void setFarmId(String farmID) {
        this.farmId = farmID;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getBlockStreetAddress() {
        return blockStreetAddress;
    }

    public void setBlockStreetAddress(String blockStreetAddress) {
        this.blockStreetAddress = blockStreetAddress;
    }

    public String getBlockStateCode() {
        return blockStateCode;
    }

    public void setBlockStateCode(String blockStateCode) {
        this.blockStateCode = blockStateCode;
    }

    public String getBlockZipcode() {
        return blockZipcode;
    }

    public void setBlockZipcode(String blockZipcode) {
        this.blockZipcode = blockZipcode;
    }

    public float getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(float blockSize) {
        this.blockSize = blockSize;
    }

    public String getBlockCrop() {
        return blockCrop;
    }

    public void setBlockCrop(String blockCrop) {
        this.blockCrop = blockCrop;
    }
}
