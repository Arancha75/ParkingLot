package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        ParkingLot parkingLot = ParkingLot.getInstance();
        Vechile vechile = new Vechile("KA-101-AB",VechileType.ELECTRIC);
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
        PaymentStrategy paymentmethod = new CreditCardPayment();
        boolean paymentSucess = exitPanel.processPayment(ticket,paymentmethod);

        if(paymentSucess){
            System.out.println("Payment successful. Vechile can exit now !!");
        }
        else{
            System.out.println("Payment Failed");
        }
    }
}