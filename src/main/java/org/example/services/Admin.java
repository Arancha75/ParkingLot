package org.example.services;

import org.example.Interface.Account;
import org.example.enums.AccountStatus;
import java.util.logging.Logger;

public class Admin extends Account {

    private static final Logger LOGGER = Logger.getLogger(Admin.class.getName());
    private static final String NULL_FLOOR_ERROR = "ParkingFloor cannot be null";

    public Admin(String username, String password, Person person, AccountStatus status) {
        super(username, password, person, status);
    }

    @Override
    public void logAccountActivity(String activity) {
        logActivity("Admin Activity: " + activity);
    }

    public boolean addParkingFloor(ParkingFloor parkingFloor) {
        validateParkingFloor(parkingFloor);
        logActivity("Adding new Parking floor: " + parkingFloor.getName());
        return true;
    }

    private void validateParkingFloor(ParkingFloor parkingFloor) {
        if (parkingFloor == null) {
            throw new IllegalArgumentException(NULL_FLOOR_ERROR);
        }
    }

    private void logActivity(String message) {
        LOGGER.info(message);
    }
}