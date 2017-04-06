package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if(string == null) throw new TooShortStringException();

        int one = 0;
        int two = 0;

        while ((two = string.indexOf(" ",two)) != -1){
            one++;
            two++;
            if (one > 4) {
                break;
            }
        }

        if(one < 4) throw new TooShortStringException();
        if(one == 4) two = string.length()+1;

        return string.substring(string.indexOf(" ") + 1, two - 1);
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
