package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder str = new StringBuilder();

        while(fileReader.ready()){
            String line = fileReader.readLine();
            String[] lineArr = line.split(" ");

            for (int i = 0; i < lineArr.length; i++) {
                if(lineArr[i].length() > 6){
                    str.append(lineArr[i]+ ",");
                }
            }
        }

        fileWriter.write(str.toString().substring(0,str.length()-1));
        fileReader.close();
        fileWriter.close();
    }
}
