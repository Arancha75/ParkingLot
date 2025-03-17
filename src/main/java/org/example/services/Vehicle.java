package org.example.services;

import org.example.enums.VehicleType; // Corrected spelling of VehicleType

public class Vehicle {
    private final String licenseNumber; // Made field final for immutability
    private final VehicleType type; // Made field final for immutability

    // Constructor with validations for null or invalid inputs
    public Vehicle(String licenseNumber, VehicleType type) {
        if (licenseNumber == null || licenseNumber.isEmpty()) {
            throw new IllegalArgumentException("License Number must not be null or empty");
        }
        if (type == null) {
            throw new IllegalArgumentException("Vehicle Type must not be null");
        }
        this.licenseNumber = licenseNumber;
        this.type = type;
    }

    // Getter for licenseNumber
    public String getLicenseNumber() {
        return licenseNumber;
    }

    // Getter for type
    public VehicleType getType() {
        return type;
    }
}
