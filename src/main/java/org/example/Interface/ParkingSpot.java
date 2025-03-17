package org.example.Interface;

import org.example.enums.ParkingSpotType;
import org.example.services.Vehicle;

public abstract class ParkingSpot {
    private ParkingSpotType type;
    private String number;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSpot(ParkingSpotType type, String number) {
        if (type == null || number == null || number.isEmpty()) {
            throw new IllegalArgumentException("Invalid parking spot details");
        }
        this.type = type;
        this.number = number;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void assignVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
        if (isOccupied) {
            throw new IllegalStateException("Parking spot already occupied");
        }
        this.vehicle = vehicle;
        isOccupied = true;
    }

    public void removeVehicle() {
        if (!isOccupied) {
            throw new IllegalStateException("No vehicle in this spot");
        }
        this.vehicle = null;
        isOccupied = false;
    }


}
