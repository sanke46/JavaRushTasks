package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> names = new ArrayList<>();
        String fileName;
        while(!(fileName = reader.readLine()).equals("exit")){
            names.add(fileName);
        }

        for(String s : names){
            new ReadThread(s).start();
        }

        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName ;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {

                try {
                    FileInputStream fileIn = new FileInputStream(fileName);
                    HashMap<Integer, Integer> histMap = new HashMap<Integer, Integer>();
                    byte[] fileBytes = new byte[fileIn.available()];
                    int max = 1;
                    int maxByte = 0;

                    while (fileIn.available() > 0) {
                        fileIn.read(fileBytes);
                    }

                    for (int i = 0; i < fileBytes.length; i++) {
                        int byteName = (int) fileBytes[i];
                        if (histMap.containsKey(byteName)) {

                            int hit = histMap.get(byteName) + 1;
                            if (hit > max) {
                                max = hit;
                                maxByte = byteName;
                            }
                            histMap.put(byteName, hit);
                        } else {
                            histMap.put(byteName, 1);
                        }
                    }
                    fileIn.close();
                    resultMap.put(fileName, maxByte);

                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }

        }
    }
}
