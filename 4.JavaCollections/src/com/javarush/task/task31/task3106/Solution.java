package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipInputStream;


/*
Разархивируем файл
*/
public class Solution {


    public static void main(String[] args) throws IOException {
        // нормальное рабочее решение, которое не принимает валидатор

//        File temp = Files.createTempFile("tmp-",".tmp").toFile();
//        try (FileOutputStream outputStream = new FileOutputStream(temp)){
//        for (int i=1;i<args.length;i++){
//            Files.copy(Paths.get(args[i]),outputStream);
//        }
//    }
//    try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(temp));
//    FileOutputStream fileOutputStream = new FileOutputStream(args[0])){
//        ZipEntry entry = zipInputStream.getNextEntry();
//        byte[] buffer = new byte[1024];
//        int length;
//        while ((length=zipInputStream.read(buffer))>0){
//            fileOutputStream.write(buffer,0,length);
//        }
//
//    }

        // тоже нормально работает, но не принимает!!!
//        List<FileInputStream> list = new ArrayList<>();
//        for (int i=1;i<args.length;i++){
//            list.add(new FileInputStream(args[i]));
//        }
//        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(list));
//        ZipInputStream zipInputStream = new ZipInputStream(sequenceInputStream);
//        FileOutputStream fileOutputStream = new FileOutputStream(args[0]);
//        ZipEntry zipEntry = zipInputStream.getNextEntry();
//        while (zipEntry!=null){
//            int lengh;
//            byte[] buffer = new byte[1024];
//            while ((lengh=zipInputStream.read(buffer))>0){
//                fileOutputStream.write(buffer,0,lengh);
//            }
//            zipEntry=zipInputStream.getNextEntry();
//        }
//        sequenceInputStream.close();
//        zipInputStream.close();
//        fileOutputStream.close();
        // Это решение позаимствовано отсюда
        // https://www.snip2code.com/Snippet/1178691/Level-31--Lesson-06--Bonus-01

        String resultFileName = args[0];
        int filePartCount = args.length - 1;
        String[] fileNamePart = new String[filePartCount];
        for (int i = 0; i < filePartCount; i++) {
            fileNamePart[i] = args[i + 1];
        }



        Arrays.sort(fileNamePart);

        List<FileInputStream> fisList = new ArrayList<>();
        for (int i = 0; i < filePartCount; i++) {
            fisList.add(new FileInputStream(fileNamePart[i]));
        }
        SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(fisList));
        ZipInputStream zipInStream = new ZipInputStream(seqInStream);
        FileOutputStream fileOutStream = new FileOutputStream(resultFileName);
        byte[] buf = new byte[1024 * 1024];
        while (zipInStream.getNextEntry() != null) {
            int count;
            while ((count = zipInStream.read(buf)) != -1) {
                fileOutStream.write(buf, 0, count);
            }
        }
        seqInStream.close();
        zipInStream.close();
        fileOutStream.close();
    }



    }


