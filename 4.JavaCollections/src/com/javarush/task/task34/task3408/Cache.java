package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K,V>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if (!cache.containsKey(key)){

            V value = clazz.getConstructor(key.getClass()).newInstance((K)key);
            cache.put(key,value);
        }
        return cache.get(key);
        //TODO add your code here
    }

    public boolean put(V obj) {
        Method[] methods = obj.getClass().getDeclaredMethods();
        Method myMethod=null;
        K key=null;
        for (Method method:methods){
            if (method.getName().equals("getKey")){
                myMethod=method;
            }
        }
        myMethod.setAccessible(true);
        try {
            key = (K) myMethod.invoke(obj);
            cache.put(key,obj);
            return cache.containsKey(key);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return false;
        //TODO add your code here

    }

    public int size() {
        return cache.size();
    }
}
