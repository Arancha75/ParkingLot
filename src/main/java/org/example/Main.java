package org.example;

import org.example.constants.Constant;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        //TOOD : use proper directories according to the functionalities
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        ParkingLot parkingLot = ParkingLot.getInstance();
        //TOOD :  never  harcode constants
        Vechile vechile = new Vechile(Constant.DEMO_LICENSE_NUM, VechileType.ELECTRIC);
        ParkingFloor floor0 = new ParkingFloor("Ground Floor");
        ParkingFloor floor1 = new ParkingFloor("First Floor");

        floor0.addParkingSpot(new CompactSpot("c1"));
        floor1.addParkingSpot(new LargeSpot("l1"));
        parkingLot.addParkingFloor(floor0);
        //parkingLot.addParkingFloor(floor1);

        EntrancePanel entrancePanel = new EntrancePanel();
        ParkingTicket ticket = entrancePanel.printTicket(vechile);
        System.out.println("Ticket issued " + ticket);

        ExitPanel exitPanel = new ExitPanel();
        //TODOO :  use proper naming conventions for variables
        PaymentStrategy paymentmethod = new CreditCardPayment();
        boolean paymentSuccess = exitPanel.processPayment(ticket, paymentmethod);

        if (paymentSuccess) {
            System.out.println("Payment successful. Vehicle can exit now !!");
        } else {
            System.out.println("Payment Failed");
        }
    }
}