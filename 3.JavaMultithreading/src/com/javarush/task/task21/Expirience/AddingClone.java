package com.javarush.task.task21.Expirience;

/**
 * Created by amalakhov on 17.04.2017.
 */
//: Приложение А: AddingClone.java
// Для добавления клонирования в ваш класс
// потребуется несколько циклов.
import java.util.*;

class Int2 implements Cloneable {
    private int i;
    public Int2(int ii) { i = ii; }
    public void increment() { i++; }
    public String toString() {
        return Integer.toString(i);
    }
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch(CloneNotSupportedException e) {
            System.err.println("Int2 не может быть клонирован");
        }
        return o;
    }
}

// Поскольку он клонируемый, наследование
// не сделает его не клонируемым:
class Int3 extends Int2 {
    private int j; // Автоматически дублируется
    public Int3(int i) { super(i); }
}

public class AddingClone {
    public static void main(String[] args) {
        Int2 x = new Int2(10);
        Int2 x2 = (Int2)x.clone();
        x2.increment();
        System.out.println(
                "x = " + x + ", x2 = " + x2);
        // Все наследники также являются клонируемыми:
        Int3 x3 = new Int3(7);
        x3 = (Int3)x3.clone();

        ArrayList v = new ArrayList();
        for(int i = 0; i < 10; i++ )
            v.add(new Int2(i));
        System.out.println("v: " + v);
        ArrayList v2 = (ArrayList)v.clone();
        // Теперь клонируем каждый элемент:
        for(int i = 0; i < v.size(); i++)
            v2.set(i, ((Int2)v2.get(i)).clone());
        // Увеличиваемзначения всех элементов v2:
        for(Iterator e = v2.iterator();
            e.hasNext(); )
            ((Int2)e.next()).increment();
        // Смотрим, изменились ли значения элементов v:
        System.out.println("v: " + v);
        System.out.println("v2: " + v2);
    }
}
