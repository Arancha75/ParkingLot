package org.example;

public class ExitPanel {
    public boolean processPayment(ParkingTicket ticket, PaymentStrategy strategy) {
        Payment payment = new Payment(ticket.amount);
        if (strategy.ProcessPayment(payment)) {
            ticket.markPaid(ticket.amount);
            return true;
        }
        return false;
    }
}
