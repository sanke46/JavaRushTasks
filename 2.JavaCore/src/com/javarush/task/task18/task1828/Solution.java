package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        //String[] arg = {"-d","19847983"};
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        if(args[0] == "-u"){

            String id = setSpace(args[1],8);
            String productName = setSpace(args[2],30);
            String price = setSpace(args[3],8);
            String quantity = setSpace(args[4],4);

            String allLine = id + productName + price + quantity;

            ArrayList<String> fileArray = fileInArray(fileName);
            fileArray = setFileLine(fileArray,id,allLine);
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName,false));
            for(String x : fileArray){
                fileWriter.write(x);
                fileWriter.newLine();
            }
            fileWriter.close();

        } else if(args[0] == "-d") {
            String id = setSpace(args[1],8);
            ArrayList<String> fileList2 = fileInArray(fileName);
            fileList2 = removeById(fileList2,id);
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName,false));
            for(String x : fileList2){
                fileWriter.write(x);
                fileWriter.newLine();
            }
            fileWriter.close();
        }
    }

    private static String setSpace(String strArgs, int number){

        char[] charArray = strArgs.toCharArray();
        String resultString = strArgs;

        if(charArray.length <= number) {
            for (int i = 0; i < (number - charArray.length); i++) {
                resultString += " ";
            }
        } else {
            for (int i = 0; i < number; i++) {
                String fullStr = null;
                fullStr += String.valueOf(charArray[i]);
                resultString = fullStr;
            }
        }

        return resultString;
    }

    private static ArrayList<String> fileInArray(String fileName) throws IOException {
        BufferedReader readerFile = new BufferedReader(new FileReader(fileName));
        ArrayList<String> arr = new ArrayList<String>();


        while (readerFile.ready()) {
            String itrLine = readerFile.readLine();
            arr.add(itrLine);
        }

        readerFile.close();
        return arr;
    }

    private static ArrayList<String> setFileLine(ArrayList<String> arr,String id, String setLine){
        for (int i = 0; i < arr.size(); i++) {
            String idInArray = arr.get(i).substring(0,8);
            if(idInArray.equals(id)){
                arr.set(i,setLine);
            }
            System.out.println(arr.get(i));
        }
        return arr;
    }

    private static ArrayList<String> removeById(ArrayList<String> arr, String id){
        for (int i = 0; i < arr.size() ; i++) {
            String listId = arr.get(i).substring(0,8);
            if(listId.equals(id)){
                arr.remove(arr.get(i));
            }
        }
        return arr;
    }

}
