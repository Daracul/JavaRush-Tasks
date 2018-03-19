package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализуйте Person
*/
public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
       transient String fullName;
       transient final String greetingString;
        String country;
        Sex sex;
      transient   PrintStream outputStream;
       transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException {
        Person person = new Person("Alex","Malakhov","Russia",Sex.MALE);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\pack\\1.txt"));
        objectOutputStream.writeObject(person);

    }
}
