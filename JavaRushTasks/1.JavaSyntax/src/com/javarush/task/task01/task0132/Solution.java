package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int firstNumber = number/100;
        int secondNumber = (number/10)-(firstNumber * 10);
        int thirdNumber = number - ((number/10)*10);
        return firstNumber + secondNumber + thirdNumber;
    }
}