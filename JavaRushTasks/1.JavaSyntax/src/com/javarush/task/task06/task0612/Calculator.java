package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код
        return a + b;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        return a - b;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        return a * b;
    }

    public static double division(int a, int b) {
        //напишите тут ваш код
        return a * 1f / b * 1f;
    }

    public static double percent(int a, int b) {
        //напишите тут ваш код
        return (double)(a * b) / 100;
    }

    public static void main(String[] args) {
        System.out.println(plus(4,2));
        System.out.println(minus(4,2));
        System.out.println(multiply(4,2));
        System.out.println(division(4,2));
        System.out.println(percent(4,2));
    }
}