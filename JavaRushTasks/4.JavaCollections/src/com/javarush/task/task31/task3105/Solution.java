package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String sourceFile = args[0];
        String sourceZipFile = args[1];
        File file = new File(sourceFile);

        Map<String, ByteArrayOutputStream> archiveFiles = new HashMap<>();

        try (ZipInputStream zipReader = new ZipInputStream(new FileInputStream(sourceZipFile))) {
            ZipEntry entry;

            while ((entry = zipReader.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;

                while ((count = zipReader.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, count);
                }
                archiveFiles.put(entry.getName(),byteArrayOutputStream);
            }

        }

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(sourceZipFile))) {
            for (Map.Entry<String, ByteArrayOutputStream> pair : archiveFiles.entrySet()) {
                if(pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1).equals(file.getName())){
                    continue;
                }
                zipOutputStream.putNextEntry(new ZipEntry(pair.getKey()));
                zipOutputStream.write(pair.getValue().toByteArray());
            }

            ZipEntry zipEntry = new ZipEntry("new/" + file.getName());
            zipOutputStream.putNextEntry(zipEntry);
            Files.copy(file.toPath(), zipOutputStream);
        }
    }
}
