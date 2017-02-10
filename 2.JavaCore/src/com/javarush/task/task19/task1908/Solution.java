package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        int count = 0;
        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2);
        StringBuilder str = new StringBuilder();

        while (fileReader.ready()){
            int x = fileReader.read();
            str.append(((char)x));
        }

        for (int i = 0; i < str.length() ; i++) {
            if(str.toString().contains(String.valueOf(i))){
                count++;
            }
        }

        System.out.println(count);
    }
}
