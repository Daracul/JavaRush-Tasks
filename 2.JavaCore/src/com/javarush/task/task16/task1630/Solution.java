package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    static {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        }
        catch (IOException e){}
    }

    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String fullFileName;
        private String fileContent="";
        public void setFileName(String fullFileName){
            this.fullFileName=fullFileName;
        }
        public String getFileContent(){
            return fileContent;
        }
        public void run(){
            String s=null;
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fullFileName));
                while ((s = reader.readLine())!=null){
                    fileContent+=s+" ";
                }
            }
            catch (IOException e){
                System.out.println("File not found");
            }
        }
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
}
