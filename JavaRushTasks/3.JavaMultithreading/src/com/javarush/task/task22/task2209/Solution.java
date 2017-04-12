package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        //...
        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        scanner.close();
        ArrayList<String> array = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                String l = reader.readLine();
                String[] str = l.split(" ");
                for (String s : str) {
                    array.add(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] s = new String[array.size()];

        for (int i = 0; i < array.size(); i++) {
            s[i] = array.get(i);
        }

        StringBuilder result = getLine(s);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        List<String> arr = Arrays.asList(words);
        Collections.sort(arr);
        char last;
        char prev;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.size() - 1; i++) {
            last = arr.get(i).charAt(arr.get(i).length() - 1);

            for (int j = i + 1; j < arr.size(); j++) {
                prev = arr.get(j).toLowerCase().charAt(0);

                if (last == prev) {
                    String temp = arr.get(i + 1);
                    arr.set(i + 1, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        for (int i = 0; i < arr.size(); i++) {

            if (i != arr.size() - 1) {
                sb.append(arr.get(i));
                sb.append(" ");
            } else {
                sb.append(arr.get(i));
            }
        }
        return sb;
    }
}

