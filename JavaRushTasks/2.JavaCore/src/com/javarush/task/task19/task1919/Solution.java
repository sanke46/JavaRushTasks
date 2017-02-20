package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        Map<String, Double> map = new TreeMap<String, Double>();

        while (fileReader.ready()){
            String[] splitStr = fileReader.readLine().split(" ");
            if(map.containsKey(splitStr[0])){
                double sumNumber = map.get(splitStr[0]) + Double.parseDouble(splitStr[1]);
                map.put(splitStr[0], Double.valueOf(sumNumber));
            } else {
                map.put(splitStr[0], Double.valueOf(splitStr[1]));
            }
        }



        for (Map.Entry<String, Double> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        fileReader.close();
    }
}
