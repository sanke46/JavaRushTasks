package com.javarush.task.task31.task3107;

import java.nio.file.Files;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            Boolean isHidden = Files.isHidden(Paths.get(pathToFile));
            Boolean isExecitable = Files.isExecutable(Paths.get(pathToFile));
            Boolean isDirectory = Files.isDirectory(Paths.get(pathToFile));
            Boolean isWritable = Files.isWritable(Paths.get(pathToFile));
            fileData = new ConcreteFileData(isHidden,isExecitable,isDirectory,isWritable);
        } catch (Exception e) {
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
