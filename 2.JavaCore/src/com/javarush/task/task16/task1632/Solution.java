package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread(new Thread1()));
        threads.add(new Thread(new Thread2()));
        threads.add(new Thread(new Thread3()));
        threads.add(new Thread(new Thread4()));
        threads.add(new Thread(new Thread5()));

    }

    public static void main(String[] args) {
    }
    public static class Thread1 implements Runnable{
        public void run(){
            System.out.println("Thread0 has been started forever");
            while (true){}
        }

    }
    public static class Thread2 implements Runnable{
        public void run() {
            System.out.println("Thread1 has been started");
            try {
                Thread.sleep(0);
            }
            catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
        }
    }
    public static class Thread3 implements Runnable{
        public void run(){
            try {
                while (true){
                    System.out.println("Ура");
                Thread.sleep(500);
               }
            }
            catch (InterruptedException e){}
        }

    }
    public static class Thread4 extends Thread implements Message{
        public void run(){
           while (!Thread.currentThread().isInterrupted()){

           }

        }

        @Override
        public void showWarning() {
            Thread.currentThread().interrupt();

        }
    }
    public static class Thread5 implements Runnable{
        @Override
        public void run() {
            BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
            String a=null;
            int b=0;

            try {
                while (true){
                    String s = reader.readLine();
                    if (s.equals("N")){
                        break;
                    }
                    b+=Integer.parseInt(s);
                }
            }
            catch (IOException e){
            }
            System.out.println(b);
        }
    }


}