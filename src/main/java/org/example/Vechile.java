package org.example;

public class Vechile {
    public String licenseNumber;
    public VechileType type;

    public Vechile(String licenseNumber, VechileType type) {
        this.licenseNumber = licenseNumber;
        this.type = type;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public VechileType getType() {
        return type;
    }
}
