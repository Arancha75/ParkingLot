package org.example;

import org.example.Factory.ParkingSpotFactory;
import org.example.Interface.ParkingSpot;
import org.example.enums.VehicleType;
import org.example.Interface.PaymentStrategy;
import org.example.services.*;

public class ParkingApp {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingSpot compactSpot = ParkingSpotFactory.createParkingSpot(VehicleType.CAR, "C1");
        ParkingSpot largeSpot = ParkingSpotFactory.createParkingSpot(VehicleType.VAN, "L1");
        DisplayBoard displayBoard1 = new DisplayBoard("GroundDisplay", "01", compactSpot, "Happy Parking!");
        DisplayBoard displayBoard2 = new DisplayBoard("Floor1Display", "01", largeSpot, "Happy Parking!");
        ParkingFloor floor0 = new ParkingFloor("Ground Floor", displayBoard1);
        ParkingFloor floor1 = new ParkingFloor("First Floor", displayBoard2);
        floor0.addParkingSpot(compactSpot);
        floor1.addParkingSpot(largeSpot);
        parkingLot.addParkingFloor(floor0);
        parkingLot.addParkingFloor(floor1);

        // Simulating a vehicle entering the parking lot
        Vehicle car = new Vehicle("Car123", VehicleType.CAR);
        EntrancePanel entrancePanel = new EntrancePanel();
        ParkingTicket ticket = entrancePanel.printTicket(car);

        if (ticket != null) {
            System.out.println("Ticket issued:");
            System.out.println("Ticket Number: " + ticket.getTicketNumber());
            System.out.println("Parking Spot: " + ticket.getParKingSpot().getNumber());
        } else {
            System.out.println("Parking Lot is Full!");
        }

        // Simulating vehicle exit
        ExitPanel exitPanel = new ExitPanel();

        if (ticket != null) {
            PaymentStrategy creditCardPayment = new CreditCardPayment(); // Assuming implementation exists
            boolean isPaymentSuccessful = exitPanel.processPayment(ticket, creditCardPayment);
            if (isPaymentSuccessful) {
                System.out.println("Payment successful for ticket: " + ticket.getTicketNumber());
                System.out.println("Exit allowed.");
            } else {
                System.out.println("Payment failed. Exit not allowed.");
            }
        }
    }
}