package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public void fillInPropertiesMap() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String file = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(file);
            load(fileInputStream);
        }
        catch (IOException e){e.printStackTrace();}
        catch (Exception ex){ex.printStackTrace();}
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        for (Map.Entry<String,String> pair : properties.entrySet()){
            prop.setProperty(pair.getKey(),pair.getValue());

        }
        prop.store(outputStream,null);
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        for (String key:prop.stringPropertyNames()){
            properties.put(key,prop.getProperty(key));
        }
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) throws Exception  {
        Solution sol = new Solution();
        sol.fillInPropertiesMap();
        for (String key:properties.keySet()){
            System.out.println(key+" "+properties.get(key));
        }


    }
}
