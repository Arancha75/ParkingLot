package org.example.services;

import org.example.enums.ParkingSpotType;
import org.example.Interface.ParkingSpot;

public class LargeSpot extends ParkingSpot {
    public LargeSpot(String number) {
        super(ParkingSpotType.LARGE, number);
    }
}
