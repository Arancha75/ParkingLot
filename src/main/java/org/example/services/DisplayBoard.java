package org.example.services;

import org.example.Interface.ParkingSpot;

public class DisplayBoard {
    private static final String DEFAULT_NAME = "Defauld display";
    private String displayName;
    private String displayId;
    private ParkingSpot assignedSpot;
    private String statusMessage;


    public DisplayBoard(String displayName, String displayId, ParkingSpot assignedSpot, String statusMessage) {
        this.displayName = displayName !=null ? displayName : DEFAULT_NAME;
        this.displayId = displayId;
        this.assignedSpot = assignedSpot;
        this.statusMessage = "Available";
    }

    public DisplayBoard(String groundDisplay, int i, String s, Object o) {
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDisplayId() {
        return displayId;
    }

    public ParkingSpot getAssignedSpot() {
        return assignedSpot;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public  void updateStatus(String newStatus) {
        this.statusMessage = newStatus;
    }
}
