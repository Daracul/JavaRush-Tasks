package com.javarush.task.task21.Expirience;

/**
 * Created by amalakhov on 17.04.2017.
 */
import java.util.*;

class Int {
    private int i;
    public Int(int ii) { i = ii; }
    public void increment() { i++; }
    public String toString() {
        return Integer.toString(i);
    }
}

public class Cloning {
    public static void main(String[] args) {
        ArrayList v = new ArrayList();
        for(int i = 0; i < 10; i++ )
            v.add(new Int(i));
        System.out.println("v: " + v);
        ArrayList v2 = (ArrayList)v.clone();
        // Увеличение всех элементов v2:
        System.out.println(v2);
        v.set(0,34);
        System.out.println(v);
        System.out.println(v2);
//        for(Iterator e = v2.iterator(); e.hasNext(); )
//            ((Int)e.next()).increment();
        // Проверка изменения элементов v:
//        System.out.println("v: " + v);
    }
}