package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by amalakhov on 05.12.2017.
 */
public class Solution {

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(),10000);
        testStrategy(new OurHashMapStorageStrategy(),10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> longs = new HashSet<>();
        for (String s: strings){
            longs.add(shortener.getId(s));
        }
        return longs;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> strings = new HashSet<>();
        for (Long id:keys){
            strings.add(shortener.getString(id));
        }
        return strings;

    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> setStrings = new HashSet<>();
        for (int i=0;i<elementsNumber;i++){
            setStrings.add(Helper.generateRandomString());
        }
        Shortener shortener=new Shortener(strategy);
        long startIdTimer = new Date().getTime();
        Set<Long> setIds = getIds(shortener,setStrings);
        long endIdTimer = new Date().getTime();
        long idTotalTime = endIdTimer-startIdTimer;
        Helper.printMessage(String.valueOf(idTotalTime));

        long startStringsTimer = new Date().getTime();
        Set<String> calculatedStrings = getStrings(shortener,setIds);
        long endStringsTimer = new Date().getTime();
        long stringsTotalTime = endStringsTimer-startStringsTimer;
        Helper.printMessage(String.valueOf(stringsTotalTime));

        if (calculatedStrings.containsAll(setStrings)){
            Helper.printMessage("Тест пройден.");
        }
        else Helper.printMessage("Тест не пройден.");




    }
}
