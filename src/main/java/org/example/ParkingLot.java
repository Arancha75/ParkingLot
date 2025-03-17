package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingFloor> floors;
    private List<EntrancePanel> entrancePanels;
    private List<ExitPanel> exitPanels;

    private ParkingLot() {
        this.floors = new ArrayList<>();
        this.entrancePanels = new ArrayList<>();
        this.exitPanels = new ArrayList<>();
    }

    public static ParkingLot getInstance(){
        if(instance == null){
            synchronized (ParkingLot.class){
                if(instance == null){
                    instance= new ParkingLot();
                }
            }

        }
        return instance;

    }


    public boolean addParkingFloor(ParkingFloor floor){
        return floors.add(floor);
    }

    public boolean isFull(){
        for(ParkingFloor floor: floors){
            if(!floor.isFull()){
                return false;
            }
        }
        return true;
    }

    public ParkingTicket getNewParkingTicket(Vechile vechile){
        if(isFull()) return null;
        for(ParkingFloor floor:floors){
            ParkingSpot spot=  floor.getAvailableParkingSpot(vechile.getType());
            if(spot==null){
                ParkingSpot newSpot = null;
                if (vechile.getType().equals(VechileType.BIKE)) {
                    newSpot = new CompactSpot(new Random().toString());
                } else {
                    newSpot = new LargeSpot(new Random().toString());
                }
                newSpot.assignVechile(vechile);
                return new ParkingTicket(vechile,newSpot);
            }
        }
        return null;
    }

}
