package org.example.services;

import org.example.Interface.Account;
import org.example.enums.AccountStatus;

import java.util.logging.Logger;

public class ParkingAttendant extends Account {
    private static final Logger LOG = Logger.getLogger(ParkingAttendant.class.getName());
    private static final String INVALID_TICKET_MESSAGE = "Invalid ticket number provided.";
    private static final String PROCESS_TICKET_MESSAGE = "Parking Attendant processing ticket: ";

    public ParkingAttendant(String name, String password, Person person, AccountStatus status) {
        super(name, password, person, status);
    }

    @Override
    public void logAccountActivity(String activity) {
        LOG.info("Parking Attendant Activity: " + activity);
    }

    public boolean processParkingTicket(String ticketNumber) {
        if (isInvalidTicketNumber(ticketNumber)) {
            LOG.warning(INVALID_TICKET_MESSAGE);
            return false;
        }

        LOG.info(PROCESS_TICKET_MESSAGE + ticketNumber);

        ParkingLot parkingLot = ParkingLot.getInstance();
        if (parkingLot == null) {
            LOG.severe("ParkingLot instance is null. Cannot process ticket.");
            return false;
        }

        return parkingLot.processTicket(ticketNumber);
    }

    private boolean isInvalidTicketNumber(String ticketNumber) {
        return ticketNumber == null || ticketNumber.trim().isEmpty();
    }
}