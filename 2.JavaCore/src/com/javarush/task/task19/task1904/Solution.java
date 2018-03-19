package com.javarush.task.task19.task1904;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        PersonScanner scanner = new PersonScannerAdapter(new Scanner(new FileInputStream("D:\\pack\\book.txt")));
        System.out.println(scanner.read());
        System.out.println(scanner.read());
        System.out.println(scanner.read());

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String personLine = fileScanner.nextLine();
            String[] personArray = personLine.split(" ");
            String firstName = personArray[1];
            String secondName=personArray[0];
            String fathersName =personArray[2];
            Calendar data = new GregorianCalendar(Integer.parseInt(personArray[5]),Integer.parseInt(personArray[4])-1,Integer.parseInt(personArray[3]));
            return new Person(firstName,fathersName,secondName,data.getTime());
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
