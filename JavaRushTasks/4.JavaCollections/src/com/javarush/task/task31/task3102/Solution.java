package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {

    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        List<File> stack = new ArrayList<>();
        File folder = new File(root);

        stack.add(folder);

        while (!stack.isEmpty()){
            File file = stack.get(0);
            if (file.isDirectory()){
                for (File file1 : file.listFiles()){
                    stack.add(file1);
                }
            } if (file.isFile()){
                list.add(file.getAbsolutePath());
            }
            stack.remove(0);
        }


        return list;
    }

    public static void main(String[] args) {
        
    }
}
