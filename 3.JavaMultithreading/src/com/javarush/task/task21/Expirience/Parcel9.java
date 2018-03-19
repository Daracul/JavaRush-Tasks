package com.javarush.task.task21.Expirience;

/**
 * Created by amalakhov on 26.04.2017.
 */
public class Parcel9 {
    // Для использования в безымянном внутреннем классе
    // аргументы должны быть неизменны (final)
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;
            public String readLabel() { return label; }
        };
    }
    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
        System.out.println(d.readLabel());

    }
}
interface Destination{
    public String readLabel();
}
