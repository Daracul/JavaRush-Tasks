package com.javarush.task;

import java.io.*;

/**
 * Created by rill on 26.02.2017.
 */
public class argsTest {
    public static void main(String[] args) throws IOException {

        String id = "4324";
        System.out.println(id.length());
        id =  String.format("%-8s%-30s",id,"kakie to slova");
        System.out.println(id);
        System.out.println(id.length());

    }
}