package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
        if (args.length<2){
            return;
        }
        if ((args[0].equals("-c"))&&(args.length==4)){ //если в консоле параметры с -с, добавляем нового человека
            Person person=null;
            if (args[2].equals("м")){
                person = Person.createMale(args[1],DATE_FORMAT.parse(args[3]));
            }
            else if (args[2].equals("ж")){
                person = Person.createFemale(args[1],DATE_FORMAT.parse(args[3]));
            }
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
        if ((args[0].equals("-u"))&&(args.length==5)){ //если в консоли параметры с -u , обновляем данные по ид
            Person person=null;
            if (args[3].equals("м")){
                person = Person.createMale(args[2],DATE_FORMAT.parse(args[4]));
            }
            else if (args[3].equals("ж")){
                person = Person.createFemale(args[2],DATE_FORMAT.parse(args[4]));
            }
            allPeople.set(Integer.parseInt(args[1]),person);
        }

        if ((args[0].equals("-d"))&&(args.length==2)){ // делаем логическое удаление
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDay(null);
            allPeople.set(Integer.parseInt(args[1]),person);
        }
        if ((args[0].equals("-i"))&&(args.length==2)){
            Person person = allPeople.get(Integer.parseInt(args[1]));
            String sex=null;
            if (person.getSex()==Sex.MALE) sex="м";
            else if (person.getSex()==Sex.FEMALE) sex="ж";
            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

            System.out.println(person.getName()+" "+sex+" "+ format.format(person.getBirthDay()));
        }
        else return;

        //start here - начни тут
    }
}
