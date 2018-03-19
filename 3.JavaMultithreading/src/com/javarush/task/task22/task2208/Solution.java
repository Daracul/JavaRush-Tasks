package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        HashMap<String,String> map = new LinkedHashMap<>();
        map.put("name","Ivanov");
        map.put("country","Ukraine");
        map.put("city","Kiev");
        map.put("age",null);
        map.put("height","21");
        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Map.Entry<String,String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String ,String> pair=iterator.next();
            if (pair.getKey()==null||pair.getValue()==null){}
            else if (!iterator.hasNext()){
                stringBuilder.append(pair.getKey()).append(" = ").append("'"+pair.getValue()+"'");
            }
            else if (!(pair.getKey()==null)||!(pair.getValue()==null)){
                stringBuilder.append(pair.getKey()).append(" = ").append("'"+pair.getValue()+"'").append(" and ");
            }

        }
//        for (String key:params.keySet()){
//            if (key==null||params.get(key)==null){
//                continue;
//            }
//            else {
//                stringBuilder.append(key).append(" = ").append("'"+params.get(key)+"'").append(" and ");
//            }
//        }

        return stringBuilder.toString();
    }
}
