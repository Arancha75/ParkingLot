package org.example;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingTicket {
    private String ticketNumber;
    private LocalDateTime  issuedAt;
    private LocalDateTime paidAt;
    protected Double amount;
    private ParkingTicketStatus status;
    private Vechile vechile;
    private ParkingSpot parKingSpot;

    public ParkingTicket(Vechile vechile, ParkingSpot parKingSpot) {
        this.vechile = vechile;
        this.parKingSpot = parKingSpot;
        this.status = ParkingTicketStatus.ACTIVE;
        this.issuedAt= LocalDateTime.now();
        this.ticketNumber= UUID.randomUUID().toString();
        this.amount = 12343.0;

    }

    public void markPaid(double amount){
        this.amount = amount;
        this.status = ParkingTicketStatus.PAID;
        this.paidAt= LocalDateTime.now();;

    }
}
