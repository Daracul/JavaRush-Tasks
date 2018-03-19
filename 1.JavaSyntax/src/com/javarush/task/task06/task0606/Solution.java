package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        while (number>0){
            if ((number%2)%2==0){
                even++;
            }
            else odd++;
            number=number/10;
        }
        System.out.println("Even: "+even+ " Odd: "+odd);
        //напишите тут ваш код
    }
}
