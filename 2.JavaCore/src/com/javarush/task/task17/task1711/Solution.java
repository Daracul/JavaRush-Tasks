package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if (args.length<2){
            return;
        }
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    if ((args.length - 1) % 3 == 0) {
                        for (int i = 1; i < args.length; i++) {
                            if (i % 3 == 2) {
                                Person person = null;
                                if (args[i].equals("м")) {
                                    person = Person.createMale(args[(i - 1)], DATE_FORMAT.parse(args[(i + 1)]));
                                } else if (args[i].equals("ж")) {
                                    person = Person.createFemale(args[i - 1], DATE_FORMAT.parse(args[i + 1]));
                                }
                                allPeople.add(person);
                                System.out.println(allPeople.indexOf(person));
                            }
                        }
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    if ((args.length - 1) % 4 == 0) {
                        for (int i = 1; i < args.length; i++) {
                            if (i % 4 == 3) {
                                Person person = null;
                                if (args[i].equals("м")) {
                                    person = Person.createMale(args[i - 1], DATE_FORMAT.parse(args[i + 1]));
                                } else if (args[i].equals("ж")) {
                                    person = Person.createFemale(args[i - 1], DATE_FORMAT.parse(args[i + 1]));
                                }
                                allPeople.set(Integer.parseInt(args[i - 2]), person);
                            }
                        }
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    if (((args.length - 1) % 1 == 0)) {
                        for (int i = 1; i < args.length; i++) {
                            Person person = allPeople.get(Integer.parseInt(args[i]));
                            person.setName(null);
                            person.setSex(null);
                            person.setBirthDay(null);
                            allPeople.set(Integer.parseInt(args[i]), person);
                        }
                    }
                }
                break;
            case "-i":
                synchronized (allPeople){
            if (((args.length - 1) % 1 == 0)) {
                for (int i = 1; i < args.length; i++) {
                    Person person = allPeople.get(Integer.parseInt(args[i]));
                    String sex = null;
                    if (person.getSex() == Sex.MALE) sex = "м";
                    else if (person.getSex() == Sex.FEMALE) sex = "ж";
                    System.out.println(person.getName() + " " + sex + " " + format.format(person.getBirthDay()));
                }
            }
                break;
            }
        }
        //start here - начни тут
    }
}
