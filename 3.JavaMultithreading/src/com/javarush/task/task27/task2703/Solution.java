package com.javarush.task.task27.task2703;

/* 
Создаем deadlock
*/
public class Solution {
    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                            + " has bowed to me!%n",
                    this.name, bower.getName());
//                System.out.println("I am here(bow method) "+Thread.currentThread().getName());
//                System.out.println("object "+this.getName()+" has invokoked method and "+bower.getName()+" locked перед синхронайзд методом");
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
//            System.out.println("object "+this.getName()+" has invokoked method and "+bower.getName()+" locked перед синхронайзд вторым методом");
//            System.out.println("I am here(bowBack method) "+Thread.currentThread().getName());
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() {
                alphonse.bow(gaston);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                gaston.bow(alphonse);
            }
        }).start();
    }
}
