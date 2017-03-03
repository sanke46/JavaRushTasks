package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int counter = 0;

        while(true){
            int number = Integer.parseInt(reader.readLine());
            if(number == -1){
                break;
            }
            result += number;
            counter++;
        }

        reader.close();
        System.out.println((double)result/(double) counter);
    }
}

