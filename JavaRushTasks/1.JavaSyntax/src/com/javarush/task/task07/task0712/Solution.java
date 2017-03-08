package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        int countMax = 0;
        int countMin = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        ArrayList<String> arrString = new ArrayList<String>(10);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // fill array
        for (int i = 0; i < 10 ; i++) {
            arrString.add(reader.readLine());
        }
        reader.close();

        // find the longest and the shortest String
        for (int i = 0; i < arrString.size(); i++) {
            if(arrString.get(i).length() > max){
                max = arrString.get(i).length();
                countMax = i;
            }

            if(arrString.get(i).length() < min){
                min = arrString.get(i).length();
                countMin = i;
            }
        }

        //find same length
        System.out.println((countMax < countMin) ? arrString.get(countMax) : arrString.get(countMin));

    }
}
