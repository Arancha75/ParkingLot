package org.example;


import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private String name;
    private List<ParkingSpot> spots;


    public ParkingFloor(String name) {
        this.name = name;
        this.spots = new ArrayList<>();
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



    public ParkingSpot getAvailableParkingSpot(VechileType type) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && spot.getType().equals(type)) {
                return spot;
            }
        }
        return null;
    }


    public void addParkingSpot(ParkingSpot spot){
        spots.add(spot);

    }

    public boolean isFull(){
        return spots.stream().allMatch(org.example.ParkingSpot::isOccupied);
    }


}
