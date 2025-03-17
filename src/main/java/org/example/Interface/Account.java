package org.example.Interface;

import org.example.enums.AccountStatus;
import org.example.services.Person;

import java.security.MessageDigest;
import java.util.logging.Logger;

public abstract class Account {
    private String username;
    private String passwordHash;
    private AccountStatus status;
    private Person person;

    private static final Logger LOGGER = Logger.getLogger(Account.class.getName());

    // Constructor with validation
    public Account(String username, String password, Person person, AccountStatus status) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        if (status == null) {
            throw new IllegalArgumentException("Account status cannot be null");
        }

        this.username = username;
        this.passwordHash = hashPassword(password); // Hashing the password
        this.person = person;
        this.status = status;
    }

    // Abstract method for subclasses to implement
    public abstract void logAccountActivity(String activity);

    // Reset password functionality
    public boolean resetPassword() {
        LOGGER.info("Password reset request sent to " + username);
        return true;
    }

    // Getters with restricted or secure access
    public String getUsername() {
        return username;
    }

    // Validate password securely
    public boolean validatePassword(String password) {
        return passwordHash.equals(hashPassword(password));
    }

    public Person getPerson() {
        return person;
    }

    public AccountStatus getStatus() {
        return status;
    }

    // Setters with validations
    public void setStatus(AccountStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Account status cannot be null");
        }
        if (this.status == AccountStatus.BLACKLISTED) {
            throw new IllegalStateException("Cannot change status from BLACKLISTED");
        }
        this.status = status;
    }

    public void setPerson(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        this.person = person;
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        this.username = username;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        this.passwordHash = hashPassword(password);
    }

    // Secure password hashing
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error hashing password", ex);
        }
    }
}
