package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String,Integer> map  =new HashMap<String, Integer>();
        for (int i=0;i<10;i++){
            map.put("surmame"+i,495+i);
        }
        return map;
        //напишите тут ваш код
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator<Map.Entry<String,Integer>> itrator = map.entrySet().iterator();
        while (itrator.hasNext()){
            Map.Entry<String,Integer> pair = itrator.next();
            if (pair.getValue()<500){
                itrator.remove();
            }
        }

        //напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}