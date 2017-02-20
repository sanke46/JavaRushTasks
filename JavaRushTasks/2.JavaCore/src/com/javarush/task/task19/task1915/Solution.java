package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        PrintStream print = System.out;

        ByteArrayOutputStream arr = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(arr);

        System.setOut(stream);
        testString.printSomething();

        String str =  arr.toString();
        System.setOut(print);

        FileOutputStream fileWriter = new FileOutputStream(fileName);
        PrintWriter prWrite = new PrintWriter(fileWriter);
        prWrite.write(str);
        fileWriter.close();
        prWrite.close();
        System.out.println(str);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

