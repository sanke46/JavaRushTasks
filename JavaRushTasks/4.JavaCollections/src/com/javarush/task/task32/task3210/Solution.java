package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        long number = Integer.parseInt(args[1]);
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        byte[] bite = new byte[text.length()];
        raf.seek(number);
        raf.read(bite,0,bite.length);
        String lineFormFile = new String(bite);
        String resultText = lineFormFile.equals(text) ? "true" : "false";
        raf.seek(raf.length());
        raf.write(resultText.getBytes());

    }
}
