package org.example.services;


import org.example.enums.VehicleType;
import org.example.Interface.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private static final String AVAILABLE_SUFFIX = "Available";

    private String name;
    private DisplayBoard board;
    private List<ParkingSpot> spots = new ArrayList<>();

    public ParkingFloor(String name, DisplayBoard board) {
        this.name = name;
        this.board = board;
        updateDisplayBoard();
    }

    public String getName() {
        return name;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParkingSpot getAvailableParkingSpot(VehicleType vehicleType) {
        for (ParkingSpot spot : spots) {
            if (isSpotAvailableForType(spot, vehicleType)) {
                return spot;
            }
        }
        return null;
    }

    private boolean isSpotAvailableForType(ParkingSpot spot, VehicleType vehicleType) {
        return !spot.isOccupied() && spot.getType().equals(vehicleType);
    }

    public void addParkingSpot(ParkingSpot spot) {
        spots.add(spot);
        updateDisplayBoard();
    }

    private void updateDisplayBoard() {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                board.updateStatus(AVAILABLE_SUFFIX + " " + spot.getType());
                return;
            }
        }
    }

    public boolean isFull() {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                return false;
            }
        }
        return true;
    }
}