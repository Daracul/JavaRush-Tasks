package com.javarush.task.task31.task3111;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize=0;
    private int maxSize=0;
    private List<Path> foundFiles=new ArrayList<>();


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean isTrue=true;
        if (partOfName!=null){
            if (!find(file)){
                isTrue=false;
            }
        }
        if (partOfContent!=null){
            if (!findInContent(file)){
                isTrue=false;
            }
        }
        if (maxSize>0){
            if (attrs.size()>maxSize){
                isTrue=false;
            }
        }
        if (minSize>0){
            if (attrs.size()<minSize){
                isTrue=false;
            }
        }

        if (isTrue)foundFiles.add(file);
        return FileVisitResult.CONTINUE;
    }


    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
    private boolean find(Path path) {
        if (path.getFileName().toString().contains(partOfName)){
            return true;
        }
        return false;
    }
    private boolean findInContent (Path path){
        try {
            try (Scanner scanner = new Scanner(path)){
                String line;
                while (scanner.hasNext()){
                    line=scanner.nextLine();
                    if (line.contains(partOfContent)){
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
