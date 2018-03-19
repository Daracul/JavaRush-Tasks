package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {
    static int countFolders=0;
    static int countFiles=0;
    static long countTotalSize=0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter folder path");
        String folder=reader.readLine();
        reader.close();
        if (!Files.isDirectory(Paths.get(folder))){
            System.out.println(folder+" - не папка");
        }
        else {
            Files.walkFileTree(Paths.get(folder),new SearchFileVisitor());
            System.out.println("Всего папок - "+(countFolders-1));
            System.out.println("Всего файлов - "+countFiles);
            System.out.println("Общий размер - "+countTotalSize);
        }
    }

    public static class SearchFileVisitor extends SimpleFileVisitor<Path>{
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (Files.isRegularFile(file)){
                countFiles++;
                countTotalSize+=attrs.size();
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {

                countFolders++;

            return FileVisitResult.CONTINUE;
        }
    }
}
