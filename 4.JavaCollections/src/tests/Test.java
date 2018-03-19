package tests;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by AMalakhov on 07.08.2017.
 */
public class Test {
    public static void main(String[] args) throws IOException
    {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jeferson";

        ArrayList<Pet> pets = new ArrayList<Pet>();
        pets.add(cat);
        pets.add(dog);
        House house = new House();
        house.pets.add(dog);
        house.pets.add(cat);

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, house);
        System.out.println(writer.toString());
    }
}

class Pet
{
    public String name;
}
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Cat.class, name="cat"),
        @JsonSubTypes.Type(value=Dog.class, name="dog")
})
class Cat extends Pet
{
    public int age;
}

class Dog extends Pet
{
    public int age;
    public String owner;
}

class House
{
    public List pets = new ArrayList();
}
