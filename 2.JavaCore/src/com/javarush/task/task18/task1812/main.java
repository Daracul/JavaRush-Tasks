package com.javarush.task.task18.task1812;

import java.io.IOException;

/**
 * Created by amalakhov on 03.03.2017.
 */
public class main {
    public static void main(String[] args) throws IOException {
        new QuestionFileOutputStream(new Wrapper()).close();
    }
}
