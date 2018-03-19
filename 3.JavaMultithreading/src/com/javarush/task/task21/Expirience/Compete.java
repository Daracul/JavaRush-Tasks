package com.javarush.task.task21.Expirience;

/**
 * Created by amalakhov on 17.04.2017.
 */
//: Приложение А:Compete.java
import java.io.*;

class Thing1 implements Serializable {}
class Thing2 implements Serializable {
    Thing1 o1 = new Thing1();
}

class Thing3 implements Cloneable {
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch(CloneNotSupportedException e) {
            System.err.println("Thing3 не может быть клонирован");
        }
        return o;
    }
}

class Thing4 implements Cloneable {
    Thing3 o3 = new Thing3();
    public Object clone() {
        Thing4 o = null;
        try {
            o = (Thing4)super.clone();
        } catch(CloneNotSupportedException e) {
            System.err.println("Thing4 не может быть клонирован");
        }
        // Клонировать поле:
        o.o3 = (Thing3)o3.clone();
        return o;
    }
}

public class Compete {
    static final int SIZE = 5000;
    public static void main(String[] args) throws Exception {
        Thing2[] a = new Thing2[SIZE];
        for(int i = 0; i < a.length; i++)
            a[i] = new Thing2();
        Thing4[] b = new Thing4[SIZE];
        for(int i = 0; i < b.length; i++)
            b[i] = new Thing4();
        long t1 = System.currentTimeMillis();
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(buf);
        for(int i = 0; i < a.length; i++)
            o.writeObject(a[i]);
        // Теперь получаем копии:
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
        Thing2[] c = new Thing2[SIZE];
        for(int i = 0; i < c.length; i++)
            c[i] = (Thing2)in.readObject();
        long t2 = System.currentTimeMillis();
        System.out.println(
                "Дублирование с применением серийности: " +
                        (t2 - t1) + " Миллисекунд");
        // Теперь попробуем использовать клонирование:
        t1 = System.currentTimeMillis();
        Thing4[] d = new Thing4[SIZE];
        for(int i = 0; i < d.length; i++)
            d[i] = (Thing4)b[i].clone();
        t2 = System.currentTimeMillis();
        System.out.println(
                "Дублирование через клонирование: " +
                        (t2 - t1) + " Миллисекунд");
    }
}
