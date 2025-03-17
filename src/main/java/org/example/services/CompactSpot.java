package org.example.services;

import org.example.enums.ParkingSpotType;
import org.example.Interface.ParkingSpot;

public class CompactSpot extends ParkingSpot {
    public CompactSpot(String number) {
        super(ParkingSpotType.COMPACT, number);
    }
}
