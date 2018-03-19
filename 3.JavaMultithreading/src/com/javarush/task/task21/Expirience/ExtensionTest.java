package com.javarush.task.task21.Expirience;

import java.io.File;

/**
 * Created by amalakhov on 07.06.2017.
 */
public class ExtensionTest {
    public static void main(String[] args) {
        File file = new File("something.HtMl");
        String endfile = file.getName().substring(file.getName().lastIndexOf('.')+1);
        System.out.println(endfile);
        System.out.println(endfile.equalsIgnoreCase("html")||endfile.equalsIgnoreCase("htm"));
    }
}
