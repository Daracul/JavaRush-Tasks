package com.javarush.task.task21.Expirience;

/**
 * Created by amalakhov on 26.04.2017.
 */


interface A {}
interface B {}

class X implements A, B {}

class Y implements A {
    B makeB() {
        // Безымянный внутренний класс:
        return new B() {};
    }
}

public class MultiInterfaces {
    static void takesA(A a) {}
    static void takesB(B b) {}
    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        takesA(x);
        takesA(y);
        takesB(x);
        takesB(y.makeB());
    }
}
