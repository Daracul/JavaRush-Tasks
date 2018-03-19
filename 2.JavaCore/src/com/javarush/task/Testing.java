package com.javarush.task;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by amalakhov on 22.03.2017.
 */
public class Testing {
    public static void main(String[] args) throws Exception {
        Cat cat = new Cat();
        cat.name="Barsik";
        cat.age=12;
        cat.weight=5;
        FileOutputStream fos = new FileOutputStream("d:\\pack\\herna.txt");
        Dog dog = new Dog();
        dog.name="Sharik";
        dog.age=10;
        Human human = new Human();
        human.cat=cat;
        human.dog=dog;
        human.save(fos);
    }



}
class Human
{
    public Cat cat;
    public Dog dog;

    public void save(OutputStream outputStream) throws Exception
    {
        PrintWriter writer = new PrintWriter(outputStream);

        String isCatPresent = cat != null ? "yes" : "no";
        writer.println(isCatPresent);
        writer.flush();
        System.out.println(isCatPresent);

        if (cat!=null)
            cat.save(outputStream);

        String isDogPresent = dog != null ? "yes" : "no";
        writer.println(isDogPresent);
        writer.flush();
        System.out.println(isDogPresent);

        if (dog != null)
            dog.save(outputStream);
    }

    public void load(InputStream inputStream) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String isCatPresent = reader.readLine();
        if (isCatPresent.equals("yes"))
        {
            cat = new Cat();
            cat.load(inputStream);
        }

        String isDogPresent = reader.readLine();
        if (isDogPresent.equals("yes"))
        {
            dog = new Dog();
            dog.load(inputStream);
        }
    }
}
class Cat
{
    public String name;
    public int age;
    public int weight;

    public void save(OutputStream outputStream) throws Exception
    {
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.println(name);
        printWriter.println(age);
        printWriter.println(weight);
        printWriter.flush();
    }

    public void load(InputStream inputStream) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        name = reader.readLine();
        age = Integer.parseInt(reader.readLine());
        weight = Integer.parseInt(reader.readLine());
    }
}
class Dog
{
    public String name;
    public int age;

    public void save(OutputStream outputStream) throws Exception
    {
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.println(name);
        printWriter.println(age);
        printWriter.flush();
    }

    public void load(InputStream inputStream) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        name = reader.readLine();
        age = Integer.parseInt(reader.readLine());
    }
}

