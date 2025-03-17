package org.example.services;

import org.example.enums.PaymentStatus;
import org.example.Interface.PaymentStrategy;

import java.util.logging.*;

public class CreditCardPayment implements PaymentStrategy {

    private static final Logger logger = Logger.getLogger(CreditCardPayment.class.getName());
    // ANSI escape codes for color formatting
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    static {
        // Set a custom console handler to use colored logging
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                String color;
                if (record.getLevel() == Level.INFO) {
                    color = GREEN;
                } else if (record.getLevel() == Level.WARNING) {
                    color = YELLOW;
                } else if (record.getLevel() == Level.SEVERE) {
                    color = RED;
                } else {
                    color = RESET; // No color for other levels
                }
                return color + "[" + record.getLevel() + "] " + formatMessage(record) + RESET + "\n";
            }
        });

        // Remove default handlers and add the custom one
        logger.setUseParentHandlers(false);
        logger.addHandler(consoleHandler);
    }

    @Override
    public boolean processPayment(Payment payment) {
        if (payment == null) {
            logger.severe("Payment object is null. Cannot process.");
            return false;
        }
        if (payment.getStatus() != PaymentStatus.PENDING) {
            logger.warning("Payment cannot be processed as it is not in PENDING status: " + payment.toString());
            return false;
        }
        try {
            logger.info("Processing payment through credit card.");
            payment.markAsCompleted();
            logger.info("Payment processed successfully: " + payment.toString());
            return true;
        } catch (Exception e) {
            logger.severe("An error occurred during payment processing: " + e.getMessage());
            return false;
        }
    }
}
