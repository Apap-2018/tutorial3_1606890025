package com.apap.tutorial3.model;

public class PilotModel {
    private String id;
    private String licenseNumber;
    private String name;
    private Long flyHour;

    public PilotModel(String id, String licenseNumber, String name, Long flyHour) {
        this.id = id;
        this.licenseNumber = licenseNumber;
        this.name = name;
        this.flyHour = flyHour;
    }
    
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFlyHour() {
        return this.flyHour;
    }

    public void setFlyHour(Long flyHour) {
        this.flyHour = flyHour;
    }

}