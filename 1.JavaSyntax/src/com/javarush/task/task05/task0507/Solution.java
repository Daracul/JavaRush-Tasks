package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int numb;
        int summ=0;
        ArrayList<Integer> numbs = new ArrayList<Integer>();
        while ((numb=sc.nextInt())!=-1){
            numbs.add(numb);
        }
        for (int i = 0;i<numbs.size();i++){
            summ+=numbs.get(i);
        }
        System.out.println((double)summ/numbs.size());
        //напишите тут ваш код
    }
}

