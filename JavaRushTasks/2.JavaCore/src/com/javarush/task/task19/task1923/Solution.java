package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

        while(fileReader.ready()){
            String line = fileReader.readLine();
            String[] lineArr = line.split(" ");

            for (int i = 0; i < lineArr.length ; i++) {
                if(lineArr[i].matches(".+[0-9].+")){
                    fileWriter.write(lineArr[i] + " ");
                }
            }
        }

        fileReader.close();
        fileWriter.close();

    }
}
