package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream{
    private FileInputStream component;
    public TxtInputStream(String fileName) throws IOException,UnsupportedFileNameException {
        super(fileName);
        component=new FileInputStream(fileName);
        if (!fileName.endsWith(".txt")) {
            super.close();
           throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) throws IOException,UnsupportedFileNameException {
        new TxtInputStream("d:\\1.txt.exe");
    }
}

