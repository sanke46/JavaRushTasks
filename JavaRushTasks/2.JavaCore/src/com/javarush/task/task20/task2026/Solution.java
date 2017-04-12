package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {

    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {

        // remove liner
        for (int i = 0; i < a.length ; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if(a[i][j] == 1 && a[i][j+1] == 1){
                    a[i][j] = 0;
                }
            }
        }

        //remove verticly
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[i][j] == 1 && a[i + 1][j] == 1){
                    a[i][j] = 0;
                }
            }
        }

        int count = 0;

        //count
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[i][j] == 1){
                    count++;
                }
            }
        }


        return count;
    }
}
