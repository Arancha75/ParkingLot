package org.example.services;

import org.example.Factory.ParkingSpotFactory;
import org.example.enums.VehicleType;
import org.example.Interface.ParkingSpot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class ParkingLot {
    private static volatile ParkingLot instance;
    private final List<ParkingFloor> floors;
    private final List<EntrancePanel> entrancePanels;
    private final List<ExitPanel> exitPanels;


    private ParkingLot() {
        this.floors = new ArrayList<>();
        this.entrancePanels = new ArrayList<>();
        this.exitPanels = new ArrayList<>();
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) {
                    try {
                        instance = new ParkingLot();
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to initialize ParkingLot instance.", e);
                    }
                }
            }

        }
        return instance;
    }


    public boolean addParkingFloor(ParkingFloor floor) {
        return floors.add(floor);
    }

    public boolean isFull() {
        for (ParkingFloor floor : floors) {
            if (!floor.isFull()) {
                return false;
            }
        }
        return true;
    }

    public ParkingTicket getNewParkingTicket(Vehicle vehicle) {
        System.out.println("Vehicle of type: " + vehicle.getType() + " has arrived at parking lot");
        if (isFull()) return null;
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.getAvailableParkingSpot(vehicle.getType());
            if (spot == null) {
                ParkingSpot newSpot = ParkingSpotFactory.createParkingSpot(vehicle.getType(), UUID.randomUUID().toString());
                newSpot.assignVehicle(vehicle);
                return new ParkingTicket(vehicle, newSpot);
            }
        }
        return null;
    }

    public boolean processTicket(String ticketNumber) {
        return false;
    }
}
