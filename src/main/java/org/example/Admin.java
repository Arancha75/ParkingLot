package org.example;

public class Admin extends Account{
    public Admin(String username, String password, Person person, AccountStatus status) {
        super(username, password, person, status);
    }

    public boolean addParkingFloor(ParkingFloor floor){
        System.out.println("Adding new Parking floor" + floor.);
    }
}
