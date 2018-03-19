package com.javarush.task.task21.Expirience;

import java.io.*;

/**
 * Created by amalakhov on 27.04.2017.
 */
public class ObjectCopy {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        Object object1 = new Object();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(buffer);
        outputStream.writeObject(object1);
        outputStream.close();
        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
        Object objectClone=inputStream.readObject();
        System.out.println(object1);
        System.out.println(objectClone);
    }
}
