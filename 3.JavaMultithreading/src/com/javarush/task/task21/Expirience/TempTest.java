package com.javarush.task.task21.Expirience;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by amalakhov on 31.05.2017.
 */
public class TempTest {
    public static void main(String[] args) {
        try {
            Files.createTempFile("PIZDEC",".tmp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
