package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        load(new FileInputStream(fileName));
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();

        for (Map.Entry<String,String> pair : properties.entrySet()){
            prop.put(pair.getKey(),pair.getValue());
        }

        prop.save(outputStream,"saved");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);

        properties.clear();
        for(Map.Entry<Object,Object> pair : prop.entrySet()){
            properties.put((String) pair.getKey(),(String) pair.getValue());
        }
    }

    public static void main(String[] args) {

    }
}
