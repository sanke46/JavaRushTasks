package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));
        String str = "";

        while (fileReader.ready()){
            int x = fileReader.read();
            str = String.valueOf((char) x);
            if(str.equals(".")){
                str = "!";
            }
            fileWriter.write(str);
        }

        fileReader.close();
        fileWriter.close();
    }
}
