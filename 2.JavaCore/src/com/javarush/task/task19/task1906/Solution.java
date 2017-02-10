package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName);
        FileWriter fileWriter = new FileWriter(fileName2);
        int count = 0;

        while (fileReader.ready()){
            int x = fileReader.read();
            count++;
            if(count%2 == 0) {
                fileWriter.write(x);
            }
        }

        fileReader.close();
        fileWriter.close();
    }
}
