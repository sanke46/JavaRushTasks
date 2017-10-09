package com.javarush.task.task31.task3106;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {

    private Properties properties;

    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];
        String[] fileNamePart = new String[args.length - 1];

        for (int i = 0; i < args.length - 1; i++) {
            fileNamePart[i] = args[i + 1];
        }
        Arrays.sort(fileNamePart);

        List<FileInputStream> fileInputList = new ArrayList<>();
        for (int i = 0; i < args.length - 1; i++) {
            fileInputList.add(new FileInputStream(fileNamePart[i]));
        }

        SequenceInputStream sequenceInStream = new SequenceInputStream(Collections.enumeration(fileInputList));
        ZipInputStream zipInStream = new ZipInputStream(sequenceInStream);
        FileOutputStream fileOutStream = new FileOutputStream(resultFileName);
        byte[] buffer = new byte[1024 * 1024];
        while (zipInStream.getNextEntry()!=null){
            int count;
            while ((count=zipInStream.read(buffer)) != -1){
                fileOutStream.write(buffer,0,count);
            }
        }
        sequenceInStream.close();
        zipInStream.close();
        fileOutStream.close();
    }
}
