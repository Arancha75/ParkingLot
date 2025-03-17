package org.example;

public class CashPayment implements  PaymentStrategy{
    @Override
    public boolean ProcessPayment(Payment payment) {
        System.out.println("Paying through case");
        payment.markAsCompleted();
        return true;
    }

}
