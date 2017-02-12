package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));
        String xResult = "";

        while (fileReader.ready()) {
            int x = fileReader.read();
            xResult += (char)x;
        }

        xResult = xResult.replaceAll("\\p{Punct}","");
        fileWriter.write(xResult);

        fileReader.close();
        fileWriter.close();
    }


}
