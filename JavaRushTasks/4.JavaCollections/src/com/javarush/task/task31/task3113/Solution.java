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

    private static int fileQuantity;
    private static int folderQuantity;
    private static int totalLength;
    private static Path source;

    public static void main(String[] args) throws IOException {

        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        String folderOfFile = reader.readLine();
        source = Paths.get(folderOfFile);

        if (!Files.isDirectory(source)) {
            System.out.println(source.toAbsolutePath().toString() + " - не папка");
        } else {
            Files.walkFileTree(source, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    fileQuantity++;
                    totalLength += attrs.size();
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    folderQuantity++;
                    return FileVisitResult.CONTINUE;
                }
            });
        }

        System.out.format("Всего папок - %d%n", folderQuantity-1);
        System.out.format("Всего файлов - %d%n", fileQuantity);
        System.out.format("Общий размер - %d%n", totalLength);
    }
}
