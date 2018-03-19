package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;

import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String testFile=args[0];
        String testZip=args[1];
        File file = new File(testFile);
        //вытаскиваем файлы из архива
        HashMap<String,ByteArrayOutputStream> map = new HashMap<>();
        try(FileInputStream fileInputStream = new FileInputStream(testZip);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);) {
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            while (zipEntry != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int length;
                byte[] buffer = new byte[1024];
                String fileName = zipEntry.getName();
                while ((length = zipInputStream.read(buffer)) > 0) {
                    byteArrayOutputStream.write(buffer, 0, length);
                }
                map.put(fileName, byteArrayOutputStream);
                zipEntry = zipInputStream.getNextEntry();
            }
        }


        // добавляем файл в архив

        try (ZipOutputStream zipWriter = new ZipOutputStream(new FileOutputStream(testZip))){
            for (String key:map.keySet()){
                if (key.substring(key.lastIndexOf("/")+1).equals(file.getName()))continue;
                else zipWriter.putNextEntry(new ZipEntry(key));
                zipWriter.write(map.get(key).toByteArray());
            }

            ZipEntry zipEntry = new ZipEntry("new/"+file.getName());
            zipWriter.putNextEntry(zipEntry);

            Files.copy(file.toPath(),zipWriter);

        }




    }

}
