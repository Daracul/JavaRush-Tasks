package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s=reader.readLine()).equals("exit")){
            new ReadThread(s).start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName=fileName;
            //implement constructor body
        }
        public void run(){
            try {
                FileInputStream fis = new FileInputStream(fileName);
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                while (fis.available()>0){
                    int r=fis.read();
                    if (!map.containsKey(r)){
                        map.put(r,1);
                    }
                    else {
                        map.put(r,map.get(r)+1);
                    }
                }
                fis.close();
                int max=0;
                for (int i:map.values()){
                    if (i>max){
                        max=i;
                    }
                }
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue()==max){
                        resultMap.put(fileName,entry.getKey());
                    }
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
