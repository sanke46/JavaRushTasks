package com.javarush.task.task19.task1911;

/*
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream stream = System.out;

        ByteArrayOutputStream arr = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(arr);

        System.setOut(ps);

        testString.printSomething();

        String str = arr.toString();
        System.setOut(stream);

        StringBuilder strBuilder = new StringBuilder(str);
        String strResult = strBuilder.toString().toUpperCase();
        System.out.println(strResult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
