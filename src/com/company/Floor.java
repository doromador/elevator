package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Floor {

    private final int currentFloor;
    private List<Passenger> passengers = new ArrayList<>();

    Floor(int curentFloor, int numberOfFloors){
        Random r = new Random();
        this.currentFloor = curentFloor;
        int numberOfPassengersOnFloor = r.nextInt(11);
        for(int i = 0; i< numberOfPassengersOnFloor;i++){

            passengers.add(new Passenger(numberOfFloors));
        }
    }
    public List<Passenger> getPassengers() {
        return passengers;

    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }



    public List getNeededPassengers(int sizeOfNeededPassengers, int numberMaxOfFloor){
        List<Passenger> newPassengers = new ArrayList<>();

        for(int i = 0;i<passengers.size();i++){
            if(i == sizeOfNeededPassengers - 1){
                break;
            }
            if(passengers.get(i).getGoal() > currentFloor && numberMaxOfFloor > currentFloor || passengers.get(i).getGoal() < currentFloor && numberMaxOfFloor < currentFloor){
                newPassengers.add(passengers.get(i));
                passengers.remove(passengers.get(i));

            }
        }
        return newPassengers;
    }


}
