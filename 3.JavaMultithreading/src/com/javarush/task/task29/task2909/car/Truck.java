package com.javarush.task.task29.task2909.car;

/**
 * Created by amalakhov on 12.05.2017.
 */
public class Truck extends Car {
    public static final int MAX_TRUCK_SPEED = 80;
    public Truck(int numberOfPassengers) {
        super(Car.TRUCK,numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }
}
