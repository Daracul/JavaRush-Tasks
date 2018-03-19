package com.javarush.task.task21.task2113;

import java.util.*;

/**
 * Created by amalakhov on 17.04.2017.
 */
public class Hippodrome {
    private static List<Horse> horses = new ArrayList<>();
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move(){
        for (Horse h:horses){h.move();}
    }
    public void print() {
        for (Horse h : horses) {
            h.print();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void run(){
        for(int i=1;i<=100;i++){
            move();print();
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e){e.printStackTrace();}
        }
        getWinner();
    }
    public Horse getWinner(){
        double max=0;
        Horse toReturn=null;
        for (int i=0;i<getHorses().size();i++){
            if (getHorses().get(i).getDistance()>max){
                max=getHorses().get(i).getDistance();
            }
        }
        for (int i=0;i<getHorses().size();i++){
            if (getHorses().get(i).getDistance()==max){
                toReturn=getHorses().get(i);
            }
        }
        return toReturn;

    }
    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");

    }

    public static void main(String[] args) {
        game=new Hippodrome(new ArrayList<Horse>());
        Horse horse1 = new Horse("Horse1",3,0);
        Horse horse2 = new Horse("Horse2",3,0);
        Horse horse3 = new Horse("Horse3",3,0);
        game.horses.add(horse1);game.horses.add(horse2);game.horses.add(horse3);
        game.run();
        game.printWinner();
    }
}
