package org.example;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public boolean ProcessPayment(Payment payment) {
        System.out.println("Paying through credit card");
        payment.markAsCompleted();
        return true;
    }
}
