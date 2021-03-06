package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        Stack<File> stack = new Stack<>();
        stack.push(new File(root));
        while (!stack.isEmpty()){
            File child = stack.pop();
            if (child.isDirectory()){
                for (File file:child.listFiles()){
                    stack.push(file);
                }
            }
            else if (child.isFile()){
                list.add(child.getAbsolutePath());
            }
        }
        return list;

    }

    public static void main(String[] args) {

    }
}
