package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Elevator {
    private final int CapacityOfElevator = 5;

    public List<Passenger> getPassengers() {
        return passengers;
    }

    private List<Passenger> passengers = new ArrayList<>();
    private int maxFloor;

    public void setPassengers(List<Passenger> passengers) {
        if (this.passengers.size() < CapacityOfElevator) {
            this.passengers.addAll(passengers);
        }
    }

    public int getPassengersSize() {
        return passengers.size();
    }


    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    private void show() {
        System.out.println();
    }

    public void removeAllNeededPassengers(int currentFloor) {
        if (existPassengerForCurrentFloor(currentFloor)) {
            passengers.removeIf(p -> p.getGoal() == currentFloor);
        }
    }

    public boolean existPassengerForCurrentFloor(int currentFloor) {
        return passengers.stream().anyMatch(p -> p.getGoal() == currentFloor);
    }

    //    public List<Passenger> getAllNeededPassengers(int currentFloor){
//        if(existPassengerForCurrentFloor(currentFloor)){
//            return passengers.stream().filter(p-> p.getGoal() == currentFloor).collect(Collectors.toList());
//        }
//        return new ArrayList<>();
//    }
    public int getMaxGoal() {
        Optional optional = passengers.stream().max(Comparator.comparing(Passenger::getGoal));
        if(optional.isPresent()){
            return ((Passenger)optional.get()).getGoal();
        }
        return 0;
    }

    public boolean move(int currentFloor) {
        if (passengers.size() == 0 || getMaxGoal() < currentFloor) {
            return false;
        }
        return true;
    }
}
