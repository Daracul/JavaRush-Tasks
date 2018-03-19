package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://yastatic.net/morda-logo/i/citylogos/yandex19-logo-ru.png", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {

        URL url=new URL(urlString);
        InputStream inputStream=url.openStream();
        Path tmp=Files.createTempFile("temp-",".tmp");
        Files.copy(inputStream,tmp);
        String fileName=urlString.substring(urlString.lastIndexOf("/"));
        String dir=downloadDirectory.toString();
        Path moveTo=Paths.get(dir+fileName);
        Files.move(tmp,moveTo);
        return Paths.get(downloadDirectory.toString()+urlString.substring(urlString.lastIndexOf("/")));


// мое решение тут, но валидатор не принимал
//        URL url = new URL(urlString);
//        InputStream inputStream = url.openStream();
//        Path tempFile = Files.createTempFile("temp-",".tmp");
//        Files.copy(inputStream, tempFile);
//        String fileName = url.toString().substring(url.toString().lastIndexOf("/"));
//        Path filePath = Paths.get(downloadDirectory.toString(),fileName);
//        Files.move(tempFile,filePath);
//        return filePath;
        // implement this method
    }
}
