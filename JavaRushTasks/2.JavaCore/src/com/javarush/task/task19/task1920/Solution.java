package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {



    public static void main(String[] args) throws IOException {

        String nameMax = "";
        double numberMax = 0;

        String fileName = args[0];
        BufferedReader readerFile = new BufferedReader(new FileReader(fileName));
        Map<String, Double> map = new TreeMap<String, Double>();

        while (readerFile.ready()){
            String[] splitStr = readerFile.readLine().split(" ");
            if(map.containsKey(splitStr[0])){
                double plus = map.get(splitStr[0]) + Double.parseDouble(splitStr[1]);
                map.put(splitStr[0], plus);

                if(map.get(splitStr[0]) > numberMax){
                    numberMax = map.get(splitStr[0]);
                }

            } else {
                map.put(splitStr[0], Double.valueOf(splitStr[1]));

                if(map.get(splitStr[0]) > numberMax){
                    numberMax = map.get(splitStr[0]);
                }
            }
        }

        NameOfTheBest(map,numberMax);

        readerFile.close();
        System.out.println(nameMax);

    }

    public static void NameOfTheBest(Map<String, Double> map , Double nummberMax){
        String nameBest;
        Double numberOfBest;
        ArrayList<String> arrList = new ArrayList<String>();

        for(Map.Entry<String, Double> pair : map.entrySet()){
            if(pair.getValue().equals(nummberMax)){
                arrList.add(pair.getKey());
            }
        }

        for(String x : arrList) {
            System.out.println(x);
        }
    }
}
