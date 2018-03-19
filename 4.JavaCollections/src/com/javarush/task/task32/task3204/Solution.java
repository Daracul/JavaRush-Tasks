package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        byte[] pass = new byte[8];

        for (int i=0;i<8;i++){
            int randomDigit = 48+(int)(Math.random()*10);
            int randomUpperCase = 65+(int)(Math.random()*26);
            int randomLowerCase = 97+(int)(Math.random()*26);
            int random = (int)(Math.random()*3);
            if (i==0){
                pass[i]=(byte)randomDigit;
            }
            else if (i==5){
                pass[i]=(byte)randomLowerCase;
            }
            else if (i==7){
                pass[i]=(byte)randomUpperCase;
            }
            else {
                switch (random) {
                    case 0:
                        pass[i] = (byte) randomDigit;
                        break;
                    case 1:
                        pass[i] = (byte) randomUpperCase;
                        break;
                    case 2:
                        pass[i] = (byte) randomLowerCase;
                        break;
                }
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(pass);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return byteArrayOutputStream;
    }
}