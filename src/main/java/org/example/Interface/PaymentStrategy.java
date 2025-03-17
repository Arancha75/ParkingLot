package org.example.Interface;

import org.example.services.Payment;

public interface PaymentStrategy {
    boolean processPayment(Payment payment);
}
