package org.example.services;

import org.example.enums.ParkingTicketStatus;
import org.example.Interface.ParkingSpot;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.example.constants.Constant.AMOUNT;

public class ParkingTicket {
    private String ticketNumber;
    private LocalDateTime  issuedAt;
    private LocalDateTime paidAt;
    protected Double amount;
    private ParkingTicketStatus status;
    private Vehicle vechile;
    private ParkingSpot parKingSpot;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parKingSpot) {
        this.vechile = vehicle;
        this.parKingSpot = parKingSpot;
        this.status = ParkingTicketStatus.ACTIVE;
        this.issuedAt= LocalDateTime.now();
        this.ticketNumber= UUID.randomUUID().toString();
        this.amount = AMOUNT;

    }

    public void markPaid(double amount){
        this.amount = amount;
        this.status = ParkingTicketStatus.PAID;
        this.paidAt= LocalDateTime.now();;

    }

    public double getAmount() {
        return amount;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public ParkingSpot getParKingSpot() {
        return parKingSpot;
    }
}
