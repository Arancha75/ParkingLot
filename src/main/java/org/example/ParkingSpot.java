package org.example;

public abstract class ParkingSpot {
    private ParkingSpotType type;

    private String number;
    private Vechile vechile;
    private boolean isOccupied;

    public ParkingSpot(ParkingSpotType type, String number) {
        this.type = type;
        this.number = number;
        this.isOccupied=false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public ParkingSpotType getType(){
        return type;
    }

    public void assignVechile(Vechile vechile){
        this.vechile = vechile;
        isOccupied=true;
    }

    public void removeVechile(Vechile vechile){
        this.vechile = vechile;
        isOccupied=false;
    }
}
