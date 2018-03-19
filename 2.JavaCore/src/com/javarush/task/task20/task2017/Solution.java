package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        A aForReturn=null;
        try {
            Object something = objectStream.readObject();
            if (something instanceof A){
                aForReturn=(A)something;
            }
            else aForReturn=null;
        }
        catch (ClassNotFoundException e){

        }
        catch (IOException e){

        }
        finally {
            return aForReturn;
        }
    }

    public class A implements Serializable{
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
