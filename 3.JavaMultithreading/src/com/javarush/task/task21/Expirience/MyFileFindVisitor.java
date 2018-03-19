package com.javarush.task.task21.Expirience;

/**
 * Created by AMalakhov on 19.07.2017.
 */
        import java.io.IOException;
        import java.nio.file.*;
        import java.nio.file.attribute.*;

class MyFileFindVisitor extends SimpleFileVisitor<Path> {
    private PathMatcher matcher;

    public MyFileFindVisitor(String pattern) {
        try {
            matcher = FileSystems.getDefault().getPathMatcher(pattern);
        } catch (IllegalArgumentException iae) {
            System.err
                    .println("Invalid pattern; did you forget to prefix \"glob:\" or \"regex:\"?");
            System.exit(1);
        }

    }

    public FileVisitResult visitFile(Path path,
                                     BasicFileAttributes fileAttributes) {
        find(path);
        return FileVisitResult.CONTINUE;
    }

    private void find(Path path) {
        Path name = path.getFileName();
        if (matcher.matches(name))
            System.out.println("Matching file:" + path.getFileName());
    }

    public FileVisitResult preVisitDirectory(Path path,
                                             BasicFileAttributes fileAttributes) {
        find(path);
        return FileVisitResult.CONTINUE;
    }
}

 class Test13 {
    public static void main(String[] args) {
        Path startPath = Paths.get("D:\\pack");

        //Строка с glob-шаблоном
        String pattern = "glob:*crypt*";

        //Строка с regex-шаблоном
        //String pattern = "regex:\\S+\\.java";

        try {
            Files.walkFileTree(startPath, new MyFileFindVisitor(pattern));
            System.out.println("File search completed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}