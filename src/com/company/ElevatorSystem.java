package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ElevatorSystem {
    private Elevator elevator = new Elevator();
    private List<Floor> floors = new ArrayList<>();
    int numberOfFloors;
    static int i = 0;
    private final int CapacityOfElevator = 5;


    ElevatorSystem() {
        Random r = new Random();
        numberOfFloors = r.nextInt(16) + CapacityOfElevator;
        for (int i = 0; i < numberOfFloors; i++) {
            floors.add(new Floor(i + 1, numberOfFloors));
        }
        show();
    }

    private void show() {
        System.out.println("Floors ");
        for (int i = 0; i < floors.size(); i++) {
            System.out.println("floor №" + ++i + " : ");
            i--;
            System.out.print("Direction ");
            for (int j = 0; j < floors.get(i).getPassengers().size(); j++) {
                Passenger p = (Passenger) floors.get(i).getPassengers().get(j);
                System.out.print(p.getGoal() + "  ");
            }
            System.out.println();
        }
    }
    private void showCurrentElevator(){

        System.out.println("\nCurrent Elevator");
        for (Passenger p: elevator.getPassengers()) {
            System.out.print(" " + p.getGoal());
        }
        System.out.println();
    }
    private void showCurrentFloor(){
        System.out.println("\nCurrent Floor №" + i);
        for(Passenger p:  floors.get(i).getPassengers()){
            System.out.print(" " + p.getGoal());
        }
        System.out.println();
    }

    private int next() {
        if (i <= 0)
            return 2;
        return this.elevator.getMaxGoal();
    }

    public Elevator system(Elevator elevator) {
        if (this.elevator.getPassengersSize() == 0 && floors.size() == 0) {
            return new Elevator();
        }
        System.out.println("Step №" + i);
        this.elevator.removeAllNeededPassengers(i + 1);
        if (this.elevator.getPassengersSize() < CapacityOfElevator) {
            this.elevator.setPassengers(floors.get(i).getNeededPassengers(CapacityOfElevator - this.elevator.getPassengersSize(), next()));
        }
        showCurrentElevator();
        showCurrentFloor();
        i = this.elevator.move(i) ? ++i : --i;
        return system(elevator);
    }

}
