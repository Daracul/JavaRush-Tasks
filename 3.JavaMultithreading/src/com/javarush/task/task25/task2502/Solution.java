package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            ArrayList<String> list = new ArrayList<>();
            for (String s:loadWheelNamesFromDB()){
                list.add(s);
            }
            for (Wheel wheel:Wheel.values()){
                if ((!list.contains(wheel.toString()))||(Wheel.values().length!=loadWheelNamesFromDB().length)){
                    throw new IllegalArgumentException();
                }
            }
            wheels=new ArrayList<>();
            for (String s:loadWheelNamesFromDB()){
                    wheels.add(Wheel.valueOf(s));
            }
            //init wheels here
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
    }
}
