package org.example.services;

import org.example.enums.PaymentStatus;

public class Payment {
    private  double amount;
    private PaymentStatus status;

    public Payment(double amount) {
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }
    public void markAsCompleted() {
        this.status = PaymentStatus.SUCCESS;
    }

    public void markAsFailed() {
        this.status = PaymentStatus.FAILED;
    }

    public PaymentStatus getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "Payment{amount=" + amount + ", status=" + status + "}";
    }


}
