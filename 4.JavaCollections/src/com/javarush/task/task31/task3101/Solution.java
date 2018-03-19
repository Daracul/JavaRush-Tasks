package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Проход по дереву файлов
*/
public class Solution {
    static ArrayList<File> files = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath  = new File(args[1]);
        File newFile = new File(resultFileAbsolutePath .getParent()+"\\allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath ,newFile);
        try (FileWriter fileWriter = new FileWriter(newFile, true)) {
            fillFileList(path.getPath());
            files.sort(new FileNameComparator());

            for (File file : files) {
                int c;
                FileReader fileReader = new FileReader(file);
                while ((c = fileReader.read()) != -1) {
                    fileWriter.write(c);
                }
                fileWriter.write(System.lineSeparator());
                fileReader.close();
            }
        }


    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

//    public static void listFilesForFolder( File folder) {
//        for ( File fileEntry : folder.listFiles()) {
//            if (fileEntry.isDirectory()) {
//                listFilesForFolder(fileEntry);
//            } else {
//                if (fileEntry.length()>50){
//                    FileUtils.deleteFile(fileEntry);
//                }
//                else if (fileEntry.length()<50){
//                    files.add(fileEntry);
//                }
//            }
//        }
//    }
private static void fillFileList(String path) {
    File[] filez = new File(path).listFiles();
    for (File file : filez) {
        if (file.isDirectory()) {
            fillFileList(file.getAbsolutePath());
            continue;
        }
        if (file.length() > 50)
            FileUtils.deleteFile(file);
        else
            files.add(file);
    }
}
}

//    public static void checkFile(File file){
//        if (file.length()>50){
//            FileUtils.deleteFile(file);
//        }
//        else if (file.length()<50){
//            files.add(file);
//        }
//    }

//    public static void sortFiles(ArrayList<File> list){
//        Collections.sort(list, new Comparator<File>() {
//            @Override
//            public int compare(File o1, File o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
//    }
     class FileNameComparator implements Comparator<File> {
        public int compare(File first, File second) {
            return first.getName().compareTo(second.getName());
        }
    }

//    public static void copyToOneFile(ArrayList<File> files,File file) throws FileNotFoundException,IOException {
//            try (FileWriter fileWriter = new FileWriter(file, true)) {
//                for (File file1 : files) {
//                    if (file1.exists()) {
//                        try (FileReader fileReader = new FileReader(file1)) {
//                            int c;
//                            while ((c = fileReader.read()) != -1) {
//                                fileWriter.write(c);
//                            }
//                        }
//                    }
//                    fileWriter.write(System.lineSeparator());
//                }
//            }
//    }


