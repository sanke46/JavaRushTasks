package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;

        ByteArrayOutputStream arrOut = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(arrOut);
        System.setOut(stream);

        testString.printSomething();

        String result = arrOut.toString();
        System.setOut(printStream);


        StringBuilder strBuilder = new StringBuilder(result);
        String[] number = strBuilder.toString().split(" ");
        int resultInt = 0;

        if(number[1].equals("+")){
            resultInt = Integer.parseInt(number[0]) + Integer.parseInt(number[2]);
        } else if(number[1].equals("-")){
            resultInt = Integer.parseInt(number[0]) - Integer.parseInt(number[2]);
        } else if(number[1].equals("*")){
            resultInt = Integer.parseInt(number[0]) * Integer.parseInt(number[2]);
        }

        String strResult = strBuilder.toString() + String.valueOf(resultInt);

        System.out.println(strResult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

