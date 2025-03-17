package org.example.Factory;

import org.example.Interface.ParkingSpot;
import org.example.enums.VehicleType;
import org.example.services.CompactSpot;
import org.example.services.LargeSpot;

public class ParkingSpotFactory {

    public static ParkingSpot createParkingSpot(VehicleType vehicleType, String number) {
        return switch (vehicleType) {
            case CAR, BIKE -> new CompactSpot(number);
            case TRUCK, VAN -> new LargeSpot(number);
            //case ELECTRIC:
            //return new ElectricSpot(number);
            default -> throw new IllegalArgumentException("Unsupported VechileType: " + vehicleType);
        };
    }
}
