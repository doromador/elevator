package com.company;

import java.util.Random;

public class Passenger {
    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    private int goal;

    Passenger(int numberOfFloors){
        Random r = new Random();
        goal = r.nextInt(numberOfFloors+1);
    }

}
