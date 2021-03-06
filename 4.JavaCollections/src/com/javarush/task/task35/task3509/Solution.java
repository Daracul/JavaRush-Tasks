package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution<T extends Collection> {

    public static void main(String[] args) {
    }

    public static <T>ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> list = new ArrayList();
        for (T object:elements){
            list.add(object);
        }
        //напишите тут ваш код
        return list;
    }

    public static <T>HashSet<T> newHashSet(T... elements) {
        HashSet<T> set = new HashSet<>();
        for (T object:elements){
            set.add(object);
        }

        //напишите тут ваш код
        return set;
    }

    public static <K,V>HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if (keys.size()!=values.size()){
            throw new IllegalArgumentException();
        }
        HashMap<K,V> hashMap = new HashMap<>();
        for (int i=0;i<keys.size();i++){
            hashMap.put(keys.get(i),values.get(i));
        }
        //напишите тут ваш код
        return hashMap;
    }
}
