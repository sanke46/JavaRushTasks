package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] arr = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfBuildings = 15;
        int evenNumber = 0;
        int oddNumber = 0;

        // put number rooms in HashMap
        for (int i = 0; i < numberOfBuildings; i++) {
            int x = Integer.parseInt(reader.readLine());
            arr[i] = x;
        }
        reader.close();

        // even and odd
        for(int i = 0; i < numberOfBuildings; i++){
            if(i == 0){
                evenNumber += arr[i];
            } else if(i % 2 == 0){
                evenNumber += arr[i];
            } else {
                oddNumber += arr[i];
            }
        }

        //who is win ?
        String odd = "В домах с нечетными номерами проживает больше жителей.";
        String even = "В домах с четными номерами проживает больше жителей.";
        System.out.println((evenNumber > oddNumber) ? even : odd);
    }
}
