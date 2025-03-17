package org.example.services;

public class Person {
    private final String name;
    private final Address address;
    private final String email;
    private final String phone;

    public Person(String name,  Address address, String email, String phone) {
        if (name == null || address == null || email == null || phone == null) {
            throw new IllegalArgumentException("All fields must be non-null");
        }
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }



    public String toString(){
        return "Name: "+name+"\nAddress: "+address+"\nEmail: "+email+"\nPhone: "+phone;
    }
}
