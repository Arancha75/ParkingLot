package org.example.services;

public class EntrancePanel {
    public ParkingTicket printTicket(Vehicle vehicle) {
        return ParkingLot.getInstance().getNewParkingTicket(vehicle);
    }
}
