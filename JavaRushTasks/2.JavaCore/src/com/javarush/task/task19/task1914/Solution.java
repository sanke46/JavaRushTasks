package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream stream = System.out;
        ByteArrayOutputStream arr = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(arr);

        System.setOut(print);

        testString.printSomething();

        String str = arr.toString();

        System.setOut(stream);

        String[] arrStr = str.replaceAll("\n", "").split(" ");
        int numberResult = 0;

        if(arrStr[1].equals("+")){
            numberResult = Integer.parseInt(arrStr[0]) + Integer.parseInt(arrStr[2]);
        } else if(arrStr[1].equals("-")){
            numberResult = Integer.parseInt(arrStr[0]) - Integer.parseInt(arrStr[2]);
        } else if(arrStr[1].equals("*")){
            numberResult = Integer.parseInt(arrStr[0]) * Integer.parseInt(arrStr[2]);
        }

        System.out.println(arrStr[0] + " " + arrStr[1] + " " + arrStr[2] + " " + arrStr[3] + " " + numberResult);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

