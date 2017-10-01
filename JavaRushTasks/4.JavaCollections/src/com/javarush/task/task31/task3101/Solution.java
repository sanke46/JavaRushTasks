package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {

    private static List<File> fileList = new ArrayList<>();

    public static void main(String[] args) {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File outPutFile = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, outPutFile);

        try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outPutFile))) {
            getFileList(path);
            fileList.sort(new Comparator<File>() {

                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

            for (File f : fileList) {
                try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(f))) {
                    byte[] content = new byte[inputStream.available()];
                    inputStream.read(content);
                    output.write(content, 0, content.length);
                    output.write('\n');
                } catch (IOException e) {

                }
            }
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getFileList(File file) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    getFileList(f);
                } else {
                    if (f.length() > 50) {
                        FileUtils.deleteFile(f);
                    } else {
                        fileList.add(f);
                    }
                }
            }
        }
    }
}
