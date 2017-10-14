package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {

        int whereRandomNumber = (int) (Math.random() * 8);
        int randomNumber = (int) (Math.random() * 9 + 48);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        for (int i = 0; i < 8; i++) {
            if(whereRandomNumber == i) {
                byteArrayOutputStream.write(randomNumber);
            } else if (i % 2 == 0) {
                byteArrayOutputStream.write((int) (Math.random() * 25 + 65));
            } else {
                byteArrayOutputStream.write((int) (Math.random() * 25 + 97));
            }
        }

        return byteArrayOutputStream;
    }
}