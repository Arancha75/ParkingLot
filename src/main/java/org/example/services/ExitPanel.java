package org.example.services;

import org.example.Interface.PaymentStrategy;
public class ExitPanel{
    public boolean processPayment(ParkingTicket ticket, PaymentStrategy strategy) {
        if (ticket == null || strategy == null) {
            throw new IllegalArgumentException("Ticket or PaymentStrategy cannot be null");
        }
        Payment payment = new Payment(ticket.getAmount());
        try {
            if (strategy.processPayment(payment)) {
                payment.markAsCompleted();
                ticket.markPaid(ticket.getAmount());
                return true;
            } else {
                payment.markAsFailed();
            }
        } catch (Exception e) {
            // Handle unexpected exceptions
            payment.markAsFailed();
            throw new RuntimeException("Error processing payment", e);
        }
        return false;
    }
}
