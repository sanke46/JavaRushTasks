package com.javarush.task.task19.task1908;

/* 
Выделяем числа
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

        StringBuilder str = new StringBuilder();
        StringBuilder strResult = new StringBuilder();

        while (fileReader.ready()){
            int x = fileReader.read();
            str.append((char)x);
        }

        fileReader.close();
        String[] strArray = str.toString().split(" ");

        for (int i = 0; i < strArray.length ; i++) {
            if(catchNumber(strArray[i])){
                strResult.append(strArray[i] + " ");
            }
        }

        fileWriter.write(String.valueOf(strResult));
        fileWriter.close();
    }

    public static boolean catchNumber(String x){
        boolean result;
        try {
            Integer.parseInt(x);
            result = true;
        } catch (NumberFormatException e){
            result = false;
        }
        return result;
    }
}
