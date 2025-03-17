package org.example;

public class EntrancePanel {
    public ParkingTicket printTicket(Vechile vehicle) {
        return ParkingLot.getInstance().getNewParkingTicket(vehicle);
    }
}
