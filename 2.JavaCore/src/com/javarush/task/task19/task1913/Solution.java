package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream printStream = System.out;

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(arrayOutputStream);
        System.setOut(stream);

        testString.printSomething();

        String result = arrayOutputStream.toString();
        System.setOut(printStream);

        StringBuilder str = new StringBuilder(result);
        String resultStr = str.toString().replaceAll("[a-zA-Z]", "").replaceAll("\\p{Punct}","").replaceAll(" ", "").replaceAll("\\n","");

        System.out.println(resultStr);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
