package com.company.Models;

import javax.persistence.*;

/**
 * Created by garrettcoggon on 6/22/15.
 */

@Entity
@Table(name = "application_profile")
public class ApplicationProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "app_id", unique = true, nullable = false)
    private int appId;
    @Column(name = "app_number")
    private String blockName;
    @Column(name = "block_name")
    private String appNumber;
    @Column(name = "app_date")
    private String appDate;
    @Column(name = "target_pest")
    private String targetPest;
    @Column(name = "app_notes")
    private String appNotes;
    @Column(name = "app_time")
    private String appTime;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getAppNumber() {
        return appNumber;
    }

    public void setAppNumber(String appNumber) {
        this.appNumber = appNumber;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public String getTargetPest() {
        return targetPest;
    }

    public void setTargetPest(String targetPest) {
        this.targetPest = targetPest;
    }

    public String getAppNotes() {
        return appNotes;
    }

    public void setAppNotes(String appNotes) {
        this.appNotes = appNotes;
    }

    public String getAppTime() {
        return appTime;
    }

    public void setAppTime(String appTime) {
        this.appTime = appTime;
    }


}
